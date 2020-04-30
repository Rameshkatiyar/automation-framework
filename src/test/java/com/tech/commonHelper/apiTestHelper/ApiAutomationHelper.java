package com.tech.commonHelper.apiTestHelper;

import com.tech.config.TestUrlConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Service
public abstract class ApiAutomationHelper {

    @Autowired
    private RestAssuredService restAssuredService;
    @Autowired
    protected TestUrlConfig testUrlConfig;

    public void setBaseURIAndPath(){
        RestAssured.baseURI = getBaseURI();
    }

    public int getStatus(String url){
        setBaseURIAndPath();
        Response response = restAssuredService.sendRequestWithBody(
                url,
                RequestMethod.GET,
                null,
                null
        );
        return response.getStatusCode();
    }

    public Response getResponse(String url){
        setBaseURIAndPath();
        Response response = restAssuredService.sendRequestWithBody(
                url,
                RequestMethod.GET,
                null,
                null
        );
        return response;
    }

    public abstract String getBaseURI();
}
