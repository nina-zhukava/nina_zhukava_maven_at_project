package homework.day21.steps;

import classwork.day20.Search;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class GetUsers {

    private static final Search ALL_USERS = new Search("", false);
    private static final Search FULL_USERNAME = new Search("berta", true);
    private static final Search SHORT_USERNAME_NOT_STRICT = new Search("ber", false);
    private static final Search SHORT_USERNAME_STRICT = new Search("ber", true);

    public static String getAllUsers(RequestSpecification reqSpec) {
        return RestAssured.given()
                .spec(reqSpec)
                .body(ALL_USERS)
                .when()
                .post()
                .then()
                .contentType(ContentType.JSON)
                .extract().response().asString();
    }

    public static String getUserByFullUsername(RequestSpecification reqSpec) {
        return RestAssured.given()
                .spec(reqSpec)
                .body(FULL_USERNAME)
                .when()
                .post()
                .then()
                .contentType(ContentType.JSON)
                .extract().response().asString();
    }

    public static String getUserByPartUsername(RequestSpecification reqSpec) {
        return RestAssured.given()
                .spec(reqSpec)
                .body(SHORT_USERNAME_NOT_STRICT)
                .when()
                .post()
                .then()
                .contentType(ContentType.JSON)
                .extract().response().asString();
    }

    public static String getUsersByPartUsername(RequestSpecification reqSpec) {
        return RestAssured.given()
                .spec(reqSpec)
                .body(SHORT_USERNAME_NOT_STRICT)
                .when()
                .post()
                .then()
                .contentType(ContentType.JSON)
                .extract().response().asString();
    }

}
