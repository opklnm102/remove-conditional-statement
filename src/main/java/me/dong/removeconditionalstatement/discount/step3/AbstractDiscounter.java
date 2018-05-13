package me.dong.removeconditionalstatement.discount.step3;

import lombok.Data;
import me.dong.removeconditionalstatement.discount.step2.Discountable;

/**
 * Created by ethan.kim on 2018. 5. 13..
 */
@Data
//@Entity
//    @Inheritance
public abstract class AbstractDiscounter implements Discountable {

//    @Id
//    @GeneratedValue
//    @Column
    private long id;

    // 할인코드
//    @Column
    private String code;

    // 할인명
//    @Column
    private String name;
}