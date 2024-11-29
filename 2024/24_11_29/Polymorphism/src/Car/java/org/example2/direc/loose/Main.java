package org.example2.direc.loose;

public class Main {
    public static void main(String[] args){
        Brake brakeA = new Brake("디스크 브레이크");

        InspectService inspectService = new InspectService();
        inspectService.inspect(brakeA);
    }
}
