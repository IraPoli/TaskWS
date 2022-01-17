import model.Book;
import model.RegisterGenre;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class BookTest {

    @Test
    public void testRestAssuredGetGenre() {
        Specification.installSpecification(Specification.requestSpec("http://localhost:8080/"), Specification.responseSpec200());
        List<Book> books = given()
                .when()
                .get("api/library/books")
                .then()
                .log()
                .all()
                .extract().body().jsonPath().getList("$", Book.class);

        books.forEach(System.out::println);
    }

    @Test(priority = 1)
    public void testRestAssuredPostAuthor() {
        Specification.installSpecification(Specification.requestSpec("http://localhost:8080"), Specification.responseSpec201());


        Book newBook = new Book(33,"Story","english", "some book",1990);

        RegisterGenre genre = given().body(newBook).when().post("/api/library/book/114/1309")
                .then().log().all().extract().as(RegisterGenre.class);

        System.out.println(genre);

    }

    @Test(priority = 2)
    public void testRestAssuredPutAuthor() {
        Specification.installSpecification(Specification.requestSpec("http://localhost:8080"), Specification.responseSpec200());


        Book newBook = new Book(33,"NewStory","english", "some book",1990);

        RegisterGenre genre = given().body(newBook).when().put("/api/library/book")
                .then().log().all().extract().as(RegisterGenre.class);

        System.out.println(genre);

    }

    @Test(priority = 3)
    public void testRestAssuredDeleteGenre() {
        Specification.installSpecification(Specification.requestSpec("http://localhost:8080"), Specification.responseSpec204());

        int status = given().delete("/api/library/book/33").then().log().all().extract().statusCode();
        Assert.assertEquals(status, 204);

    }

    @Test(priority = 4)
    public void testRestAssuredNegativeDeleteGenre() {
        Specification.installSpecification(Specification.requestSpec("http://localhost:8080"), Specification.responseSpec404());

        int status = given().delete("/api/library/book/33").then().log().all().extract().statusCode();
        Assert.assertEquals(status, 404);

    }
}
