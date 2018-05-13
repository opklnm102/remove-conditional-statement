package me.dong.removeconditionalstatement.discount.step2.step2_3.lazy;

import me.dong.removeconditionalstatement.discount.step2.Discountable;
import me.dong.removeconditionalstatement.discount.step2.step2_2.DiscounterFactory;

/**
 * Created by ethan.kim on 2018. 5. 13..
 */
public class SimpleDiscounterFactory implements DiscounterFactory {

    /*
    issue. 메소드 호출시마다 객체 생성
    => Lazy Loading
     */
    @Override
    public Discountable getDiscounter(String discountName) {
        if ("NAVER".equals(discountName)) {  // 네이버 검색 할인
            return NaverDiscountPolicy.getInstance();
        } else if ("DANAWA".equals(discountName)) {  // 다나와 검색 할인
            return DanawaDiscountPolicy.getInstance();
        } else if ("FANCAFE".equals(discountName)) {  // 팬카페 인입 할인
            return FancafeDiscountPolicy.getInstance();
        }
        return Discountable.NONE;
    }
}
