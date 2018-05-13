package me.dong.removeconditionalstatement.discount.step2.step_enum;

import lombok.extern.slf4j.Slf4j;
import me.dong.removeconditionalstatement.discount.step2.Discountable;

/**
 * Created by ethan.kim on 2018. 5. 13..
 */
@Slf4j
public enum DiscountPolicy implements Discountable {
    // 네이버 할인
    NAVER(10, 0L) {
        @Override
        public long getDiscountAmt(long originAmt) {
            return originAmt * this.discountRate / 100;
        }
    },
    // 다나와 할인
    DANAWA(15, 0L) {
        @Override
        public long getDiscountAmt(long originAmt) {
            return originAmt * this.discountRate / 100;
        }
    },
    // 팬카페 할인
    FANCAFE(0, 1000L) {
        @Override
        public long getDiscountAmt(long originAmt) {
            if (originAmt < this.discountAmt) {
                return originAmt;
            }
            return this.discountAmt;
        }
    };

    final int discountRate;

    final long discountAmt;

    DiscountPolicy(int discountRate, long discountAmt) {
        this.discountRate = discountRate;
        this.discountAmt = discountAmt;
    }

    // TODO: 2018. 5. 13. try-catch문을 제거해보자
    public static Discountable getDiscounter(String discountCode) {
        if (discountCode == null) {
            return Discountable.NONE;
        }
        try {
            return DiscountPolicy.valueOf(discountCode);
        } catch (IllegalArgumentException e) {
            log.warn("Not found discountCode : {}", discountCode);
            return Discountable.NONE;
        }
    }
}
