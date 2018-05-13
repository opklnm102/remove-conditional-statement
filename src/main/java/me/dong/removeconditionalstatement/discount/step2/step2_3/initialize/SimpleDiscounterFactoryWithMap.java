package me.dong.removeconditionalstatement.discount.step2.step2_3.initialize;

import java.util.HashMap;
import java.util.Map;

import me.dong.removeconditionalstatement.discount.step2.DanawaDiscountPolicy;
import me.dong.removeconditionalstatement.discount.step2.Discountable;
import me.dong.removeconditionalstatement.discount.step2.FancafeDiscountPolicy;
import me.dong.removeconditionalstatement.discount.step2.NaverDiscountPolicy;
import me.dong.removeconditionalstatement.discount.step2.step2_2.DiscounterFactory;

/**
 * Created by ethan.kim on 2018. 5. 13..
 */
public class SimpleDiscounterFactoryWithMap implements DiscounterFactory {

    /*
     issue. 메소드 호출시마다 객체 생성
     => 객체 생성시 초기화

     할인 정책이 증가할수록 아래 if문과 필드가 늘어난다
     => Map으로 if를 없앤다
     */
    private Map<String, Discountable> discountableMap;

    public SimpleDiscounterFactoryWithMap() {
        discountableMap = new HashMap<>();
        discountableMap.put("NAVER", new NaverDiscountPolicy());
        discountableMap.put("DANAWA", new DanawaDiscountPolicy());
        discountableMap.put("FANCAFE", new FancafeDiscountPolicy());
    }

    @Override
    public Discountable getDiscounter(String discountName) {
        return discountableMap.getOrDefault(discountName, Discountable.NONE);
    }
}
