package com.videoslots.api.steps.commons;

import com.videoslots.api.model.home.response.HomeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.*;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class ApiClient {

    @Autowired
    private ApiConfig apiConfig;

    private HttpHeaders headers = new HttpHeaders();

    public ApiClient() {
        // Default Headers
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

    }
    // Gets homepage
    public HomeResponse apiHome() {

        ResponseEntity<String> response = apiConfig.getRestTemplate().exchange("/",
                HttpMethod.GET,
                new HttpEntity<>(headers),
                String.class);

       //returns status cosde
       return new HomeResponse(response.getStatusCode().value());

    }



}