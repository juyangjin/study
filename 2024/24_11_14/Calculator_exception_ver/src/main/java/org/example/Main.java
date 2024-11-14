package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CalculatorApp calApp =  new CalculatorApp();
        boolean calculateEnded = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("계산을 시작하시겠습니까? 시작시 start를 입력해주세요.");
        String on = sc.nextLine();
        if(on.equals("start")) calculateEnded = true;

        while (calculateEnded){
            try {
                calApp.start();
                System.out.println("계산을 한번 더 하시겠습니까? exit를 입력시 계산기가 종료됩니다.");
                String end = sc.nextLine();
                if(end.equals("exit")) calculateEnded = false;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
