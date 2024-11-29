package org.example.looseCoupling;


public class Main {
    public static void main(String[] args) {

        GasEngine gasEngine =new GasEngine();
        ElectricEngine electricEngine = new ElectricEngine();

        Car gasCar = new Car(gasEngine);
        gasCar.drive();
    }
}