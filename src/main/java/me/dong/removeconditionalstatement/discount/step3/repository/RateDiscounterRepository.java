package me.dong.removeconditionalstatement.discount.step3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dong.removeconditionalstatement.discount.step3.RateDiscounter;

/**
 * JapRepository에서 상속 관계 Entity에서 특정 Entity만 사용할 때 쓰면 좋을듯
 *
 * Created by ethan.kim on 2018. 5. 13..
 */
public interface RateDiscounterRepository extends JpaRepository<RateDiscounter, Long> {

    /**
     * 할인코드로 할인 조회
     */
    RateDiscounter findByCode(String code);
}
