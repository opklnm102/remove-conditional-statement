package me.dong.removeconditionalstatement.discount.step3;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 할인률
 * <p>
 * Created by ethan.kim on 2018. 5. 13..
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("RATE")
public class RateDiscounter extends AbstractDiscounter {

    @Column
    private int rate;

    @Override
    public long getDiscountAmt(long originAmt) {
        return originAmt * rate / 100;
    }
}
