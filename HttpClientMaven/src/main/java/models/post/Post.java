package models.post;

import models.interfaces.IJSON;

public class Post implements IJSON {
    private int userId;
    private int id;
    private String title;
    private String body;
    public Post(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }
    public int getUserId() {
        return userId;
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Post.userId: " + userId + "\nPost.id: " + id + "\nPost.title: " + title +
                "\nPost.body: " + body;
    }

    @Override
    public String getJSONString() {
        return "{\n" +
                "\"userId\": " + userId + "," +
                "\n\"id\": " + id + ",\n" +
                "\"title\": \"" + title + "\",\n" +
                "\"body\": \"" + body + "\",\n" +
                "}";
    }
}
