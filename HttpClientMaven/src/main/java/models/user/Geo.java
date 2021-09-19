package models.user;

public class Geo {
    private double lat;
    private double lng;
    public Geo(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }
    public double getLat() {
        return lat;
    }
    public double getLng() {
        return lng;
    }

    @Override
    public String toString() {
        return "Geo.lat: " + lat + "\nGeo.lng " + lng + "\n";
    }

}
