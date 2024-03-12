package me.dong.removeconditionalstatement.membership.service;

import me.dong.removeconditionalstatement.membership.code.PlatformCode;
import me.dong.removeconditionalstatement.membership.code.UserGradeTypeCode;
import me.dong.removeconditionalstatement.membership.domain.UserGrade;
import me.dong.removeconditionalstatement.membership.repository.UserGradeRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class UserGradeService {

    private final UserGradeRepository userGradeRepository;

    public UserGradeService(UserGradeRepository userGradeRepository) {
        this.userGradeRepository = userGradeRepository;
    }

    public List<UserGrade> getUserGrades(PlatformCode platformCode, String userId) {
        var userGrades = userGradeRepository.findUserGrade(platformCode, userId);
        return platformCode.getUserGradeTypeCodes().stream()
                           .sorted(Comparator.comparing(UserGradeTypeCode::getOrder))
                           .map(userGradeTypeCode ->
                                   userGrades.stream()
                                             .filter(grade -> grade.getUserGradeType() == userGradeTypeCode)
                                             .findAny()
                                             .orElse(new UserGrade(userId, platformCode, userGradeTypeCode))
                           ).toList();
    }
}
