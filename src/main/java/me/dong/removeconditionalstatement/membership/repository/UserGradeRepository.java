package me.dong.removeconditionalstatement.membership.repository;

import me.dong.removeconditionalstatement.membership.code.PlatformCode;
import me.dong.removeconditionalstatement.membership.code.UserGradeCode;
import me.dong.removeconditionalstatement.membership.code.UserGradeTypeCode;
import me.dong.removeconditionalstatement.membership.domain.UserGrade;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserGradeRepository {

    public List<UserGrade> findUserGrade(PlatformCode platformCode, String userId) {
        return List.of(
                new UserGrade(userId, platformCode, UserGradeTypeCode.LOGIN, UserGradeCode.LV_01),
                new UserGrade(userId, platformCode, UserGradeTypeCode.SALES, UserGradeCode.LV_13),
                new UserGrade(userId, platformCode, UserGradeTypeCode.SUBSCRIPTION, UserGradeCode.LV_20)
        );
    }
}
