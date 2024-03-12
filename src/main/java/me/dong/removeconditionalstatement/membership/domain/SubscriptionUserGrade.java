package me.dong.removeconditionalstatement.membership.domain;

import lombok.Getter;
import me.dong.removeconditionalstatement.membership.code.UserGradeCode;

import java.util.Comparator;
import java.util.List;

@Getter
public class SubscriptionUserGrade {
    private static final List<SubscriptionUserGrade> SUBSCRIPTION_USER_GRADES = List.of(
            new SubscriptionUserGrade(UserGradeCode.LV_20, false),
            new SubscriptionUserGrade(UserGradeCode.LV_21, true));

    private final UserGradeCode userGrade;
    private final boolean enabled;

    public SubscriptionUserGrade(UserGradeCode userGrade, boolean enabled) {
        this.userGrade = userGrade;
        this.enabled = enabled;
    }

    public static SubscriptionUserGrade getSubscriptionUserGrade(UserGradeCode userGrade) {
        return SUBSCRIPTION_USER_GRADES.stream()
                                       .filter(grade -> grade.getUserGrade() == userGrade)
                                       .findAny()
                                       .orElseThrow(() -> new IllegalArgumentException("not supported " + userGrade));
    }

    /**
     * 업그레이드 가능한 예상 등급
     *
     * @param enabled 구독 활성화 여부
     * @return UserGrade
     */
    public static UserGradeCode getExpectedUserGrade(boolean enabled) {
        return SUBSCRIPTION_USER_GRADES.stream()
                                       .filter(grade -> enabled == grade.enabled)
                                       .map(SubscriptionUserGrade::getUserGrade)
                                       .max(Comparator.comparing(UserGradeCode::getWeight))
                                       .orElse(SUBSCRIPTION_USER_GRADES.getFirst().getUserGrade());
    }
}
