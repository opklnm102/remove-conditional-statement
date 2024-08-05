package me.dong.removeconditionalstatement.membership.code;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserGradeCodeTest {

    @Nested
    @DisplayName("default user grade 조회")
    class GetDefaultUserGrade {

        static Stream<Arguments> provideGrade() {
            return Stream.of(
                    Arguments.of(UserGradeTypeCode.LOGIN, UserGradeCode.LV_00),
                    Arguments.of(UserGradeTypeCode.SALES, UserGradeCode.LV_10),
                    Arguments.of(UserGradeTypeCode.SUBSCRIPTION, UserGradeCode.LV_20)
            );
        }

        @DisplayName("userGradeType 별로 default user grade 조회")
        @ParameterizedTest
        @MethodSource("provideGrade")
        void getDefaultUserGrade(UserGradeTypeCode userGradeType, UserGradeCode userGrade) {
            // given

            // when
            var result = UserGradeCode.getDefaultUserGrade(userGradeType);

            // then
            assertThat(result).isEqualTo(userGrade);
        }
    }

    @Nested
    @DisplayName("next grade 조회")
    class Next {

        static Stream<Arguments> provideExistNextGrade() {
            return Stream.of(
                    Arguments.of(UserGradeCode.LV_00, UserGradeCode.LV_01),
                    Arguments.of(UserGradeCode.LV_10, UserGradeCode.LV_11),
                    Arguments.of(UserGradeCode.LV_11, UserGradeCode.LV_12),
                    Arguments.of(UserGradeCode.LV_12, UserGradeCode.LV_13),
                    Arguments.of(UserGradeCode.LV_20, UserGradeCode.LV_21)
            );
        }

        static Stream<Arguments> provideNotExistNextGrade() {
            return Stream.of(
                    Arguments.of(UserGradeCode.LV_01),
                    Arguments.of(UserGradeCode.LV_13),
                    Arguments.of(UserGradeCode.LV_21)
            );
        }

        @DisplayName("next grade가 존재하는 grade")
        @ParameterizedTest
        @MethodSource("provideExistNextGrade")
        void exist_next_grade(UserGradeCode userGrade, UserGradeCode nextGrade) {
            // given

            // when
            var result = userGrade.next();

            // then
            assertThat(result.get()).isEqualTo(nextGrade);
        }

        @DisplayName("next grade가 존재하지 않은 grade")
        @ParameterizedTest
        @MethodSource("provideNotExistNextGrade")
        void not_exist_next_grade(UserGradeCode userGrade) {
            // given

            // when
            var result = userGrade.next();

            // then
            assertThat(result.isEmpty()).isTrue();
        }
    }

    @Nested
    @DisplayName("최고 등급 여부 조회")
    class IsHighest {

        static Stream<Arguments> provideGrade() {
            return Stream.of(
                    Arguments.of(UserGradeCode.LV_00, false),
                    Arguments.of(UserGradeCode.LV_01, true),
                    Arguments.of(UserGradeCode.LV_10, false),
                    Arguments.of(UserGradeCode.LV_11, false),
                    Arguments.of(UserGradeCode.LV_12, false),
                    Arguments.of(UserGradeCode.LV_13, true),
                    Arguments.of(UserGradeCode.LV_20, false),
                    Arguments.of(UserGradeCode.LV_21, true)
            );
        }

        @DisplayName("최고 등급이면 true, 아니면 false")
        @ParameterizedTest
        @MethodSource("provideGrade")
        void is_highest_true_not_highest_false(UserGradeCode userGrade, boolean expected) {
            // given

            // when
            var result = userGrade.isHighest();

            // then
            assertThat(result).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("주어진 grade보다 높은지 조회")
    class IsHigherThen {

        static Stream<Arguments> provideGrade() {
            return Stream.of(
                    Arguments.of(UserGradeCode.LV_00, UserGradeCode.LV_01, false),
                    Arguments.of(UserGradeCode.LV_01, UserGradeCode.LV_00, true),
                    Arguments.of(UserGradeCode.LV_10, UserGradeCode.LV_11, false),
                    Arguments.of(UserGradeCode.LV_11, UserGradeCode.LV_12, false),
                    Arguments.of(UserGradeCode.LV_12, UserGradeCode.LV_13, false),
                    Arguments.of(UserGradeCode.LV_13, UserGradeCode.LV_12, true),
                    Arguments.of(UserGradeCode.LV_12, UserGradeCode.LV_11, true),
                    Arguments.of(UserGradeCode.LV_11, UserGradeCode.LV_10, true),
                    Arguments.of(UserGradeCode.LV_10, UserGradeCode.LV_10, false),
                    Arguments.of(UserGradeCode.LV_20, UserGradeCode.LV_21, false),
                    Arguments.of(UserGradeCode.LV_21, UserGradeCode.LV_20, true)
            );
        }

        @DisplayName("주어진 grade보다 높은지 조회")
        @ParameterizedTest
        @MethodSource("provideGrade")
        void isHigherThen(UserGradeCode userGrade, UserGradeCode targetGrade, boolean expected) {
            // given

            // when
            var result = userGrade.isHigherThen(targetGrade);

            // then
            assertThat(result).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("최저 등급 여부 조회")
    class IsLowest {

        static Stream<Arguments> provideGrade() {
            return Stream.of(
                    Arguments.of(UserGradeCode.LV_00, true),
                    Arguments.of(UserGradeCode.LV_01, false),
                    Arguments.of(UserGradeCode.LV_10, true),
                    Arguments.of(UserGradeCode.LV_11, false),
                    Arguments.of(UserGradeCode.LV_12, false),
                    Arguments.of(UserGradeCode.LV_13, false),
                    Arguments.of(UserGradeCode.LV_20, true),
                    Arguments.of(UserGradeCode.LV_21, false)
            );
        }

        @DisplayName("최저 등급이면 true, 최저 등급이 아니면 false")
        @ParameterizedTest
        @MethodSource("provideGrade")
        void is_lowest_true_not_lowest_false(UserGradeCode userGrade, boolean expected) {
            // given

            // when
            var result = userGrade.isLowest();

            // then
            assertThat(result).isEqualTo(expected);
        }
    }
}
