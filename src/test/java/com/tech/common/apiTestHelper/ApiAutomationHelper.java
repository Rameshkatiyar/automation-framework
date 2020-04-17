package com.tech.common.apiTestHelper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Service
public class ApiAutomationHelper {

    @Autowired
    private RestAssuredService restAssuredService;

    public void setBaseURIAndPath(String baseURI, String basePath){
        RestAssured.baseURI = baseURI;
        RestAssured.basePath = basePath;
    }

    public int getStatus(String url){
        Response response = restAssuredService.sendRequestWithBody(
                url,
                RequestMethod.GET,
                null,
                null
        );
        return response.getStatusCode();
    }
}
