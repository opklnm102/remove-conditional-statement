package me.dong.removeconditionalstatement.membership.code;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public enum PlatformCode {
    B2C(UserGradeTypeCode.LOGIN, UserGradeTypeCode.SALES),
    B2B(UserGradeTypeCode.SALES, UserGradeTypeCode.SUBSCRIPTION);

    private final List<UserGradeTypeCode> userGradeTypeCodes;

    PlatformCode(UserGradeTypeCode... codes) {
        this.userGradeTypeCodes = Arrays.asList(codes);
    }
}
