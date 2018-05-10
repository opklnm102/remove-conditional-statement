package me.dong.removeconditionalstatement.calc.step3;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;

/**
 * map + BiFunction<>
 * Created by ethan.kim on 2018. 5. 9..
 */
public class Number {

    private static final Map<String, BiFunction<Number, Number, Number>> operators = new HashMap<>();

    static {
        operators.put("+", (a, b) -> new Number(a.no + b.no));
        operators.put("-", (a, b) -> new Number(a.no - b.no));
        operators.put("*", (a, b) -> new Number(a.no * b.no));
        operators.put("/", (a, b) -> new Number(a.no / b.no));
    }

    private int no;

    public Number(int no) {
        this.no = no;
    }

    public Number calculate(String expression, Number number) {
        BiFunction<Number, Number, Number> operator = Optional.ofNullable(operators.getOrDefault(expression, null))
                .orElseThrow(IllegalArgumentException::new);
        return operator.apply(this, number);
    }
}
