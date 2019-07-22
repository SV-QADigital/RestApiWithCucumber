package glueCode;


import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.module.jsv.JsonSchemaValidator;
import com.jayway.restassured.parsing.Parser;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

import utilities.Utils;
import java.util.List;

import org.junit.Assert;


public class StepDef extends Utils {
	//First, I declared Response and JsonPath objects.
	private Response res = null;
	private JsonPath jp = null; 
	private RequestSpecification request;
    private Response response;


    @Given("^User calls web service to get Employees")
    public void User_calls_web_service_to_get_Employees()throws Throwable {
        // Set Base URI
    	setBaseURI();
    }
    
    @When("^a user retrieves the Employees List$")
    public void a_user_retrieves_the_Employees_List() throws Throwable {
    	request = RestAssured.given().pathParam("id", "17750").log().all();
    	response = request.when().get("/{id}");
    	JsonSchemaValidator.matchesJsonSchemaInClasspath("");
        System.out.println("************The Response value as --" + response.prettyPrint());
        jp = Utils.getJsonPath(res);
        System.out.println(jp);
    }
    
    @When("^To initiate Rest service to get employee details with code as \"([^\"]*)\"$")
    public void to_initiate_Rest_service_to_get_employee_details_with_code_as(String id) throws Throwable {
    	request = RestAssured.given().pathParam("id", id).log().all();
    	response = request.when().get("/{id}");
    	JsonSchemaValidator.matchesJsonSchemaInClasspath("");
        System.out.println("************The Response value as --" + response.prettyPrint());
		
   
}
  
    
    @Then("^Respose status code should be \"([^\"]*)\"$")
    public void respose_status_code_should_be(Integer arg1) throws Throwable {
        // To verify the response status code
        assertEquals("Status Check Failed!", 200, response.getStatusCode());

    }
    
    @Then("^Respose status code should not be \"([^\"]*)\"$")
    public void respose_status_code_should_not_be(Integer arg1) throws Throwable {
        // To verify the response status code
    	Assert.assertNotEquals("Status Check Failed!", 200, response.getStatusCode());

    }


    @Then("^response should includes the following$")
    public void response_includes_the_following(DataTable arg1) throws Throwable {

        // This method to verify response body
        List < List < String >> data = arg1.raw();
        System.out.println("*************** Actua Data Table - data value as-- " + data);

        response.then().body("RestResponse.result.name", equalTo(data.get(1).get(0)));
        response.then().body("RestResponse.result.alpha2_code", equalTo(data.get(1).get(1)));
        response.then().body("RestResponse.result.alpha3_code", equalTo(data.get(1).get(2)));


    }
    
    @Given("^To initiate Rest service to get country details with code as (.+)$")
    public void to_initiate_Rest_service_to_get_country_details_with_code() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}