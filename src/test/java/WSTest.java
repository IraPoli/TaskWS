import model.Author;
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


}
