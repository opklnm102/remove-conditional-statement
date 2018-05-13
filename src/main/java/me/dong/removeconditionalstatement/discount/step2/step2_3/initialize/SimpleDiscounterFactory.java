package me.dong.removeconditionalstatement.discount.step2.step2_3.initialize;

import me.dong.removeconditionalstatement.discount.step2.DanawaDiscountPolicy;
import me.dong.removeconditionalstatement.discount.step2.Discountable;
import me.dong.removeconditionalstatement.discount.step2.FancafeDiscountPolicy;
import me.dong.removeconditionalstatement.discount.step2.NaverDiscountPolicy;
import me.dong.removeconditionalstatement.discount.step2.step2_2.DiscounterFactory;

/**
 * Created by ethan.kim on 2018. 5. 13..
 */
public class SimpleDiscounterFactory implements DiscounterFactory {

    /*
     issue. 메소드 호출시마다 객체 생성
     => 객체 생성시 초기화

     issue. 할인 정책이 증가할수록 아래 if문과 필드가 늘어난다
     */
    private Discountable naver;

    private Discountable danawa;

    private Discountable fancafe;

    public SimpleDiscounterFactory() {
        naver = new NaverDiscountPolicy();
        danawa = new DanawaDiscountPolicy();
        fancafe = new FancafeDiscountPolicy();
    }

    @Override
    public Discountable getDiscounter(String discountName) {
        if ("NAVER".equals(discountName)) {  // 네이버 검색 할인
            return naver;
        } else if ("DANAWA".equals(discountName)) {  // 다나와 검색 할인
            return danawa;
        } else if ("FANCAFE".equals(discountName)) {  // 팬카페 인입 할인
            return fancafe;
        }
        return Discountable.NONE;
    }
}
