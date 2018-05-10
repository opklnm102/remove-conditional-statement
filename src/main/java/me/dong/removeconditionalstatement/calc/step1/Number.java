package me.dong.removeconditionalstatement.calc.step1;

/**
 * Java8 이전 - enum + interface
 * <p>
 * Created by ethan.kim on 2018. 5. 9..
 */

// 이것도 보기 http://redutan.github.io/2016/03/31/anti-oop-if
public class Number {

    private int no;

    public Number(int no) {
        this.no = no;
    }

    public Number calculate(String expression, Number number) {
        return Calculation.findCalculation(expression).calculate(this, number);
    }

    private enum Calculation {
        ADD("+", new Calculator() {

            @Override
            public int calculate(int n1, int n2) {
                return n1 + n2;
            }
        }),
        SUB("-", new Calculator() {
            @Override
            public int calculate(int n1, int n2) {
                return n1 - n2;
            }
        }),
        MUL("*", new Calculator() {
            @Override
            public int calculate(int n1, int n2) {
                return n1 * n2;
            }
        }),
        DIV("/", new Calculator() {
            @Override
            public int calculate(int n1, int n2) {
                return n1 / n2;
            }
        });

        Calculation(String expression, Calculator calculator) {
            this.expression = expression;
            this.calculator = calculator;
        }

        private String expression;

        private Calculator calculator;

        private interface Calculator {

            int calculate(int n1, int n2);
        }

        private Number calculate(Number n1, Number n2) {
            return new Number(this.calculator.calculate(n1.no, n2.no));
        }

        private boolean isMatchedExpression(String expression) {
            return this.expression.equals(expression);
        }

        private static Calculation findCalculation(String expression) {
            for (Calculation calculation : Calculation.values()) {
                if (calculation.isMatchedExpression(expression)) {
                    return calculation;
                }
            }
            throw new IllegalArgumentException();
        }
    }
}
