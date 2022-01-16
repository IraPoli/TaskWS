import io.restassured.RestAssured;
import model.Author;
import model.RegisterGenre;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.google.gson.Gson;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;


import java.util.List;

public class WSTest {
    @Test
    public void testRestAssuredGetAuthors(){
        Specification.installSpecification(Specification.requestSpec("http://localhost:8080/"), Specification.responseSpec200());
        List<Author> authors = given()
                .when()
                .get("api/library/authors")
                .then()
                .log()
                .all()
                .extract().body().jsonPath().getList("$",Author.class);

        authors.forEach(System.out::println);
         authors.forEach(el-> Assert.assertTrue(el.getAuthorId()>0));

    }

    @Test
    public void testRestAssuredGetAuthorById(){
        Specification.installSpecification(Specification.requestSpec("http://localhost:8080/"), Specification.responseSpec200());

        Author  author = given()
                .when()
                .get("api/library/author/62").then().log().all().extract().body().jsonPath().getObject("$",Author.class);

        System.out.println(author);
          Assert.assertTrue(author.getAuthorId() == 62);

    }


    @Test
    public void testRestAssuredPostGenre(){
        Specification.installSpecification(Specification.requestSpec("http://localhost:8080/api/library"),Specification.responseSpec201());

        RegisterGenre newGenre = new RegisterGenre(42,"m2yGen", "this is new genre");

        RegisterGenre genre = given().body(newGenre).when().post("/genre")
                .then().log().all().extract().as(RegisterGenre.class);

        System.out.println(genre);

    }


}
