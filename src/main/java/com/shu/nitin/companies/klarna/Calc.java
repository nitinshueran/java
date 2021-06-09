package com.shu.nitin.companies.klarna;

import java.util.Stack;

public class Calc {

    public static void main(String[] args) {
        System.out.println(Calc.evaluate("123"));
    }

    static double evaluate(String expr) {
        if (null == expr || "".equals(expr.trim()) || expr.length() == 0) {
            return 0;
        }
        Stack<Double> operationStack = new Stack<>();
        for (String numberOrOperation : expr.split(" ")) {

            if (numberOrOperation.matches("-?\\d+(\\.\\d+)?"))
                operationStack.push(Double.parseDouble(numberOrOperation));
            else {
                double firstValue = operationStack.pop();
                double secondValue = operationStack.pop();

                switch (numberOrOperation) {
                    case "+":
                        operationStack.push(secondValue + firstValue);
                        break;

                    case "-":
                        operationStack.push(secondValue - firstValue);
                        break;

                    case "/":
                        operationStack.push(secondValue / firstValue);
                        break;

                    case "*":
                        operationStack.push(secondValue * firstValue);
                        break;
                }
            }
        }
        return operationStack.pop();
    }
}
