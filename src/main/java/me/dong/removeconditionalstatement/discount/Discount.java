package me.dong.removeconditionalstatement.discount;

import lombok.Value;

/**
 * 할인VO
 * Created by ethan.kim on 2018. 5. 13..
 */
@Value(staticConstructor = "of")
public class Discount {

    // 할인금액
    private long discountAmt;
}
