package org.example.looseCoupling;

public class GasEngine implements Engine{

    //기능
    @Override
    public void run() {
        System.out.println("가스 엔진이 동작합니다.");
    }
}
