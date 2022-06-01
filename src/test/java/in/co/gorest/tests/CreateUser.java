package in.co.gorest.tests;

import in.co.gorest.model.CreateUserStudentPojo;
import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.certificate;
import static io.restassured.RestAssured.given;

public class CreateUser extends TestBase {
    CreateUserStudentPojo createUserStudentPojo = new CreateUserStudentPojo();

    @Test
    public void createUser(){
        createUserStudentPojo.setName("Patrick Law123123");
        createUserStudentPojo.setGender("Male");
        createUserStudentPojo.setEmail("Patrick.law123123@gmail.com");
        createUserStudentPojo.setStatus("active");
        Response response = given()

                .body(createUserStudentPojo)
                .header("contentType","application/json")
                .when()
                .post("public/v2/users");


        response.then().statusCode(201);
        response.prettyPrint();

    }
}
