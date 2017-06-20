import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class GenericPost {

    @Step("Post to the <endpoint> endpoint")
    public void postEndPoint(String endpoint) {
        DataStore dataStore = DataStoreFactory.getScenarioDataStore();
        HttpResponse<String> httpResponse;
        String url = "http://localhost:3000/" + endpoint;
        Gauge.writeMessage(url);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
            String timeBeforePost = sdf.format(new Date()).replace(" ", "T").concat("Z");
            dataStore.put("timeBeforePost", timeBeforePost);
            httpResponse = Unirest.post(url)
                    .header("Content-Type", "application/json")
                    .header("Accept", "*/*")
                    .body("{\"test\": 123}")
                    .asString();
            String timeAfterPost = sdf.format(new Date()).replace(" ", "T").concat("Z");
            dataStore.put("timeAfterPost", timeAfterPost);
            dataStore.put("httpResponse", httpResponse);
            Integer httpResponseCode = httpResponse.getStatus();
            dataStore.put("httpResponseCode", httpResponseCode);
            String httpResponseStatusText = httpResponse.getStatusText();
            dataStore.put("httpResponseStatusText", httpResponseStatusText);
            if (!endpoint.equals("no_response")) {
                String httpBody = httpResponse.getBody().toString();
                dataStore.put("httpBody", httpBody);
                Gauge.writeMessage(httpResponse.getBody());
            }
            Gauge.writeMessage(httpResponseStatusText);

        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    @Step("Post to the <endpoint> endpoint with invalid JSON")
    public void postEndPointWithInvalidJSON(String endpoint) {
        DataStore dataStore = DataStoreFactory.getScenarioDataStore();
        HttpResponse<String> httpResponse;
        String url = "http://localhost:3000/" + endpoint;
        Gauge.writeMessage(url);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
            String timeBeforePost = sdf.format(new Date()).replace(" ", "T").concat("Z");
            dataStore.put("timeBeforePost", timeBeforePost);
            httpResponse = Unirest.post(url)
                    .header("Content-Type", "application/json")
                    .header("Accept", "*/*")
                    .body("{\"test\":")
                    .asString();
            String timeAfterPost = sdf.format(new Date()).replace(" ", "T").concat("Z");
            dataStore.put("timeAfterPost", timeAfterPost);
            dataStore.put("httpResponse", httpResponse);
            Integer httpResponseCode = httpResponse.getStatus();
            dataStore.put("httpResponseCode", httpResponseCode);
            String httpResponseStatusText = httpResponse.getStatusText();
            dataStore.put("httpResponseStatusText", httpResponseStatusText);
            if (!endpoint.equals("no_response")) {
                String httpBody = httpResponse.getBody().toString();
                dataStore.put("httpBody", httpBody);
                Gauge.writeMessage(httpResponse.getBody());
            }
            Gauge.writeMessage(httpResponseStatusText);

        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}
