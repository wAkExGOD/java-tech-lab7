package com.wakexgod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        // Test Log4j2:
        logger.info("Start program...");


        Mobile mobile = new Mobile();

        Mobile.Phone phone1 = new Mobile.Phone("Google", "Pixel 7", 50, 4355, 6.3, true);
        Mobile.Phone.CPU cpu1 = phone1.new CPU(2300, 4);
        mobile.addPhone(phone1);

        Mobile.Phone phone2 = new Mobile.Phone("Apple", "iPhone 14", 12, 3279, 6.1, false);
        Mobile.Phone.CPU cpu2 = phone2.new CPU(3200, 6);
        mobile.addPhone(phone2);

        Mobile.Phone phone3 = new Mobile.Phone("Samsung", "Galaxy S23", 50, 3900, 6.1, false);
        Mobile.Phone.CPU cpu3 = phone3.new CPU(2800, 8);
        mobile.addPhone(phone3);

        mobile.showPhoneList();

        /* anonymous class */
        Mobile mobileAnon = new Mobile() {
            @Override
            public void breakPhones(List<Phone> phoneList){
                for (Phone phone: phoneList) {
                    phone.setBroken(true);
                }
            }
        };

        mobileAnon.breakPhones(mobile.getPhoneList());

        Console.log("Телефоны сломали");
        mobile.showPhoneList();


        // Test Log4j2:
        logger.info("End program.");
    }
}