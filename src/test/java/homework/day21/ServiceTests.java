package homework.day21;

import gherkin.deps.com.google.gson.stream.JsonReader;
import homework.day21.steps.GetUsers;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ServiceTests extends BaseTest {

    private static final String ALL_USERS = "src/test/resources/users/AllUsers.json";
    private static final String FULL_NAME_USER = "src/test/resources/users/Berta.json";

    @Test
    public void getAllUsersTest() throws FileNotFoundException {
        GetUsersResponse actualResponse = gson.fromJson(GetUsers.getAllUsers(requestSpec), GetUsersResponse.class);
        GetUsersResponse expectedResponse = gson.fromJson(new JsonReader(new FileReader(ALL_USERS)),
                GetUsersResponse.class);
        Assert.assertEquals(actualResponse, expectedResponse);
    }

    @Test
    public void searchUserByFullUsername() throws FileNotFoundException {
        GetUsersResponse actualResponse = gson.fromJson(GetUsers.getUserByFullUsername(requestSpec), GetUsersResponse.class);
        GetUsersResponse expectedResponse = gson.fromJson(new JsonReader(new FileReader(FULL_NAME_USER)),
                GetUsersResponse.class);
        Assert.assertEquals(actualResponse, expectedResponse);
    }

    @Test
    public void searchUserByFullRealname() throws FileNotFoundException {
        GetUsersResponse actualResponse = gson.fromJson(GetUsers.getUserByPartUsername(requestSpec), GetUsersResponse.class);
        GetUsersResponse expectedResponse = gson.fromJson(new JsonReader(new FileReader(FULL_NAME_USER)),
                GetUsersResponse.class);
        Assert.assertEquals(actualResponse, expectedResponse);
    }
}
/*
- WS address: http://178.124.206.46:8001/app/ws/
- create automation tests to verify possibility to
search user by full name (short and long),
by partial name (short and long),
search all users - 5 tests in total

- test data should be stored in json files
- data should be parsed with gson libraries
- store test data, test objects, steps separately*/
