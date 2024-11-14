package org.example;

import java.util.Scanner;

public class Cal {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        Scanner sc = new Scanner(System.in);

        System.out.println("정수 두 개를 입력하시오");
        int firstNumber = sc.nextInt();
        int secondNumber = sc.nextInt();
        System.out.println("+,-,*,/ 중에 한 가지 연산자를 입력하시오");
        String tmp = sc.nextLine(); // 스캐너 문제로 한 줄 tmp 입력
        String operator = sc.nextLine();

        cal.calculate(operator, firstNumber, secondNumber);

    }
}
