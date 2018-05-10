package me.dong.removeconditionalstatement.calc;

/**
 * Created by ethan.kim on 2018. 5. 10..
 */
/*
오늘 리팩토링할 코드는 사칙연산을 계산하는 메소드이다.
Number라는 클래스는 int를 생성자의 인자로 가지며, 사칙연산을 실행하는 calculate() 메소드가 있다.
이 메소드는 사칙연산 기호에 따라 덧셈, 뺄쎔, 곱셈, 나눗셈 연산을 하는 메소드이다.
나눗셈 결과는 int로 가정하고 구현했다.
이 코드에 대한 리팩토링 요구사항은 calculate() 메소드에서 발생하는 if 문을 제거하는 것이다.
일반적으로 if/else로 구현하겠지만 else를 사용하지 않고 if만으로 구현했다.
어떻게 제거할 수 있을까?

힌트 - 자바의 다형성, enum 등을 활용해 제거해 본다.
출처 - https://www.slipp.net/questions/566
 */
public class Number {

    private int no;

    public Number(int no) {
        this.no = no;
    }

    public Number calculate(String expression, Number number) {
        if ("+".equals(expression)) {
            return new Number(this.no + number.no);
        }

        if ("-".equals(expression)) {
            return new Number(this.no - number.no);
        }

        if ("*".equals(expression)) {
            return new Number(this.no * number.no);
        }

        if ("/".equals(expression)) {
            return new Number(this.no / number.no);
        }

        throw new IllegalArgumentException();
    }
}
