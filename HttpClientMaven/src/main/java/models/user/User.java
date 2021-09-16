package models.user;

public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

    public User(int id,String name, String username, String email,
                Address address, String phone, String website, Company company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }

    @Override
    public String toString() {
        return "User.id: " + id + "\nUser.name: " + name + "\nUser.username: " + username +
                "\nUser.email: " + email + "\nUser.address: \n" + address.toString() +
                "User.phone: " + phone + "\nUser.website: " + website +
                "\nUser.company: \n" + company.toString();

    }
}