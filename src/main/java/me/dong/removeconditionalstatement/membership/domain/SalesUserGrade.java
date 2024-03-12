package me.dong.removeconditionalstatement.membership.domain;

import lombok.Getter;
import me.dong.removeconditionalstatement.membership.code.UserGradeCode;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

@Getter
public class SalesUserGrade {
    private static final List<SalesUserGrade> SALES_USER_GRADES = List.of(
            new SalesUserGrade(UserGradeCode.LV_10, 0L, BigDecimal.valueOf(0L)),
            new SalesUserGrade(UserGradeCode.LV_11, 5L, BigDecimal.valueOf(100_000L)),
            new SalesUserGrade(UserGradeCode.LV_12, 10L, BigDecimal.valueOf(500_000L)),
            new SalesUserGrade(UserGradeCode.LV_13, 20L, BigDecimal.valueOf(1_000_000L)));

    private final UserGradeCode userGrade;
    private final long targetSalesCount;
    private final BigDecimal targetSalesAmount;

    public SalesUserGrade(UserGradeCode userGrade, long targetSalesCount, BigDecimal targetSalesAmount) {
        this.userGrade = userGrade;
        this.targetSalesCount = targetSalesCount;
        this.targetSalesAmount = targetSalesAmount;
    }

    public static SalesUserGrade getSalesUserGrade(UserGradeCode userGrade) {
        return SALES_USER_GRADES.stream()
                                .filter(grade -> grade.getUserGrade() == userGrade)
                                .findAny()
                                .orElseThrow(() -> new IllegalArgumentException("not supported " + userGrade));
    }

    /**
     * 업그레이드 가능한 예상 등급
     *
     * @param count  현재 실적 수
     * @param amount 현재 실적 금액
     * @return UserGrade
     */
    public static UserGradeCode getExpectedUserGrade(long count, BigDecimal amount) {
        return SALES_USER_GRADES.stream()
                                .filter(grade -> count >= grade.targetSalesCount || amount.compareTo(grade.targetSalesAmount) >= 0)
                                .map(SalesUserGrade::getUserGrade)
                                .max(Comparator.comparing(UserGradeCode::getWeight))
                                .orElse(SALES_USER_GRADES.getFirst().getUserGrade());
    }
}
