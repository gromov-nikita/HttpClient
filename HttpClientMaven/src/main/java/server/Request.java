package server;

import models.exceptions.ClientError;
import models.exceptions.ServerError;

import java.io.IOException;
import java.net.URI;
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
    public String get() throws IOException, InterruptedException, ServerError, ClientError {
        String str;
        StringBuffer stringBuffer;
        HttpRequest httpRequest = HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> response = httpClient.send(httpRequest,
                HttpResponse.BodyHandlers.ofString());
        return responseHandler(response);
    }
    public String post(String str) throws IOException, InterruptedException, ServerError, ClientError {
        HttpRequest httpRequest = HttpRequest.newBuilder(uri).POST(HttpRequest.BodyPublishers.ofString(str)).build();
        HttpResponse<String> response = httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());
        return responseHandler(response);
    }
    public String put(String str) throws IOException, InterruptedException, ServerError, ClientError {
        HttpRequest httpRequest = HttpRequest.newBuilder(uri).PUT(HttpRequest.BodyPublishers.ofString(str)).build();
        HttpResponse<String> response = httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());
        return responseHandler(response);
    }
    public String delete() throws IOException, InterruptedException, ServerError, ClientError {
        HttpRequest httpRequest = HttpRequest.newBuilder(uri).DELETE().build();
        HttpResponse<String> response = httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());
        return responseHandler(response);
    }
    private String responseHandler(HttpResponse response) throws ServerError, ClientError {
        int code = response.statusCode();
        if(code >= 200 && code < 300) {
            return (String) response.body();
        }
        else {
            if(code >= 500) {
                throw new ServerError(code);
            }
            else {
                throw new ClientError(code);
            }
        }
    }
}
