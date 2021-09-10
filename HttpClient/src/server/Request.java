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
     public Request(String uri) throws URISyntaxException {
         this.uri = URI.create(uri);
         httpClient = HttpClient.newBuilder().build();
     }
     public String get() throws Exception {
         String str;
         StringBuffer stringBuffer;
         HttpRequest httpRequest = HttpRequest.newBuilder(uri).GET().build();
         HttpResponse<String> response = httpClient.send(httpRequest,
                 HttpResponse.BodyHandlers.ofString());
         if(response.statusCode() == 200) {
             return response.body();
         }
         else {
             throw new Exception("Status code" + response.statusCode());
         }
     }
     public String post(String str) throws Exception {
         HttpRequest httpRequest = HttpRequest.newBuilder(uri).POST(HttpRequest.BodyPublishers.ofString(str)).build();
         HttpResponse<String> response = httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());
         if(response.statusCode() == 201) {
             return response.body();
         }
         else {
             throw new Exception("Status code: " + response.statusCode());
         }
     }
    public String put(String str) throws Exception {
        HttpRequest httpRequest = HttpRequest.newBuilder(uri).PUT(HttpRequest.BodyPublishers.ofString(str)).build();
        HttpResponse<String> response = httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() == 201 || response.statusCode() == 200 || response.statusCode() == 204) {
            return response.body();
        }
        else {
            throw new Exception("Status code: " + response.statusCode());
        }
    }
    public String delete() throws Exception {
        HttpRequest httpRequest = HttpRequest.newBuilder(uri).DELETE().build();
        HttpResponse<String> response = httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() == 202 || response.statusCode() == 204 || response.statusCode() == 200 ) {
            return response.body();
        }
        else {
            throw new Exception("Status code: " + response.statusCode());
        }
    }
}
