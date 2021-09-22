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
            case 200 :
            case 202 :
            case 201 :
            case 204 : {
                return (String) response.body();
            }
            case 500 : {
                System.out.println("Internal Server Error");
                return String.valueOf(response.statusCode());
            }
            case 501 : {
                System.out.println("Not Implemented");
                return String.valueOf(response.statusCode());
            }
            case 502 : {
                System.out.println("Bad Gateway");
                return String.valueOf(response.statusCode());
            }
            case 503 : {
                System.out.println("Service Unavailable");
                return String.valueOf(response.statusCode());
            }
            case 504 : {
                System.out.println("Gateway Timeout");
                return String.valueOf(response.statusCode());
            }
            case 505 : {
                System.out.println("HTTP Version Not Supported");
                return String.valueOf(response.statusCode());
            }
            case 506 : {
                System.out.println("Variant Also Negotiates");
                return String.valueOf(response.statusCode());
            }
            case 507 : {
                System.out.println("Insufficient Storage");
                return String.valueOf(response.statusCode());
            }
            case 508 : {
                System.out.println("Loop Detected");
                return String.valueOf(response.statusCode());
            }
            case 509 : {
                System.out.println("Bandwidth Limit Exceeded");
                return String.valueOf(response.statusCode());
            }
            case 510 : {
                System.out.println("Not Extended");
                return String.valueOf(response.statusCode());
            }
            default : {
                return String.valueOf(response.statusCode());
            }
        }
    }
}
