package models.user;

public class Company {
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

}
