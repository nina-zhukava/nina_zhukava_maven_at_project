package homework.day21;

import gherkin.deps.com.google.gson.Gson;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseTest {

    private static final String BASE_URI = "http://178.124.206.46:8001/app/ws/";

    static Gson gson = new Gson();

    static RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(BASE_URI)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL).build();
}
