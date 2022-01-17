import model.RegisterGenre;
import org.testng.Assert;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;


import java.util.List;

public class GenreTest {


    @Test(priority = 1)
    public void testRestAssuredPostGenre() {
        Specification.installSpecification(Specification.requestSpec("http://localhost:8080/api/library"), Specification.responseSpec201());

        RegisterGenre newGenre = new RegisterGenre(42, "m2yGen", "this is new genre");

        RegisterGenre genre = given().body(newGenre).when().post("/genre")
                .then().log().all().extract().as(RegisterGenre.class);

        System.out.println(genre);

    }

    @Test(priority = 2)
    public void testRestAssuredNegativePostGenre() {
        Specification.installSpecification(Specification.requestSpec("http://localhost:8080/api/library"), Specification.responseSpec409());

        RegisterGenre newGenre = new RegisterGenre(42, "m2yGen", "this is new genre");

        RegisterGenre genre = given().body(newGenre).when().post("/genre")
                .then().log().all().extract().as(RegisterGenre.class);

        System.out.println(genre);

    }

    @Test(priority = 2)
    public void testRestAssuredPutGenre() {
        Specification.installSpecification(Specification.requestSpec("http://localhost:8080/api/library"), Specification.responseSpec200());

        RegisterGenre newGenre = new RegisterGenre(42, "m2yGen2", "this is new genre");

        RegisterGenre genre = given().body(newGenre).when().put("/genre")
                .then().log().all().extract().as(RegisterGenre.class);

        System.out.println(genre);

    }


    @Test(priority = 3)
    public void testRestAssuredDeleteGenre() {
        Specification.installSpecification(Specification.requestSpec("http://localhost:8080/api/library/genre"), Specification.responseSpec204());

        int status = given().delete("/42").then().log().all().extract().statusCode();
        Assert.assertEquals(status, 204);

    }

    @Test
    public void testRestAssuredGetGenre() {
        Specification.installSpecification(Specification.requestSpec("http://localhost:8080/"), Specification.responseSpec200());
        List<RegisterGenre> authors = given()
                .when()
                .get("api/library/genres")
                .then()
                .log()
                .all()
                .extract().body().jsonPath().getList("$", RegisterGenre.class);

        authors.forEach(System.out::println);
    }



}
