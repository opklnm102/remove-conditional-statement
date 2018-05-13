package me.dong.removeconditionalstatement.payment.step1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by ethan.kim on 2018. 5. 12..
 */
public enum PaymentGroup {
    CASH("현금", Arrays.asList(PaymentType.ACCOUNT_TRANSFER,PaymentType.REMITTANCE, PaymentType.ON_SITE_PAYMENT, PaymentType.TOSS)),
    CARD("카드", Arrays.asList(PaymentType.PAYCO, PaymentType.CREDIT_CARD, PaymentType.KAKAO_PAY, PaymentType.BAEMIN_PAY)),
    ETC("기타", Arrays.asList(PaymentType.POINT, PaymentType.COUPON)),
    EMPTY("없음", Collections.emptyList());

    private String title;

    private List<PaymentType> payments;

    PaymentGroup(String title, List<PaymentType> payments) {
        this.title = title;
        this.payments = payments;
    }

    public String getTitle() {
        return title;
    }

    public static PaymentGroup findByPayCode(PaymentType paymentType) {
        return Arrays.stream(PaymentGroup.values())
                .filter(paymentGroup -> paymentGroup.hasPayCode(paymentType))
                .findAny()
                .orElse(EMPTY);
    }

    public boolean hasPayCode(PaymentType paymentType) {
        return payments.stream()
                .anyMatch(payment -> payment == paymentType);
    }
}
