package me.dong.removeconditionalstatement.discount.step2.step2_2;

import me.dong.removeconditionalstatement.discount.step2.Discountable;

/**
 * Created by ethan.kim on 2018. 5. 13..
 */
public interface DiscounterFactory {
    Discountable getDiscounter(String discountName);
}
