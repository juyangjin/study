package org.example;

import java.util.Scanner;

public class Calculator {
    public static double calculate(String operator, int firstNumber, int secondNumber) {
        int result = 0;

        if (operator.equals("/")) {
            double doubleResult = (double) firstNumber / secondNumber;
            System.out.println("결과는 " + doubleResult + "입니다.");
        } else {
            if (operator.equals("+")) {
                result = firstNumber + secondNumber;
            } else if (operator.equals("-")) {
                result = firstNumber - secondNumber;
            } else if (operator.equals("*")) {
                result = firstNumber * secondNumber;
            } else {
                System.out.println("잘못 입력하셨습니다.");
            }
            System.out.println("결과는 " + result + "입니다.");
        }
        return 0;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("정수 두 개를 입력하시오");
        int firstNumber = sc.nextInt();
        int secondNumber = sc.nextInt();
        System.out.println("+,-,*,/ 중에 한 가지 연산자를 입력하시오");
        String tmp = sc.nextLine(); // 스캐너 문제로 한 줄 tmp 입력
        String operator = sc.nextLine();

        calculate(operator,firstNumber,secondNumber);

    }
}