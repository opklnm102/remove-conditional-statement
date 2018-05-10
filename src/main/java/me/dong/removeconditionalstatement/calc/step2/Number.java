package me.dong.removeconditionalstatement.calc.step2;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * enum + map + BiFunction<>
 * <p>
 * Created by ethan.kim on 2018. 5. 9..
 */
public class Number {

    private int no;

    public Number(int no) {
        this.no = no;
    }

    public Number calculate(String expression, Number number) {
        return Calculation.findCalculation(expression).calculate(this, number);
    }

    private enum Calculation {
        ADD("+", (n1, n2) -> n1 + n2),
        SUB("-", (n1, n2) -> n1 - n2),
        MUL("*", (n1, n2) -> n1 * n2),
        DIV("/", (n1, n2) -> n1 / n2);

        Calculation(String expression, BiFunction<Integer, Integer, Integer> calculator) {
            this.expression = expression;
            this.calculator = calculator;
        }

        private String expression;

        private BiFunction<Integer, Integer, Integer> calculator;

        private static Map<String, Calculation> lookup;

        static {
            lookup = Arrays.stream(Calculation.values())
                    .collect(Collectors.toMap(o -> o.expression, Function.identity()));
        }

        private Number calculate(Number n1, Number n2) {
            return new Number(this.calculator.apply(n1.no, n2.no));
        }

        private static Calculation findCalculation(String expression) {
            return Optional.ofNullable(lookup.getOrDefault(expression, null)).orElseThrow(IllegalArgumentException::new);
        }
    }
}
