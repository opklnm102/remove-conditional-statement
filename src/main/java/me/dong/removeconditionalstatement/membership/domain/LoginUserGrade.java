package me.dong.removeconditionalstatement.membership.domain;

import lombok.Getter;
import me.dong.removeconditionalstatement.membership.code.UserGradeCode;

import java.util.Comparator;
import java.util.List;

@Getter
public class LoginUserGrade {
    private static final List<LoginUserGrade> LOGIN_USER_GRADES = List.of(
            new LoginUserGrade(UserGradeCode.LV_00, 0L),
            new LoginUserGrade(UserGradeCode.LV_01, 5L));

    private final UserGradeCode userGrade;
    private final long targetLoginCount;

    public LoginUserGrade(UserGradeCode userGrade, long targetLoginCount) {
        this.userGrade = userGrade;
        this.targetLoginCount = targetLoginCount;
    }

    public static LoginUserGrade getLoginUserGrade(UserGradeCode userGrade) {
        return LOGIN_USER_GRADES.stream()
                                .filter(grade -> grade.getUserGrade() == userGrade)
                                .findAny()
                                .orElseThrow(() -> new IllegalArgumentException("not supported " + userGrade));
    }

    /**
     * 업그레이드 가능한 예상 등급
     *
     * @param count 현재 로그인 수
     * @return UserGrade
     */
    public static UserGradeCode getExpectedUserGrade(long count) {
        return LOGIN_USER_GRADES.stream()
                                .filter(grade -> count >= grade.targetLoginCount)
                                .map(LoginUserGrade::getUserGrade)
                                .max(Comparator.comparing(UserGradeCode::getWeight))
                                .orElse(LOGIN_USER_GRADES.getFirst().getUserGrade());
    }
}
