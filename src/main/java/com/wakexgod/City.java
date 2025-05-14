package com.wakexgod;

import java.util.ArrayList;
import java.util.List;

public class City {
    private final String name;
    private final List<Location> locations;

    public City(String name) {
        this.name = name;
        this.locations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void addLocation(Location location) {
        locations.add(location);
    }

    public void displayLocations() {
        Console.log("Локации в городе " + name + ":");
        for (Location location : locations) {
            Console.log(location.getInfo());
        }
    }

    // Внутренний класс
    public class Location {
        private String type; // Тип: проспект, улица, площадь
        private String name;

        public Location(String type, String name) {
            this.type = type;
            this.name = name;
        }

        public String getInfo() {
            return type + ": " + name;
        }
    }
}