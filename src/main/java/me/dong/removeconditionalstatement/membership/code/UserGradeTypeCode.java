package me.dong.removeconditionalstatement.membership.code;

import lombok.Getter;

@Getter
public enum UserGradeTypeCode {
    LOGIN(1),
    SALES(2),
    SUBSCRIPTION(3);

    private final int order;

    UserGradeTypeCode(int order) {
        this.order = order;
    }
}
