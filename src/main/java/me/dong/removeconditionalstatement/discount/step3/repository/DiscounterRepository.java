package me.dong.removeconditionalstatement.discount.step3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dong.removeconditionalstatement.discount.step3.AbstractDiscounter;

/**
 * 상속 관계 Entity에서 상속한 모든 Entity에 관한걸 사용할 수 있어서 좋을듯..?
 * AbstractDiscounter를 상속한 모든 Entity에 관한 Persistence 처리
 * <p>
 * Created by ethan.kim on 2018. 5. 13..
 */
@Repository
public interface DiscounterRepository<T extends AbstractDiscounter> extends JpaRepository<T, Long> {

    /**
     * 할인코드로 할인 조회
     */
    T findByCode(String code);
}
