import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import org.junit.Assert;

public class Assertions {

    @Step("The response code should be <response_code>")
    public void responseCodeShouldEqual(Integer response_code) {
        DataStore dataStore = DataStoreFactory.getScenarioDataStore();
        Integer httpResponseCode = (Integer) dataStore.get("httpResponseCode");
        Assert.assertEquals(response_code, httpResponseCode);

    }

    @Step("The request received should be returned")
    public void AssertRequestReceived() {
        verifyResponseContainsString("receivedRequest");
        verifyResponseContainsString("\"test\": 123}");
    }

    @Step("The last <endpoint> request details should be returned")
    public void AssertLastRequest(String endpoint) {
        verifyResponseContainsString(endpoint);
        verifyResponseContainsString("\"mediaTypeUsed\": \"application/json\"");
        verifyResponseContainsString("bodyReceived");
        verifyResponseContainsString("\"test\": 123}");
    }

    @Step("The unauthorized request error details should be returned")
    public void AssertUnauthorizedErrorDetails() {
        verifyResponseContainsString("unauthorised");
        verifyResponseContainsString("\"statusCode\": 401");
        verifyResponseContainsString("\"error\": \"Unauthorized\"");
        verifyResponseContainsString("\"message\": \"Invalid token\"");
        verifyResponseContainsString("attributes");
        verifyResponseContainsString("\"error\": \"Invalid token\"");
        verifyResponseContainsString("\"test\": 123}");
    }

    private void verifyResponseContainsString(String string) {
        DataStore dataStore = DataStoreFactory.getScenarioDataStore();
        String httpBody = (String) dataStore.get("httpBody");
        Assert.assertTrue(httpBody.contains(string));
    }
}
