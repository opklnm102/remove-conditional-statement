package me.dong.removeconditionalstatement.discount.step2.step2_3.lazy;

import me.dong.removeconditionalstatement.discount.step2.Discountable;

/**
 * Created by ethan.kim on 2018. 5. 13..
 */
public class FancafeDiscountPolicy implements Discountable {

    private long discountAmt = 1000L;

    private static class FancafeDiscountPolicyHolder {

        public static FancafeDiscountPolicy instance = new FancafeDiscountPolicy();
    }

    public static FancafeDiscountPolicy getInstance() {
        return FancafeDiscountPolicyHolder.instance;
    }

    @Override
    public long getDiscountAmt(long originAmt) {

        if (originAmt < discountAmt) {
            return originAmt;
        }

        return discountAmt;
    }
}