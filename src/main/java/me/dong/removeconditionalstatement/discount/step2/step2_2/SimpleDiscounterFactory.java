package me.dong.removeconditionalstatement.discount.step2.step2_2;

import me.dong.removeconditionalstatement.discount.step2.DanawaDiscountPolicy;
import me.dong.removeconditionalstatement.discount.step2.Discountable;
import me.dong.removeconditionalstatement.discount.step2.FancafeDiscountPolicy;
import me.dong.removeconditionalstatement.discount.step2.NaverDiscountPolicy;

/**
 * Created by ethan.kim on 2018. 5. 13..
 */
public class SimpleDiscounterFactory implements DiscounterFactory {

    /*
    issue. 메소드 호출시마다 객체 생성
    => Lazy Loading or 객체 생성시 초기화하도록 개선
     */
    @Override
    public Discountable getDiscounter(String discountName) {
        if ("NAVER".equals(discountName)) {  // 네이버 검색 할인
            return new NaverDiscountPolicy();
        } else if ("DANAWA".equals(discountName)) {  // 다나와 검색 할인
            return new DanawaDiscountPolicy();
        } else if ("FANCAFE".equals(discountName)) {  // 팬카페 인입 할인
            return new FancafeDiscountPolicy();
        }
        return Discountable.NONE;
    }
}
