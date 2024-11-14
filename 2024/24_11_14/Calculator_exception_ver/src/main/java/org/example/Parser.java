package org.example;

import java.util.regex.Pattern;

public class Parser {
    private static final String OPERATION_REG = "[+\\-*/]";
    private static final String NUMBER_REG = "^[0-9]*$";

    private final Calculator calculator = new Calculator();

    public Parser parseFirstNum(String firstInput) throws BadInputException {
        if(!Pattern.matches(NUMBER_REG,firstInput)){
            throw new BadInputException("숫자");
        }

        this.calculator.setFirstNumber(Integer.parseInt(firstInput));
        return this;
    }

    public Parser parseSecondNum(String secondInput) throws BadInputException {
        if(!Pattern.matches(NUMBER_REG,secondInput)){
            throw new BadInputException("숫자");
        }
        this.calculator.setSecondNumber(Integer.parseInt(secondInput));
        return this;
    }

    public Parser parseOperator(String operationInput) throws BadInputException {
        if(!Pattern.matches(OPERATION_REG,operationInput)){
            throw new BadInputException("연산자");
        }

        switch (operationInput){
            case "+" : this.calculator.setOperation(new AddOperation()); break;
            case "-" : this.calculator.setOperation(new SubstractOperation()); break;
            case "*" : this.calculator.setOperation(new MultiplyOperation()); break;
            case "/" : this.calculator.setOperation(new DivideOperation()); break;
        }

        return this;
    }

    public double executeCalculator() {
        return calculator.calculate();
    }
}



