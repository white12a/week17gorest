package in.co.gorest.tests;

import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ListUsers extends TestBase {

    @Test
    public void listUsers(){
        Response response = given()
                .when()
                .get("public/v2/users");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
