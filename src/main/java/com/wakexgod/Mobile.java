package com.wakexgod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mobile {
    private static final Logger logger = LogManager.getLogger(Mobile.class);

    private List<Phone> phoneList = new ArrayList<>();

    public void addPhone(Phone phone){
        phoneList.add(phone);
    }

    public void showPhoneList() {
        if (phoneList.size() > 0){
            for (Phone phone: phoneList) {
                Console.log(phone.toString());
            }
        } else{
            Console.log("Каталог телефонов пуст!");
        }
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void repairPhone(Phone phone){
        phone.isBroken = false;
    }

    public void breakPhone(Phone phone){
        phone.isBroken = true;
    }

    public void breakPhones(List<Phone> phoneList) {
        Random random = new Random();
        int x = random.nextInt(phoneList.size() + 1);
        phoneList.get(x).setBroken(true);
    }

    /* nested class */
    public static class Phone {
        private String manufacturer;
        private String model;
        private int cameraResolution;
        private int batteryCapacity;
        private double screenResolution;
        boolean isBroken;
        private CPU cpu;

        /* inner class */
        public class CPU {
            private int cpuFrequency;
            private int cpuKernels;

            public CPU(int cpuFrequency, int cpuKernels) {
                this.cpuFrequency = cpuFrequency;
                this.cpuKernels = cpuKernels;
                cpu = this;
            }
        }

        public Phone(
                String manufacturer,
                String model,
                int cameraResolution,
                int batteryCapacity,
                double screenResolution,
                boolean isBroken
        ) {
            this.manufacturer = manufacturer;
            this.model = model;
            this.cameraResolution = cameraResolution;
            this.batteryCapacity = batteryCapacity;
            this.screenResolution = screenResolution;
            this.isBroken = isBroken;
        }

        public void setBroken(boolean broken) {
            isBroken = broken;
        }

        @Override
        public String toString() {
            String str = "Производитель: " + manufacturer +
                    ", Модель: " + model +
                    ", Разрешение камеры: " + cameraResolution + "МП" +
                    ", Емкость аккумулятора: " + batteryCapacity + "мА*ч" +
                    ", Диагональ экрана: " + screenResolution + "\"" +
                    ". Процессор: Частота: " + cpu.cpuFrequency + "МГц, (кол-во ядер: " + cpu.cpuKernels + "). ";
            if (isBroken) {
                str += "Телефона разбит.";
            } else {
                str += "Телефон исправен.";
            }

            return str;
        }
    }
}
