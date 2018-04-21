package me.dong.removeconditionalstatement.otp.func;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import lombok.extern.slf4j.Slf4j;
import me.dong.removeconditionalstatement.otp.OtpType;

/**
 * Created by ethan.kim on 2018. 4. 22..
 */
@Service
@Slf4j
public class OtpFuncService {

    private Map<OtpType, Consumer<Map<String, Object>>> otpTaskMap;

    public OtpFuncService() {
        this.otpTaskMap = new HashMap<>();
        otpTaskMap.put(OtpType.SIGN_UP, this::sendSignUpOtp);
        otpTaskMap.put(OtpType.SIGN_IN, this::sendSignInOtp);
        otpTaskMap.put(OtpType.PASSWORD_RESET, this::passwordResetOtp);
        otpTaskMap.put(OtpType.NONE, this::noneOtp);
    }

    public void sendOtp(OtpType otpType, Map<String, Object> params) {
        otpTaskMap.getOrDefault(otpType, otpTaskMap.get(OtpType.NONE))
                .accept(params);
    }

    private void sendSignUpOtp(Map<String, Object> params) {
        log.info("signUpOtp");
    }

    private void sendSignInOtp(Map<String, Object> params) {
        log.info("signInOtp");
    }

    private void passwordResetOtp(Map<String, Object> params) {
        log.info("passwordResetOtp");
    }

    private void noneOtp(Map<String, Object> params) {
        log.error("send otp mis matching type");
    }
}
