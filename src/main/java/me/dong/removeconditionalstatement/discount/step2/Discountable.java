package me.dong.removeconditionalstatement.discount.step2;

/**
 * 할인 핵심 인터페이스
 * <p>
 * Created by ethan.kim on 2018. 5. 13..
 */
public interface Discountable {

    /**
     * 할인 없음
     */
    Discountable NONE = originAmt -> 0;

    /**
     * 할인 금액 반환
     */
    long getDiscountAmt(long originAmt);
}