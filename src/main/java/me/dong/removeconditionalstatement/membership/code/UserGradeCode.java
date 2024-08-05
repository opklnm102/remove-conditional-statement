package me.dong.removeconditionalstatement.membership.code;

import lombok.Getter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static me.dong.removeconditionalstatement.membership.code.UserGradeTypeCode.*;

@Getter
// TODO: UserGradeCode를 여러 UserGradeTypeCode에서 사용할 수 있도록 수정
public enum UserGradeCode {
    LV_00(LOGIN, 1, "뉴비"),
    LV_01(LOGIN, 2, "베테랑"),

    LV_10(SALES, 1, "Bronze"),
    LV_11(SALES, 2, "Silver"),
    LV_12(SALES, 3, "Gold"),
    LV_13(SALES, 4, "Platinum"),

    LV_20(SUBSCRIPTION, 1, "Diamond"),
    LV_21(SUBSCRIPTION, 2, "Black Diamond");

    private final UserGradeTypeCode userGradeType;
    private final int weight;
    private final String displayName;

    UserGradeCode(UserGradeTypeCode userGradeType, int weight, String displayName) {
        this.userGradeType = userGradeType;
        this.weight = weight;
        this.displayName = displayName;
    }

    private static final Map<UserGradeTypeCode, UserGradeCode> DEFAULT_GRADES;

    static {
        DEFAULT_GRADES = Arrays.stream(UserGradeTypeCode.values())
                               .collect(Collectors.toUnmodifiableMap(
                                       e -> e,
                                       e -> Arrays.stream(UserGradeCode.values())
                                                  .filter(grade -> grade.userGradeType == e)
                                                  .min(Comparator.comparingInt(UserGradeCode::getWeight))
                                                  .orElseThrow(() -> new IllegalArgumentException("Not found default user grade " + e))));
    }

    public static UserGradeCode getDefaultUserGrade(UserGradeTypeCode userGradeType) {
        return DEFAULT_GRADES.get(userGradeType);
    }

    public Optional<UserGradeCode> next() {
        return Arrays.stream(UserGradeCode.values())
                     .filter(grade -> grade.userGradeType == this.userGradeType)
                     .filter(grade -> grade.weight == this.weight + 1)
                     .findAny();
    }

    public boolean isHighest() {
        return this.next().isEmpty();
    }

    public boolean isHigherThen(UserGradeCode targetGrade) {
        return this.weight > targetGrade.weight;
    }

    public boolean isLowest() {
        return Arrays.stream(UserGradeCode.values())
                     .filter(grade -> grade.userGradeType == this.userGradeType)
                     .noneMatch(this::isHigherThen);
    }
}
