package com.lab1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.lab1.Cars.Car;
import com.lab1.Cars.Ford;
import com.lab1.Cars.Mercedes;
import com.lab1.Cars.SertifiedCar;
import com.lab1.Cars.Tesla;
import com.lab1.Cars.Toyota;
import com.lab1.Cars.Wolksvagen;


class Parking<T extends Car> implements Iterable<T> {
    private final List<T> cars;

    Parking() {
        this.cars = new ArrayList<>();
    }

    public Iterator<T> iterator() {
        return this.cars.iterator();
    }

    public void addCar(T car) {
        this.cars.add(car);
    }

    public void removeCar(T car) {
        this.cars.remove(car);
    }

    public void sortByFuelConsumption() {
        this.cars.sort(Comparator.comparing(Car::getFuelConsumption));
    }
}

class TaxiCompany extends Parking<SertifiedCar> {
    public List<SertifiedCar> getCarsBySpeed(Double minSpeed, Double maxSpeed) {
        List<SertifiedCar> cars = new ArrayList<>();
        for (SertifiedCar car : this) {
            if (car.getSpeed() > minSpeed && car.getSpeed() < maxSpeed) {
                cars.add(car);
            }
        }
        return cars;
    }
    public Double getOverallCost() {
        Double cost = 0.0;
        for (SertifiedCar car : this) {
            cost += car.getCost();
        }
        return cost;
    }
}

public class App {
    public static void main(String[] args)
    {
        Toyota toyota = new Toyota(10000.0, "Camry", 10.0, 200.0);
        Wolksvagen wolksvagen = new Wolksvagen(20000.0, "Golf", 15.0, 250.0);
        Tesla tesla = new Tesla(30000.0, "Model 3", 5.0, 300.0);
        Ford ford = new Ford(40000.0, "Mustang", 20.0, 350.0);
        Mercedes mercedes = new Mercedes(50000.0, "C-Class", 15.0, 250.0);

        TaxiCompany taxiCompany = new TaxiCompany();
        taxiCompany.addCar(toyota);
        taxiCompany.addCar(wolksvagen);
        taxiCompany.addCar(tesla);
        taxiCompany.addCar(ford);
        taxiCompany.addCar(mercedes);

        System.out.println("Overall cost: " + taxiCompany.getOverallCost());

        taxiCompany.sortByFuelConsumption();

        List<SertifiedCar> cars = taxiCompany.getCarsBySpeed(200.0, 300.0);
        if (cars.isEmpty()) {
            System.out.println("No cars found with speed between 200 and 300");
            return;
        }
        System.out.println("Car with speed between 200 and 300: " + cars.getFirst().getModel());
    }
}
