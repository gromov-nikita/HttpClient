package server;

import models.exceptions.ClientError;
import models.exceptions.ServerError;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Request {
    private URI uri;
    private HttpClient httpClient;
    Logger logReq = Logger.getLogger(Request.class.getName());
    public Request(String uri) {
        this.uri = URI.create(uri);
        httpClient = HttpClient.newBuilder().build();
    }
    public String get() throws IOException, InterruptedException, ServerError, ClientError {
        logReq.info("GET request");
        String str;
        StringBuffer stringBuffer;
        HttpRequest httpRequest = HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> response = httpClient.send(httpRequest,
                HttpResponse.BodyHandlers.ofString());
        return responseHandler(response);
    }
    public String post(String str) throws IOException, InterruptedException, ServerError, ClientError {
        logReq.info("POST request");
        HttpRequest httpRequest = HttpRequest.newBuilder(uri).POST(HttpRequest.BodyPublishers.ofString(str)).build();
        HttpResponse<String> response = httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());
        return responseHandler(response);
    }
    public String put(String str) throws IOException, InterruptedException, ServerError, ClientError {
        logReq.info("PUT request");
        HttpRequest httpRequest = HttpRequest.newBuilder(uri).PUT(HttpRequest.BodyPublishers.ofString(str)).build();
        HttpResponse<String> response = httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());
        return responseHandler(response);
    }
    public String delete() throws IOException, InterruptedException, ServerError, ClientError {
        logReq.info("DELETE request");
        HttpRequest httpRequest = HttpRequest.newBuilder(uri).DELETE().build();
        HttpResponse<String> response = httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());
        return responseHandler(response);
    }
    private String responseHandler(HttpResponse response) throws ServerError, ClientError {
        int code = response.statusCode();
        if(code >= 200 && code < 400) {
            logReq.info("Code: " + response.statusCode());
            return (String) response.body();
        }
        else {
            if(code >= 500) {
                logReq.info("Server Error. Code: " + response.statusCode());
                throw new ServerError(code);
            }
            else {
                logReq.info("Client Error. Code: " + response.statusCode());
                throw new ClientError(code);
            }
        }
    }
}
