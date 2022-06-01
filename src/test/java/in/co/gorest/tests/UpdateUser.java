package in.co.gorest.tests;

import in.co.gorest.model.UpdateUserStudentPojo;
import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UpdateUser extends TestBase {

    UpdateUserStudentPojo updateUserStudentPojo = new UpdateUserStudentPojo();

    @Test
    public void updateUser(){
        updateUserStudentPojo.setEmail("pina@gmail.com");
        Response response = given()
                .body(updateUserStudentPojo)
                .when()
                .patch("public/v2/users/2669");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
