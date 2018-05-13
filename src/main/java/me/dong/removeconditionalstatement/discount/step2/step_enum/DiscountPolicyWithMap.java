package me.dong.removeconditionalstatement.discount.step2.step_enum;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import me.dong.removeconditionalstatement.discount.step2.Discountable;

/**
 * Created by ethan.kim on 2018. 5. 13..
 */
public enum DiscountPolicyWithMap implements Discountable {
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

    private static Map<String, Discountable> lookup;

    static {
        lookup = Arrays.stream(DiscountPolicyWithMap.values())
                .collect(Collectors.toMap(Enum::name, Function.identity()));
    }

    final int discountRate;

    final long discountAmt;

    DiscountPolicyWithMap(int discountRate, long discountAmt) {
        this.discountRate = discountRate;
        this.discountAmt = discountAmt;
    }

    // DiscountPolicy의 try-catch 제거
    public static Discountable getDiscounter(String discountCode) {
        return lookup.getOrDefault(discountCode, Discountable.NONE);
    }
}
