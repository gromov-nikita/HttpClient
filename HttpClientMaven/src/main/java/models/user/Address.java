package models.user;

import models.interfaces.IJSON;

public class Address implements IJSON {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;
    public Address(String street, String suite, String city, String zipcode, Geo geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
    }
    public String getStreet() {
        return street;
    }
    public String getSuite() {
        return suite;
    }
    public String getCity() {
        return city;
    }
    public String getZipcode() {
        return zipcode;
    }
    public Geo getGeo() {
        return geo;
    }
    @Override
    public String toString() {
        return "Address.street: " + street + "\nAddress.suite: " +
                suite + "\nAddress.city: " + city + "\nAddress.zipcode: " +
                zipcode + "\nAddress.geo: \n" + geo.toString();
    }

    @Override
    public String getJSONString() {
        return "{\n" +
                "\"street\": \"" + street + "\",\n" +
                "\"suite\": \"" + suite + "\",\n" +
                "\"city\": \"" + city + "\",\n" +
                "\"zipcode\": \"" + zipcode + "\",\n" +
                "\"geo\": " + geo.getJSONString() + "\n" +
                "}";
    }
}

