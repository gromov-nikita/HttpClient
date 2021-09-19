package server;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Request {
    private URI uri;
    private HttpClient httpClient;
    public Request(String uri) {
        this.uri = URI.create(uri);
        httpClient = HttpClient.newBuilder().build();
    }
    public String get() throws IOException, InterruptedException {
        String str;
        StringBuffer stringBuffer;
        HttpRequest httpRequest = HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> response = httpClient.send(httpRequest,
                HttpResponse.BodyHandlers.ofString());
        return responseHandler(response);
    }
    public String post(String str) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder(uri).POST(HttpRequest.BodyPublishers.ofString(str)).build();
        HttpResponse<String> response = httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());
        return responseHandler(response);
    }
    public String put(String str) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder(uri).PUT(HttpRequest.BodyPublishers.ofString(str)).build();
        HttpResponse<String> response = httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());
        return responseHandler(response);
    }
    public String delete() throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder(uri).DELETE().build();
        HttpResponse<String> response = httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());
        return responseHandler(response);
    }
    private String responseHandler(HttpResponse response) {
        int code = response.statusCode();
        switch (code) {
            case 200 : {
                return (String) response.body();
            }
            case 201 : {
                return (String) response.body();
            }
            case 202 : {
                return (String) response.body();
            }
            case 204 : {
                return (String) response.body();
            }
            default : {
                return String.valueOf(response.statusCode());
            }
        }
    }
}
