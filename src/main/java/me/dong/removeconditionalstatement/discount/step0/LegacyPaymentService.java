package me.dong.removeconditionalstatement.discount.step0;

import me.dong.removeconditionalstatement.discount.Discount;
import me.dong.removeconditionalstatement.discount.DiscountRequest;
import me.dong.removeconditionalstatement.discount.PaymentRequest;
import me.dong.removeconditionalstatement.discount.PaymentService;

/**
 * 출처 - http://meetup.toast.com/posts/94
 *
 * Created by ethan.kim on 2018. 5. 13..
 */
public class LegacyPaymentService implements PaymentService {

    /*
     할인 정책을 분기하는 코드
     issue - if의 중복
     => 메소드 추출
      */
    @Override
    public Discount getDiscount(DiscountRequest request) {
        // 상품금액
        long productAmt = request.getProductAmt();
        // 할인코드 (NAVER:네이버검색-10%, DANAWA:다나와검색-15% FANCAFE:팬카페-1000원)
        String discountCode = request.getDiscountCode();

        // 할인금액
        long discountAmt = 0;
        if ("NAVER".equals(discountCode)) {   // 네이버검색 할인
            discountAmt = (long) (productAmt * 0.1);
        } else if ("DANAWA".equals(discountCode)) { // 다나와검색 할인
            discountAmt = (long) (productAmt * 0.15);
        } else if ("FANCAFE".equals(discountCode)) {  // 팬카페인입 할인
            if (productAmt < 1000)  // 할인쿠폰 금액보다 적은경우
                discountAmt = productAmt;
            else
                discountAmt = 1000;
        }
        return Discount.of(discountAmt);
    }

    @Override
    public void payment(PaymentRequest request) {
        // 상품금액
        long productAmt = request.getProductAmt();
        // 할인코드 (NAVER:네이버검색-10%, DANAWA:다나와검색-15% FANCAFE:팬카페-1000원)
        String discountCode = request.getDiscountCode();

        // 결제금액
        long paymentAmt = 0;
        if ("NAVER".equals(discountCode)) {   // 네이버검색 할인
            paymentAmt = (long) (productAmt * 0.9);
        } else if ("DANAWA".equals(discountCode)) { // 다나와검색 할인
            paymentAmt = (long) (productAmt * 0.85);
        } else if ("FANCAFE".equals(discountCode)) {  // 팬카페인입 할인
            if (productAmt < 1000)  // 할인쿠폰 금액보다 적은경우
                paymentAmt = 0;
            else
                paymentAmt = productAmt - 1000;
        } else {
            paymentAmt = productAmt;
        }

        // do something..
    }
}
