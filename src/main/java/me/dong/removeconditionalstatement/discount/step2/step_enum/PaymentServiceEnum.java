package me.dong.removeconditionalstatement.discount.step2.step_enum;

import me.dong.removeconditionalstatement.discount.Discount;
import me.dong.removeconditionalstatement.discount.DiscountRequest;
import me.dong.removeconditionalstatement.discount.PaymentRequest;
import me.dong.removeconditionalstatement.discount.PaymentService;
import me.dong.removeconditionalstatement.discount.step2.Discountable;

/**
 * Created by ethan.kim on 2018. 5. 13..
 */
public class PaymentServiceEnum implements PaymentService {

    /*
    enum
    데이터가 정적(변화할 가능성이 없는)인 경우에만 사용하는게 좋다

    단점
        상태가 변할 수 없다
        상속, 확장이 일부 제한되기 때문에 유연성이 떨어진다

     issue
     할인률이 변경되면 코드 수정 후 application 배포 필요
     Factory를 사용해도 마찬가지
     => Entity로 분리
     */
    @Override
    public Discount getDiscount(DiscountRequest request) {
        // 상품금액
        long productAmt = request.getProductAmt();
        // 할인코드 (NAVER:네이버검색-10%, DANAWA:다나와검색-15% FANCAFE:팬카페-1000원)
        String discountCode = request.getDiscountCode();
        // 할인 정책
        Discountable discountPolicy = DiscountPolicy.getDiscounter(discountCode);

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
        Discountable discountPolicy = DiscountPolicy.getDiscounter(discountCode);

        // 결제금액
        long paymentAmt = productAmt - discountPolicy.getDiscountAmt(productAmt);

        // do something..
    }
}
