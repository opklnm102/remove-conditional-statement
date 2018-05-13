package me.dong.removeconditionalstatement.payment;

import me.dong.removeconditionalstatement.payment.legacy.LegacyPaymentGroup;
import me.dong.removeconditionalstatement.payment.step1.PaymentGroup;
import me.dong.removeconditionalstatement.payment.step1.PaymentType;

/**
 * Created by ethan.kim on 2018. 5. 13..
 */
public class PaymentService {

    private final LegacyPaymentGroup legacyPaymentGroup;

    public PaymentService(LegacyPaymentGroup legacyPaymentGroup) {
        this.legacyPaymentGroup = legacyPaymentGroup;
    }

    public void testLegacy(String payCode) {
        String payGroup = LegacyPaymentGroup.getPayGroup(payCode);

        legacyPaymentGroup.pushByPayGroup(payGroup);
    }

    public void test(String payCode) {
        PaymentType paymentType = getPaymentType(payCode);
        PaymentGroup paymentGroup = PaymentGroup.findByPayCode(paymentType);
    }

    private PaymentType getPaymentType(String payCode) {
        return PaymentType.ACCOUNT_TRANSFER;
    }

}
