package me.dong.removeconditionalstatement.discount.step2.step2_1;

import me.dong.removeconditionalstatement.discount.Discount;
import me.dong.removeconditionalstatement.discount.DiscountRequest;
import me.dong.removeconditionalstatement.discount.PaymentRequest;
import me.dong.removeconditionalstatement.discount.PaymentService;
import me.dong.removeconditionalstatement.discount.step2.DanawaDiscountPolicy;
import me.dong.removeconditionalstatement.discount.step2.Discountable;
import me.dong.removeconditionalstatement.discount.step2.FancafeDiscountPolicy;
import me.dong.removeconditionalstatement.discount.step2.NaverDiscountPolicy;

/**
 * Created by ethan.kim on 2018. 5. 13..
 */
public class PaymentService21 implements PaymentService {

    /*
    PaymentService1의 할인 정책 책임 issue를 추상화를 통해 해결
    책임(역할)을 기반으로 분리할 도메인 로직의 핵심을 집어낸다
    할인 로직의 핵심 -> 할인 금액 구하기
     */
    @Override
    public Discount getDiscount(DiscountRequest request) {
        // 상품금액
        long productAmt = request.getProductAmt();
        // 할인코드 (NAVER:네이버검색-10%, DANAWA:다나와검색-15% FANCAFE:팬카페-1000원)
        String discountCode = request.getDiscountCode();
        // 할인 정책
        Discountable discountPolicy = getDiscounter(discountCode);

        // 할인금액
        long discountAmt = discountPolicy.getDiscountAmt(productAmt);
        return Discount.of(discountAmt);
    }

    @Override
    public void payment(PaymentRequest request) {
        // 상품금액
        long productAmt = request.getProductAmt();
        // 할인코드 (NAVER:네이버검색-10%, DANAWA:다나와검색-15% FANCAFE:팬카페-1000원)
        String discountCode = request.getDiscountCode();
        // 할인 정책
        Discountable discountPolicy = getDiscounter(discountCode);

        // 결제금액
        long paymentAmt = productAmt - discountPolicy.getDiscountAmt(productAmt);

        // do something..
    }

    /*
    issue
    interface를 추출했으나 factory method가 객체내에 있기 때문에 PaymentService와 강결합 상태
    => 정책 생성의 책임을 가지는 Factory로 분리
     */
    private Discountable getDiscounter(String discountCode) {
        if ("NAVER".equals(discountCode)) {  // 네이버 검색 할인
            return new NaverDiscountPolicy();
        } else if ("DANAWA".equals(discountCode)) {  // 다나와 검색 할인
            return new DanawaDiscountPolicy();
        } else if ("FANCAFE".equals(discountCode)) {  // 팬카페 인입 할인
            return new FancafeDiscountPolicy();
        }
        return Discountable.NONE;
    }
}
