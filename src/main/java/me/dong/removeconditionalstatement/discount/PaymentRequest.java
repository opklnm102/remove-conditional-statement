package me.dong.removeconditionalstatement.discount;

import lombok.Value;

/**
 * Created by ethan.kim on 2018. 5. 13..
 */
@Value
public class PaymentRequest {

    // 할인코드 (NAVER:네이버검색-10%, DANAWA:다나와검색-15% FANCAFE:팬카페-1000원)
    private String discountCode;

    // 상품금액
    private long productAmt;
}