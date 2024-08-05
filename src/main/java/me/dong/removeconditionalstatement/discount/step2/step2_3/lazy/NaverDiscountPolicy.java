package me.dong.removeconditionalstatement.discount.step2.step2_3.lazy;

import me.dong.removeconditionalstatement.discount.step2.Discountable;

/**
 * Created by ethan.kim on 2018. 5. 13..
 */
public class NaverDiscountPolicy implements Discountable {

    private static class NaverDiscountPolicyHolder {

        public static NaverDiscountPolicy instance = new NaverDiscountPolicy();
    }

    public static NaverDiscountPolicy getInstance() {
        return NaverDiscountPolicyHolder.instance;
    }

    @Override
    public long getDiscountAmt(long originAmt) {
        return (long) (originAmt * 0.1);
    }
}
