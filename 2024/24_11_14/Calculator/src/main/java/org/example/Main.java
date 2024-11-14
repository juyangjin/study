package org.example;

import java.util.Scanner;

public class Main extends AbstractOperation{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;

        System.out.println("정수 두 개를 입력하세요.");
        int firstNumber = sc.nextInt();
        int secondNumber = sc.nextInt();
        System.out.println("연산자를 입력하세요.");
        String tmp = sc.nextLine();//스캔오류 방지
        String operator = sc.nextLine();

        if (operator.equals("/")) {
            DivideOperation div = new DivideOperation();
            double d_result = div.operate(firstNumber, secondNumber);
            System.out.println("결과는 " + d_result + "입니다.");
        } else {
            if (operator.equals("+")) {
                AddOperation add = new AddOperation();
                result = (int) add.operate(firstNumber, secondNumber);
            } else if (operator.equals("-")) {
                SubstractOperation sub = new SubstractOperation();
                result = (int) sub.operate(firstNumber, secondNumber);
            } else if (operator.equals("*")) {
                MultiplyOperation mul = new MultiplyOperation();
                result = (int) mul.operate(firstNumber, secondNumber);
            } else {
                System.out.println("잘못 입력하셨습니다.");
            }
            System.out.println("결과는 " + result + "입니다.");
        }
    }
}
