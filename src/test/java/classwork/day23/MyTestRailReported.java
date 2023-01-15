package classwork.day23;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Base64;

public class MyTestRailReported {

    private static final Logger LOGGER = LogManager.getLogger(MyTestRailReported.class);

    public static void main(String[] args) {
        new MyTestRailReported().debug();
    }

    private static void sendGetRequest(String url) throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder(url);
        HttpGet request = new HttpGet(builder.build());
        request.addHeader("Content-Type", "application/json");
        String authText = "mail:password";
        request.addHeader("Authorization", "Basic " + Base64.getEncoder().encodeToString(authText.getBytes()));
        HttpResponse httpResponse = client.execute(request);
        LOGGER.info("Reported result  \r \n " + EntityUtils.toString(httpResponse.getEntity()));
    }

    private static void sendPostRequest(String url, String body) {
        HttpClient client = HttpClientBuilder.create().build();
        try {
            URIBuilder builder = new URIBuilder(url);
            HttpPost request = new HttpPost(builder.build());

            request.setEntity(new StringEntity(body));
            request.addHeader("Content-Type", "application/json");
            String authText = "mail:password";
            request.addHeader("Authorization", "Basic " + Base64.getEncoder().encodeToString(authText.getBytes()));
            HttpResponse httpResponse = client.execute(request);
            LOGGER.info("Reported result  \r \n " + EntityUtils.toString(httpResponse.getEntity()));
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void report(String caseId, int status, String comment) {
        sendPostRequest(
                String.format("http://178.124.206.46:8000/index.php?/api/v2/add_result_for_case/2091/%s", caseId),
                String.format("{\"status_id\":%d,\"comment\":\"%s\"}", status, comment));
    }

    public void debug() {
//        sendGetRequest("http://178.124.206.46:8000/index.php?/api/v2/get_cases/7&suite_id=1289");
//        sendPostRequest("http://178.124.206.46:8000/index.php?/api/v2/get_cases/7&suite_id=1289", "");
        report("147407", 1, "lala");
    }
}
