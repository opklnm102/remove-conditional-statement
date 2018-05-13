package me.dong.removeconditionalstatement.discount.step3;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 금액 할인
 * <p>
 * Created by ethan.kim on 2018. 5. 13..
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("AMT")
public class AmtDiscounter extends AbstractDiscounter {

    @Column
    private long amt;

    @Override
    public long getDiscountAmt(long originAmt) {
        if(originAmt < amt) {
            return originAmt;
        }
        return amt;
    }
}
