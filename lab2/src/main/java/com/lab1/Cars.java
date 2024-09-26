package com.lab1;

public class Cars {
    private Cars() {
      throw new IllegalStateException("Utility class");
    }

    public static class Car {
        protected Double fuelConsumption;
        protected Double speed;
    
        Car(Double fuelConsumption, Double speed) {
            this.fuelConsumption = fuelConsumption;
            this.speed = speed;
        }
    
        public Double getFuelConsumption() {
            return this.fuelConsumption;
        }
    
        public Double getSpeed() {
            return this.speed;
        }
    
        @Override
        public String toString() {
            return "Car{" +
                    "fuelConsumption=" + fuelConsumption +
                    ", speed=" + speed +
                    '}';
        }
    }
    
    public abstract static class SertifiedCar extends Car {
        protected Double cost;
        protected String model;
    
        SertifiedCar(Double cost, String model, Double fuelConsumption, Double speed) {
            super(fuelConsumption, speed);
            this.cost = cost;
            this.model = model;
        }
    
        public Double getCost() {
            return this.cost;
        }
    
        public String getModel() {
            return this.model;
        }
    
        @Override
        public String toString() {
            return "SertifiedCar{" +
                    "cost=" + cost +
                    ", model='" + model + '\'' +
                    ", fuelConsumption=" + fuelConsumption +
                    ", speed=" + speed +
                    '}';
        }
    }
    
    public static class Toyota extends SertifiedCar {
        Toyota(Double cost, String model, Double fuelConsumption, Double speed) {
            super(cost, model, fuelConsumption, speed);
        }
    }
    
    public static class Wolksvagen extends SertifiedCar {
        Wolksvagen(Double cost, String model, Double fuelConsumption, Double speed) {
            super(cost, model, fuelConsumption, speed);
        }
    }
    
    public static class Tesla extends SertifiedCar {
        Tesla(Double cost, String model, Double fuelConsumption, Double speed) {
            super(cost, model, fuelConsumption, speed);
        }
    }
    
    public static class Ford extends SertifiedCar {
        Ford(Double cost, String model, Double fuelConsumption, Double speed) {
            super(cost, model, fuelConsumption, speed);
        }
    }
    
    public static class Mercedes extends SertifiedCar {
        Mercedes(Double cost, String model, Double fuelConsumption, Double speed) {
            super(cost, model, fuelConsumption, speed);
        }
    }
}
