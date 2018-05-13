package me.dong.removeconditionalstatement.discount.step1;

import me.dong.removeconditionalstatement.discount.Discount;
import me.dong.removeconditionalstatement.discount.DiscountRequest;
import me.dong.removeconditionalstatement.discount.PaymentRequest;
import me.dong.removeconditionalstatement.discount.PaymentService;

/**
 * Created by ethan.kim on 2018. 5. 13..
 */
public class PaymentService1 implements PaymentService {

    /*
    메소드 추출
    코드의 중복 제거
    issue - 할인에 관한 정책 분기를 결제 서비스의 책임으로 두는게 괜찮은가..?
    다른 객체에서 할인 로직 사용시 중복 발생
    => 책임(역할)을 기반으로 추상화
     */
    @Override
    public Discount getDiscount(DiscountRequest request) {
        // 상품금액
        long productAmt = request.getProductAmt();
        // 할인코드 (NAVER:네이버검색-10%, DANAWA:다나와검색-15% FANCAFE:팬카페-1000원)
        String discountCode = request.getDiscountCode();

        // 할인금액
        long discountAmt = getDiscountAmt(discountCode, productAmt);
        return Discount.of(discountAmt);
    }

    @Override
    public void payment(PaymentRequest request) {
        // 상품금액
        long productAmt = request.getProductAmt();
        // 할인코드 (NAVER:네이버검색-10%, DANAWA:다나와검색-15% FANCAFE:팬카페-1000원)
        String discountCode = request.getDiscountCode();

        // 결제금액
        long paymentAmt = productAmt - getDiscountAmt(discountCode, productAmt);

        // do something..
    }

    private long getDiscountAmt(String discountCode, long productAmt) {
        long discountAmt = 0;
        if ("NAVER".equals(discountCode)) {  // 네이버 검색 할인

            discountAmt = (long) (productAmt * 0.1);
        } else if ("DANAWA".equals(discountCode)) {  // 다나와 검색 할인

            discountAmt = (long) (productAmt * 0.15);
        } else if ("FANCAFE".equals(discountCode)) {  // 팬카페 인입 할인
            if (productAmt < 1000) {  // 할인쿠폰 금액보다 적은 경우
                discountAmt = productAmt;
            } else {
                discountAmt = 1000;
            }
        }
        return discountAmt;
    }
}
