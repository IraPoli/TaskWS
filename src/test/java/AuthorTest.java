import model.Author;
import model.RegisterAuthor;
import model.RegisterGenre;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class AuthorTest {
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


    @Test(priority = 1)
    public void testRestAssuredPostAuthor(){
        Specification.installSpecification(Specification.requestSpec("http://localhost:8080"),Specification.responseSpec201());


        RegisterAuthor newAuthor =  new RegisterAuthor(500, "Ivan", "Franco","Ukraine", "1856-06-27", "Ukraine", "Naguevychi", "social and literary critic, journalist, interpreter, economist, political activist, doctor of philosophy, ethnographer, and the author of the first detective novels and modern poetry in the Ukrainian language.");

        RegisterGenre genre = given().body(newAuthor).when().post("/api/library/author")
                .then().log().all().extract().as(RegisterGenre.class);

        System.out.println(genre);

    }

    @Test(priority = 2)
    public void testRestAssuredNegativePostGenre(){
        Specification.installSpecification(Specification.requestSpec("http://localhost:8080"),Specification.responseSpec409());

        RegisterAuthor newAuthor =  new RegisterAuthor(500, "Ivan", "Franco","Ukraine", "1856-06-27", "Ukraine", "Naguevychi", "social and literary critic, journalist, interpreter, economist, political activist, doctor of philosophy, ethnographer, and the author of the first detective novels and modern poetry in the Ukrainian language.");

        RegisterGenre genre = given().body(newAuthor).when().post("/api/library/author")
                .then().log().all().extract().as(RegisterGenre.class);

        System.out.println(genre);

    }

    @Test(priority = 2)
    public void testRestAssuredPutAuthor(){
        Specification.installSpecification(Specification.requestSpec("http://localhost:8080"), Specification.responseSpec200());

        RegisterAuthor newAuthor =  new RegisterAuthor(500, "Ivan", "Franco","Ukraine", "1856-06-27", "Ukraine", "Naguevychi", "was Ukraine poet, social and literary critic, journalist, interpreter, economist, political activist, doctor of philosophy, ethnographer, and the author of the first detective novels and modern poetry in the Ukrainian language.");

        RegisterGenre genre = given().body(newAuthor).when().put("/api/library/author")
                .then().log().all().extract().as(RegisterGenre.class);

        System.out.println(genre);

    }

    @Test(priority = 3)
    public void testRestAssuredDeleteAuthor(){
        Specification.installSpecification(Specification.requestSpec("http://localhost:8080"),Specification.responseSpec204());

        int status = given().delete("/api/library/author/500").then().log().all().extract().statusCode();
        Assert.assertEquals(status,204);

    }
}
