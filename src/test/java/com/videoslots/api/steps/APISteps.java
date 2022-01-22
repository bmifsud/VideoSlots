package com.videoslots.api.steps;

import com.videoslots.api.model.auth.response.HomeResponse;
import com.videoslots.api.steps.commons.ApiClient;
import com.videoslots.api.steps.commons.ApiConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes={ApiClient.class, ApiConfig.class})
public class APISteps {

    @Autowired
    ApiClient apiClient;
    private HomeResponse homeResponse;

    @Given("^API User views Evernote Home$")
    public void aPIUserViewsEvernoteHome() throws Throwable {
        homeResponse = apiClient.apiHome();
    }

    @Then("^API User should receive response with (.+)$")
    public void aPIUserShouldReceiveResponseWith(int statuscode) throws Throwable {
        //verifies status code
        if(statuscode != homeResponse.getStatusCode()){
            Assert.fail();
        }
    }

}
