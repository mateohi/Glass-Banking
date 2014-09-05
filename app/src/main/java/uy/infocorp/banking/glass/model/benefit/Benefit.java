
package uy.infocorp.banking.glass.model.benefit;

public class Benefit {

    private final double latitude;
    private final double longitude;
    private final String name;
    private final String description;

    public Benefit(double latitude, double longitude, String name, String description) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.description = description;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
