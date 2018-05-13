package me.dong.removeconditionalstatement.discount.step3.repository;

import org.springframework.stereotype.Repository;

import me.dong.removeconditionalstatement.discount.step3.AbstractDiscounter;

/**
 * JapRepository에서 메소드마다 다른 Sub Entity를 반환할 때 쓰면 좋을듯
 * <p>
 * Created by ethan.kim on 2018. 5. 13..
 */
@Repository
public interface GenericMethodDiscounterRepository extends JpaRepository<AbstractDiscounter, Long> {

    /**
     * 할인코드로 할인 조회
     */
    <T extends AbstractDiscounter> T findByCode(String code);
}
