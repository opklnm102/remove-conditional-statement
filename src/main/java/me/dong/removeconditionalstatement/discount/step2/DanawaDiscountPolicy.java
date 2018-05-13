package me.dong.removeconditionalstatement.discount.step2;

/**
 * Created by ethan.kim on 2018. 5. 13..
 */
public class DanawaDiscountPolicy implements Discountable {

    @Override
    public long getDiscountAmt(long originAmt) {
        return (long) (originAmt * 0.15);
    }
}
