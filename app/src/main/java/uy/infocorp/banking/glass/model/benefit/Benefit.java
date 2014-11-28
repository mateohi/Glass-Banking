package uy.infocorp.banking.glass.model.benefit;

public class Benefit {

    private final double latitude;
    private final double longitude;
    private final String name;
    private final String description;
    private final String type;

    public class Type {
        public static final String AUTOMOBILES = "automobiles";
        public static final String CLOTHES_AND_FOOTWEAR = "clothesAndFootwear";
        public static final String ENTERTAINMENT = "entertainment";
        public static final String HEALTH_AND_SPORT = "healthAndSport";
        public static final String HOME = "home";
        public static final String OTHERS = "others";
        public static final String RESTAURANTS = "restaurants";
        public static final String SERVICES = "services";
        public static final String SUPERMARKETS_AND_STORES = "supermarketsAndStores";
        public static final String TECHNOLOGY = "technology";
        public static final String TRAVEL = "travelAndTourism";
    }

    public Benefit(double latitude, double longitude, String name, String description, String type) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.description = description;
        this.type = type;
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
