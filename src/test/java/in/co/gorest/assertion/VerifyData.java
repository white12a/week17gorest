package in.co.gorest.assertion;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class VerifyData {
    static ValidatableResponse response;

    @Before
    public void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/";
        response = given()
                .when()
                .get("public/v2/users")
                .then().statusCode(200);

    }

    @Test
    public void verifyEmailId() {
        String emailId = response.extract().path("[1].email");
        Assert.assertEquals("", "laxman_iyer@jenkins.biz", emailId);
        System.out.println("email : " + emailId);
    }
    @Test
    public void verifyTotalRecords(){
        List<Integer> totalRecords = response.extract().path("data");
        System.out.println( "Toatl Records : "+ totalRecords.size());
    }
    @Test
    public void verify2339Name() {
        String name =response.extract().path("[4].name");
        Assert.assertEquals(" ","Prema Khatri DVM", name );
        System.out.println(" Verify 2339 id has name: Prema Khatri DVM "+name);
    }
    @Test
    public void verify2335Email(){
        String email= response.extract().path("[6].email");
        Assert.assertEquals(" ","patel_divakar@kirlin.info",email);
        System.out.println("Verify 2335 id has email: patel_divakar@kirlin.info :- "+ email );
    }
    @Test
    public void verifyAllIDHasActiveStatus(){
        List <Integer> Id = response.extract().path("findAll{it.status=='active'}.id ");
        List <Integer> expected = new ArrayList<>();
        expected.add(2340);
        expected.add(2339);
        expected.add(2338);
        expected.add(2335);
        expected.add(2334);
        expected.add(2329);
        expected.add(2322);
        expected.add(2321);
        expected.add(2320);
        expected.add(2317);
        expected.add(2314);
        expected.add(2313);

        Assert.assertEquals("",expected, Id);
        System.out.println("Verify All Id has Active status: "+ Id);
    }
    @Test
    public void verify2320IdHasFemaleGender(){
        String gender= response.extract().path("[17].gender");
        Assert.assertEquals("","female",gender);
        System.out.println("Verify ID 2320 has Female gender: " +gender);
    }
    @Test
    public void verify2324IdHasMaleGender(){
        String gender= response.extract().path("[10].gender");
        Assert.assertEquals("","male",gender);
        System.out.println("Verify ID 2324 has Male gender: " +gender);
    }

}
