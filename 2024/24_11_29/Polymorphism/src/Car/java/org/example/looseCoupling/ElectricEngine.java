package org.example.looseCoupling;

public class ElectricEngine implements  Engine {
    @Override
    public void run() {
        System.out.println("가스엔진이 동작합니다.");
    }
}
