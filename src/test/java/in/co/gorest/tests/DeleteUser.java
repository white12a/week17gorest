package in.co.gorest.tests;

import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class DeleteUser  extends TestBase {

 @Test
         public void deleteUser() {
     Response response = given()
             .contentType("application/json")
             .header("Authorization","cea28846c268f54d01fa8cbae21f3eeec1353288c0fe2c45d1ee0cbaa0d2d9d3")
             .when()
             .delete("");
response.then().statusCode(204);
response.prettyPrint();
 }
}






