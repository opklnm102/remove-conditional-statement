package me.dong.removeconditionalstatement.membership.domain;

import lombok.Getter;
import me.dong.removeconditionalstatement.membership.code.PlatformCode;
import me.dong.removeconditionalstatement.membership.code.UserGradeCode;
import me.dong.removeconditionalstatement.membership.code.UserGradeTypeCode;

@Getter
public class UserGrade {
    private final String userId;
    private final PlatformCode platformCode;
    private final UserGradeTypeCode userGradeType;
    private final UserGradeCode userGrade;

    public UserGrade(String userId, PlatformCode platformCode, UserGradeTypeCode userGradeType, UserGradeCode userGrade) {
        this.userId = userId;
        this.platformCode = platformCode;
        this.userGradeType = userGradeType;
        this.userGrade = userGrade;
    }

    public UserGrade(String userId, PlatformCode platformCode, UserGradeTypeCode userGradeType) {
        this.userId = userId;
        this.platformCode = platformCode;
        this.userGradeType = userGradeType;
        this.userGrade = userGradeType.getDefaultUserGrade();
    }
}
