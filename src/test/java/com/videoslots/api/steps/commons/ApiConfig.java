package com.videoslots.api.steps.commons;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

//Basic template to run rest API test calls
@Configuration
@Scope(SCOPE_CUCUMBER_GLUE)
public class ApiConfig {

    private RestTemplate restTemplate;

    @PostConstruct
    public void init(){
        initRestTemplate();
    }

    // Basic template configuration for API Rest Calls
    private void initRestTemplate(){
        restTemplate = new RestTemplateBuilder()
                .rootUri("https://evernote.com")
                .build();

    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

}