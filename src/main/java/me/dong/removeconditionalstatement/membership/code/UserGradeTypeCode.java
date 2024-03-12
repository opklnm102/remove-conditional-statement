package me.dong.removeconditionalstatement.membership.code;

import lombok.Getter;

@Getter
public enum UserGradeTypeCode {
    LOGIN(1, UserGradeCode.LV_00),
    SALES(2, UserGradeCode.LV_10),
    SUBSCRIPTION(3, UserGradeCode.LV_20);

    private final int order;
    private final UserGradeCode defaultUserGrade;

    UserGradeTypeCode(int order, UserGradeCode defaultUserGrade) {
        this.order = order;
        this.defaultUserGrade = defaultUserGrade;
    }
}
