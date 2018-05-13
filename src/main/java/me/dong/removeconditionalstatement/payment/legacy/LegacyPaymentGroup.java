package me.dong.removeconditionalstatement.payment.legacy;

/**
 * Created by ethan.kim on 2018. 5. 12..
 */
/*
참고 - http://woowabros.github.io/tools/2017/07/10/java-enum-uses.html

결제
결제 종류와 결제 수단이라는 2가지 형태로 표현

현금 - 계좌이체, 무통장 입금, 현장결제, 토스
카드 - 페이코, 신용카드, 카카오페이, 배민페이
기타 - 포인트, 쿠폰

신용카드 결제 = 신용카드 결제(수단), 카드(종류)
계좌이체 = 계좌이체(수단), 현금(종류)

결제건이 어떤 수단으로 진행됐으며, 어느 결제 종류에 속하는지를 확인해야 하는 요구사항
 */
public class LegacyPaymentGroup {

    public static String getPayGroup(String payCode) {

        if ("ACCOUNT_TRANSFER".equals(payCode)
                || "REMITTANCE".equals(payCode)
                || "ON_SITE_PAYMENT".equals(payCode)
                || "TOSS".equals(payCode)) {
            return "CASH";
        }

        if ("PAYCO".equals(payCode)
                || "CREDIT_CARD".equals(payCode)
                || "KAKAO_PAY".equals(payCode)
                || "BAEMIN_PAY".equals(payCode)) {
            return "CARD";
        }

        if ("POINT".equals(payCode)
                || "COUPON".equals(payCode)) {
            return "ETC";
        }

        return "EMPTY";
    }

    // 결제 종류에 따라 추가 기능이 필요할 경우 이런 메소드가 계속 생긴다
    public void pushByPayGroup(final String payGroudCode) {
        if ("CASH".equals(payGroudCode)) {
            pushCashMethod();
        } else if ("CARD".equals(payGroudCode)) {
            pushCardMethod();
        } else if ("ETC".equals(payGroudCode)) {
            pushEtcMethod();
        } else {
            throw new IllegalArgumentException("not supported payGroupCode");
        }
    }

    private void pushCashMethod() {
        // do something..
    }

    private void pushCardMethod() {
        // do something..
    }

    private void pushEtcMethod() {
        // do something..
    }
}
