/*
import com.jayway.jsonpath.JsonPath;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Stage {
    public static final String stageTokenURL = "https://stage-auth-hub.advent.com/oauth2/ausrenvjyy0N9MJfD0h7";
    public static final String hierarchiesURL = "https://stage2.genesis.advent.com/query/Hierarchies";


    public static String getStageToken() throws IOException, InterruptedException {
        //post request to get bearer token, body/headers can be found in postman request
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest postRequest = HttpRequest.newBuilder()
                .headers("Authorization", "Basic MG9hcmVqMXJrdm43MHBneDYwaDc6dzFRNFdaQlR1cGd3cjNOcHFDQzR1X3c3TjJoX2tNMnhpUm9PSGZacg==", "Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString("grant_type=password&scopes=openid profile email&username=109273-ckagawa@advent.com&password=mSxu3LvdY96HnHc"))
                .uri(URI.create(stageTokenURL))
                .build();
        HttpResponse<String> postResponse = client.send(postRequest, HttpResponse.BodyHandlers.ofString());
        //returns json formatted string
        String str = postResponse.body();
        //extract only token value
        String stageToken = JsonPath.read(str, "$.access_token");
        return stageToken;
    }

    public static String getHierarchiesValues(String token) throws IOException, InterruptedException {
        //get request for hierarchies values, returns string of all data in json form, which is then processed in getArray()
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest hierarchiesRequest = HttpRequest.newBuilder()
                .GET()
                .header("Authorization", "Bearer " + stageTokenURL)
                .uri(URI.create(hierarchiesURL))
                .build();
        HttpResponse<String> hierarchiesResponse = client.send(hierarchiesRequest, HttpResponse.BodyHandlers.ofString());

        String hierarchiesArrayString = hierarchiesResponse.body();
        return hierarchiesArrayString;
    }
}
*/