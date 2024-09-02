package blackbox.com.ntnn.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
import org.json.XML;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import stub.com.ntnn.StubApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
@CucumberContextConfiguration
@SpringBootTest(classes = StubApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StepDefinations {

  @LocalServerPort
  private int port;

  @PostConstruct
  public void setup() {
    System.setProperty("port", String.valueOf(port));
  }
  private Response response;
  private String res;

  @Given("Call Api exchange key")
  public void call_api_exchange_key() throws IOException {
    OkHttpClient client = new OkHttpClient().newBuilder()
        .build();
    MediaType mediaType = MediaType.parse("text/plain");
    RequestBody body = RequestBody.create(mediaType, "");
    Request request = new Request.Builder()
        .url("http://localhost:8092/client/diffieHellman/exchangeKey")
        .method("POST", body)
        .build();
    response = client.newCall(request).execute();
  }

  @Given("Call Api topup with request {string}")
  public void call_api_topup(String request) throws IOException {
   String req = Files.readString(Path.of("src/test/resources/data/"+ request));
    OkHttpClient client = new OkHttpClient().newBuilder()
        .build();
    MediaType mediaType = MediaType.parse("application/xml");
    RequestBody body = RequestBody.create(mediaType, req);
    Request request1 = new Request.Builder()
        .url("http://localhost:8092/client/transaction/topup/0987654321")
        .method("POST", body)
        .addHeader("Content-Type", "application/xml")
        .addHeader("Authorization", "Bearer ZDBjMmE3N2YtODY5Ni00NDU5LThmMzItZjI3MTZhOGE2YmE5")
        .build();
    response = client.newCall(request1).execute();
  }

  @Given("Call Api topup with request {string} but not included token")
  public void call_api_topup_not_include_token(String request) throws IOException {
    String req = Files.readString(Path.of("src/test/resources/data/"+ request));
    OkHttpClient client = new OkHttpClient().newBuilder()
        .build();
    MediaType mediaType = MediaType.parse("application/xml");
    RequestBody body = RequestBody.create(mediaType, req);
    Request request1 = new Request.Builder()
        .url("http://localhost:8092/client/transaction/topup/0987654321")
        .method("POST", body)
        .addHeader("Content-Type", "application/xml")
        .addHeader("Authorization", "")
        .build();
    response = client.newCall(request1).execute();
  }

  @When("Receive Response")
  public void receiveResponse() throws IOException {
    res = response.body().string();
    log.info("{}", res);
  }

  @When("Validate Response with")
  public void validate_response() {
    JSONObject jsonObject = new JSONObject(res);
    Assertions.assertNotNull(jsonObject);
    Assertions.assertNotNull(jsonObject.get("publicKeySever"));
    Assertions.assertNotNull(jsonObject.get("secretKey"));
    Assertions.assertNotNull(jsonObject.get("apiId"));
  }

  @When("Validate Response with type xml")
  public void validate_responseXml() {
    Assertions.assertNotNull(res);
  }
}
