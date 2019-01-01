package com.snowy.snowysworld;

public class Location {
    String description;
    double latitude;
    double longitude;
    Type   type;

    public Location(final String description, double latitude, double longitude, Type type) {
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public Type getType() {
        return type;
    }
}
