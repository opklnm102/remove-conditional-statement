package me.dong.removeconditionalstatement.otp.legacy;

import org.springframework.stereotype.Service;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import me.dong.removeconditionalstatement.otp.OtpType;

/**
 * 특정 상황에 맞는 작업을 해야할 경우
 * if, switch 사용
 * <p>
 * Created by ethan.kim on 2018. 4. 22..
 */
@Service
@Slf4j
public class OtpLegacyService {

    public void sendOtp(OtpType otpType, Map<String, Object> params) {
        switch (otpType) {
            case SIGN_IN:
                sendSignInOtp(params);
                break;
            case SIGN_UP:
                sendSignUpOtp(params);
                break;
            case PASSWORD_RESET:
                passwordResetOtp(params);
                break;
            default:
                log.error("send otp mis matching type");
        }
    }

    private boolean sendSignUpOtp(Map<String, Object> params) {
        log.info("signUpOtp");
        return true;
    }

    private boolean sendSignInOtp(Map<String, Object> params) {
        log.info("signInOtp");
        return true;
    }

    private boolean passwordResetOtp(Map<String, Object> params) {
        log.info("passwordResetOtp");
        return true;
    }
}
