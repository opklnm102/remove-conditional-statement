package me.dong.removeconditionalstatement.discount.step2.step2_2;

import me.dong.removeconditionalstatement.discount.Discount;
import me.dong.removeconditionalstatement.discount.DiscountRequest;
import me.dong.removeconditionalstatement.discount.PaymentRequest;
import me.dong.removeconditionalstatement.discount.PaymentService;
import me.dong.removeconditionalstatement.discount.step2.Discountable;

/**
 * Created by ethan.kim on 2018. 5. 13..
 */
public class PaymentService22 implements PaymentService {

    private DiscounterFactory discounterFactory = new SimpleDiscounterFactory();

    @Override
    public Discount getDiscount(DiscountRequest request) {
        // 상품금액
        long productAmt = request.getProductAmt();
        // 할인코드 (NAVER:네이버검색-10%, DANAWA:다나와검색-15% FANCAFE:팬카페-1000원)
        String discountCode = request.getDiscountCode();
        // 할인 정책
        Discountable discountPolicy = discounterFactory.getDiscounter(discountCode);
        
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
        Discountable discountPolicy = discounterFactory.getDiscounter(discountCode);

        // 결제금액
        long paymentAmt = productAmt - discountPolicy.getDiscountAmt(productAmt);

        // do something..
    }
}
