package me.dong.removeconditionalstatement.discount;

/**
 * 결제 서비스 인터페이스
 * <p>
 * Created by ethan.kim on 2018. 5. 13..
 */
public interface PaymentService {

    // 실시간 할인내역 확인
    Discount getDiscount(DiscountRequest request);

    // 결제처리
    void payment(PaymentRequest request);
}