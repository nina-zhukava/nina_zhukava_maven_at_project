package homework.day21;

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.stream.JsonReader;
import homework.day21.steps.GetUsers;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ServiceTests {

    private static final String FULL_SHORT_NAME_USER = "src/test/resources/users/ShortUsername.json";
    private static final String ALL_USERS = "src/test/resources/users/AllUsers.json";
    private static final String LONG_NAME_USER = "src/test/resources/users/LongUserName.json";
    private static final String PARTIAL_SHOR_NAME_USER = "src/test/resources/users/PartialShortUsername.json";

    private Gson gson = new Gson();

    @Test
    public void getAllUsersTest() {
        searchTest(GetUsers.getAllUsers(), ALL_USERS);
    }

    @Test
    public void searchUserByFullShortUsername() {
        searchTest(GetUsers.getUserByFullShortUsername(), FULL_SHORT_NAME_USER);
    }

    @Test
    public void searchUserByFullLongUsername() {
        searchTest(GetUsers.getUserByFullLongUsername(), LONG_NAME_USER);
    }

    @Test
    public void searchUserByPartialShortUsername() {
        searchTest(GetUsers.getUserByPartialShortUsername(), PARTIAL_SHOR_NAME_USER);
    }

    @Test
    public void searchUserByPartialLongUsername() {
        searchTest(GetUsers.getUserByPartialLongUsername(), LONG_NAME_USER);
    }

    private void searchTest(GetUsersResponse actualResponse, String file) {
        try {
            GetUsersResponse expectedResponse = gson.fromJson(new JsonReader(new FileReader(file)),
                    GetUsersResponse.class);
            Assert.assertEquals(actualResponse, expectedResponse);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}