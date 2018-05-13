package me.dong.removeconditionalstatement.discount.step2.step2_3.lazy;

import org.hibernate.validator.internal.util.stereotypes.ThreadSafe;

import me.dong.removeconditionalstatement.discount.step2.Discountable;

/**
 * Created by ethan.kim on 2018. 5. 13..
 */
public class DanawaDiscountPolicy implements Discountable {

    private static class DanawaDiscountPolicyHolder {

        @ThreadSafe
        public static DanawaDiscountPolicy instance = new DanawaDiscountPolicy();
    }

    public static DanawaDiscountPolicy getInstance() {
        return DanawaDiscountPolicyHolder.instance;
    }

    @Override
    public long getDiscountAmt(long originAmt) {
        return (long) (originAmt * 0.15);
    }
}
