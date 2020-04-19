package com.tech.common.apiTestHelper;

import com.tech.utils.JsonUtil;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;
import org.testng.util.Strings;

import java.util.Map;

/**
 * Wrapper of RestAssured webUtils.
 */
@Slf4j
@Service
public class RestAssuredService {

    @Autowired
    private JsonUtil jsonUtil;

    public String getApplicationSession(String username, String password){
        //Write the code to get the session with username and password.
        return "";
    }

    public Response sendRequestWithBody(String url, RequestMethod requestMethod, Object inputObject, String session){
        RequestSpecification requestSpecification = RestAssured.given();
        if (null != inputObject){
            requestSpecification.body(jsonUtil.mapObjectToJson(inputObject));
        }
        return submitRequest(url, requestMethod, session, requestSpecification);

    }

    public Response sendRequestWithPathParameters(String url, RequestMethod requestMethod, Map<String, Object> inputParameters, String session){
        RequestSpecification requestSpecification = RestAssured.given()
                .pathParams(inputParameters);
        return submitRequest(url, requestMethod, session, requestSpecification);
    }

    /**
     * @param url
     * @param requestMethod
     * @param session
     * @param requestSpecification
     * @return
     */
    private Response submitRequest(String url,
                                   RequestMethod requestMethod,
                                   String session,
                                   RequestSpecification requestSpecification) {
        if (!Strings.isNullOrEmpty(session)) {
            requestSpecification = requestSpecification
                    .header("Cookie", session);
        }
        switch (requestMethod) {
            case POST:
                return requestSpecification
                        .contentType(ContentType.JSON)
                        .post(url);
            case PUT:
                return requestSpecification
                        .contentType(ContentType.JSON)
                        .put(url);
            case DELETE:
                return requestSpecification
                        .delete(url);
            case GET:
            default:
                return requestSpecification
                        .accept(MediaType.APPLICATION_JSON.toString())
                        .get(url);
        }
    }
}
