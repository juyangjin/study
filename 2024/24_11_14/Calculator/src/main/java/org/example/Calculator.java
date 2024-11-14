package org.example;

public class Calculator {
    public static double calculate(String operator, int firstNumber, int secondNumber) {
        AddOperation add = new AddOperation();
        SubstractOperation sub = new SubstractOperation();
        MultiplyOperation mul = new MultiplyOperation();
        DivideOperation div = new DivideOperation();
        int result = 0;

        if (operator.equals("/")) {
            double d_result = div.operate(firstNumber, secondNumber);
            System.out.println("결과는 " + d_result + "입니다.");
        } else {
            if (operator.equals("+")) {
                result = add.operate(firstNumber, secondNumber);
            } else if (operator.equals("-")) {
                result = sub.operate(firstNumber, secondNumber);
            } else if (operator.equals("*")) {
                result = mul.operate(firstNumber, secondNumber);
            } else {
                System.out.println("잘못 입력하셨습니다.");
            }
            System.out.println("결과는 " + result + "입니다.");
        }
        return 0;
    }
}
