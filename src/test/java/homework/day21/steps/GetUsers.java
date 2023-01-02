package homework.day21.steps;

import classwork.day20.Search;
import homework.day21.GetUsersResponse;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class GetUsers {

    private static final String BASE_URI = "http://178.124.206.46:8001/app/ws/";

    private static final Search ALL_USERS = new Search("", false);
    private static final Search FULL_SHORT_USERNAME = new Search("a", true);
    private static final Search FULL_LONG_USERNAME = new Search("rangaradjangoo", true);
    private static final Search PARTIAL_SHORT_USERNAME = new Search("jo", false);
    private static final Search PARTIAL_LONG_USERNAME = new Search("ja", false);

    private static final RequestSpecification REQ_SPEC = new RequestSpecBuilder()
            .setBaseUri(BASE_URI)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL).build();

    public static GetUsersResponse getAllUsers() {
        return searchForUsers(ALL_USERS);
    }

    public static GetUsersResponse getUserByFullShortUsername() {
        return searchForUsers(FULL_SHORT_USERNAME);
    }

    public static GetUsersResponse getUserByFullLongUsername() {
        return searchForUsers(FULL_LONG_USERNAME);
    }

    public static GetUsersResponse getUserByPartialShortUsername() {
        return searchForUsers(PARTIAL_SHORT_USERNAME);
    }

    public static GetUsersResponse getUserByPartialLongUsername() {
        return searchForUsers(PARTIAL_LONG_USERNAME);
    }

    private static GetUsersResponse searchForUsers(Search body) {
        return RestAssured.given()
                .spec(REQ_SPEC)
                .body(body)
                .when()
                .post()
                .then()
                .contentType(ContentType.JSON)
                .extract().body().as(GetUsersResponse.class);
    }
}
