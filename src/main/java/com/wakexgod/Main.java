package com.wakexgod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        // Test Log4j2:
        logger.info("Start program...");

        City city = new City("Санкт-Петербург");

        // Используем внутренний класс для создания локаций
        City.Location loc1 = city.new Location("Храм", "Спаса на Крови");
        City.Location loc2 = city.new Location("Проспект", "Невский");
        City.Location loc3 = city.new Location("Площадь", "Дворцовая");

        city.addLocation(loc1);
        city.addLocation(loc2);
        city.addLocation(loc3);

        // Использование анонимного класса для создания новой локации
//        city.addLocation(city.new Location("Улица", "Ленина") {
//            @Override
//            public String getInfo() {
//                return "Анонимная локация: " + super.getInfo();
//            }
//        });

        city.displayLocations();
        City capital = new City("Москва") {
            public void displayLocations() {
                Console.log("====================");
                Console.log("Локации в столице " + getName() + ":");
                for (Location location : getLocations()) {
                    Console.log(location.getInfo());
                }
                Console.log("====================");
            }
        };
        City.Location capLoc1 = capital.new Location("Площадь", "Красная");
        capital.addLocation(capLoc1);
        capital.displayLocations();


        // Другой вариант создания анонимного класса:


        // Test Log4j2:
        logger.info("End program.");
    }
}