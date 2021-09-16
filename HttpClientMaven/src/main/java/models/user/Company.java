package models.user;

import models.interfaces.IJSON;

public class Company implements IJSON {
    private String name;
    private String catchPhrase;
    private String bs;
    public Company(String name, String catchPhrase, String bs) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }
    public String getName() {
        return name;
    }
    public String getCatchPhrase() {
        return catchPhrase;
    }
    public String getBs() {
        return bs;
    }

    @Override
    public String toString() {
        return "Company.name: " + name + "\nCompany.catchPhrase: " + catchPhrase + "\nCompany.bs: " + bs + "\n";
    }

    @Override
    public String getJSONString() {
        return "{\n" +
                "\"name\": \"" + name + "\",\n" +
                "\"catchPhrase\": \"" + catchPhrase + "\",\n" +
                "\"bs\": \"" + bs + "\"\n" +
                "}";
    }
}
