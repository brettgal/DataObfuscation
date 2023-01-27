import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.jayway.jsonpath.JsonPath;


import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

//@JsonIgnoreProperties(ignoreUnknown=true)

public class Main {

    public static final String managerURL = "https://envh.aoc.advent.com/query/PortfolioManagers";
    public static final String summaryURL = "https://envh.aoc.advent.com/query/PortfolioSummary";

    public static final String usersURL = "https://envh.aoc.advent.com/query/Users";
    public static final String tokenURL = "https://dev-auth-hub.advent.com/oauth2/ausr3slpshNbDYvAT0h7/v1/token";



    public static void main(String[] args) throws IOException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        Faker fake = new Faker();

        //post request to get bearer token
        String token = getToken();

        //get request for manager/summary/users values, results in the array of data to be changed
        String managerResponse = getManagerValues(token);
        String managerArrayString = getArrayOnly(managerResponse);

        String summaryResponse = getSummaryValues(token);
        String summaryArrayString = getArrayOnly(summaryResponse);

        String usersResponse = getUsersValues(token);
        String usersArrayString = getArrayOnly(usersResponse);

        //put json data into lists
        List<PortfolioManager> managers = mapper.readValue(managerArrayString, new TypeReference<List<PortfolioManager>>() {
        });
        List<Users> users = mapper.readValue(usersArrayString, new TypeReference<List<Users>>() {
        });
        List<PortfolioSummary> summary = mapper.readValue(summaryArrayString, new TypeReference<List<PortfolioSummary>>() {
        });


        //Obfuscate manager name, first initial + last name
        for (int i = 0; i < managers.size(); i++) {
            managers.get(i).setName((fake.name().firstName().charAt(0) + fake.name().lastName()).toLowerCase());
        }
        String finalManagerString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(managers);
        //currently writes to a file, see getToken() to see format of a post request
        FileWriter managerWriter = new FileWriter("/Users/bgallag1/Temp/PortfolioManagerResult.json");
        managerWriter.write(finalManagerString);
        managerWriter.close();


        //Obfuscate firstName, lastName, middleInitial, firstNameLastName, initials, and email properties of the User entity.
        for (int i = 0; i < users.size(); i++) {
            users.get(i).setFirstName(fake.name().firstName());
            String firstName = users.get(i).getFirstName();
            users.get(i).setLastName(fake.name().lastName());
            String lastName = users.get(i).getLastName();
            users.get(i).setFirstNameLastName(firstName, lastName);
            //users.get(i).setInitials(firstName.charAt(0),lastName.charAt(0));         initials were always null in real data set
            users.get(i).setEmail(firstName, lastName);
        }
        String finalUsersString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(users);
        //currently writes to a file, see getToken() to see format of a post request
        FileWriter usersWriter = new FileWriter("/Users/bgallag1/Temp/UsersResult.json");
        usersWriter.write(finalUsersString);
        usersWriter.close();


        //Obfuscate manger name and display name of portfolio summary
        for (int i = 0; i < summary.size(); i++) {
            summary.get(i).setManager((fake.name().firstName().charAt(0) + fake.name().lastName()).toLowerCase());
            summary.get(i).setDisplayName(fake.company().name());
        }
        String finalSummaryString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(summary);
        //currently writes to a file, see getToken() to see format of a post request
        FileWriter summaryWriter = new FileWriter("/Users/bgallag1/Temp/PortfolioSummaryResult.json");
        summaryWriter.write(finalSummaryString);
        summaryWriter.close();

    }

    public static String getToken() throws IOException, InterruptedException {
        //post request to get bearer token, body/headers can be found in postman request
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest postRequest = HttpRequest.newBuilder()
                .headers("Authorization", "Basic MG9hMTFrbWIxOGRZNnk3STIwaDg6Mkh0TXYybVZkalMtQ0RzZ1BpMTA4RGl0aTJiZUJpT0RqcGpic0NvbA==", "Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString("grant_type=client_credentials&scope=read"))
                .uri(URI.create(tokenURL))
                .build();
        HttpResponse<String> postResponse = client.send(postRequest, HttpResponse.BodyHandlers.ofString());
        //returns json formatted string
        String str = postResponse.body();
        //extract only token value
        String token = JsonPath.read(str, "$.access_token");
        return token;
    }

    public static String getArrayOnly(String originalString) throws IOException {
        //get requests result in json object containing the array of objects needed, so this extracts only the array
        String arrayString = originalString.substring(originalString.indexOf("["), originalString.indexOf("]") + 1);
        //String arrayString = JsonPath.read(originalString,"$.value");
        return arrayString;
    }

    public static String getManagerValues(String token) throws IOException, InterruptedException {
        //get request for manager values, returns string of all data in json form, which is then processed in getArray()
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest managerRequest = HttpRequest.newBuilder()
                .GET()
                .header("Authorization", "Bearer " + token)
                .uri(URI.create(managerURL))
                .build();
        HttpResponse<String> managerResponse = client.send(managerRequest, HttpResponse.BodyHandlers.ofString());

        String managerArrayString = managerResponse.body();
        return managerArrayString;
    }

    public static String getSummaryValues(String token) throws IOException, InterruptedException {
        //get request for summary values, returns string of all data in json form, which is then processed in getArray()
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest summaryRequest = HttpRequest.newBuilder()
                .GET()
                .header("Authorization", "Bearer " + token)
                .uri(URI.create(summaryURL))
                .build();
        HttpResponse<String> summaryResponse = client.send(summaryRequest, HttpResponse.BodyHandlers.ofString());

        String summaryArrayString = summaryResponse.body();
        return summaryArrayString;
    }

    public static String getUsersValues(String token) throws IOException, InterruptedException {
        //get request for users values, returns string of all data in json form, which is then processed in getArray()
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest usersRequest = HttpRequest.newBuilder()
                .GET()
                .header("Authorization", "Bearer " + token)
                .uri(URI.create(usersURL))
                .build();
        HttpResponse<String> usersResponse = client.send(usersRequest, HttpResponse.BodyHandlers.ofString());

        String usersArrayString = usersResponse.body();
        return usersArrayString;
    }
}


