package uy.infocorp.banking.glass.model.benefit;

import uy.infocorp.banking.glass.R;

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

    public int getIconId() {
        if (Type.AUTOMOBILES.equals(type)) {
            return R.drawable.benefit_automobile;
        } else if (Type.CLOTHES_AND_FOOTWEAR.equals(type)) {
            return R.drawable.benefit_shop;
        } else if (Type.ENTERTAINMENT.equals(type)) {
            return R.drawable.benefit_entertainment;
        } else if (Type.HEALTH_AND_SPORT.equals(type)) {
            return R.drawable.benefit_health_and_sport;
        } else if (Type.HOME.equals(type)) {
            return R.drawable.benefit_home;
        } else if (Type.OTHERS.equals(type)) {
            return R.drawable.benefit_other;
        } else if (Type.RESTAURANTS.equals(type)) {
            return R.drawable.benefit_shop;
        } else if (Type.SERVICES.equals(type)) {
            return R.drawable.benefit_shop;
        } else if (Type.SUPERMARKETS_AND_STORES.equals(type)) {
            return R.drawable.benefit_shop;
        } else if (Type.TECHNOLOGY.equals(type)) {
            return R.drawable.benefit_technology;
        } else if (Type.TRAVEL.equals(type)) {
            return R.drawable.benefit_travel;
        } else {
            return R.drawable.benefit_other;
        }
    }
}
