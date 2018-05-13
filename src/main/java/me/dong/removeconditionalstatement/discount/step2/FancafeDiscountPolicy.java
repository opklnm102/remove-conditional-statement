package me.dong.removeconditionalstatement.discount.step2;

/**
 * Created by ethan.kim on 2018. 5. 13..
 */
public class FancafeDiscountPolicy implements Discountable {

    private long discountAmt = 1000L;

    @Override
    public long getDiscountAmt(long originAmt) {

        if (originAmt < discountAmt) {
            return originAmt;
        }

        return discountAmt;
    }
}