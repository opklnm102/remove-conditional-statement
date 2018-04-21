package me.dong.removeconditionalstatement.otp.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import me.dong.removeconditionalstatement.otp.OtpType;

/**
 * Created by ethan.kim on 2018. 4. 22..
 */
@Configuration
@Slf4j
public class OtpTaskGroup {

    @Bean
    public OtpTask signUpOtpTask() {
        return new OtpTask() {
            @Override
            public OtpType getType() {
                return OtpType.SIGN_UP;
            }

            @Override
            public boolean task(Map<String, Object> params) {
                log.info("otpTask : {}", getType());
                return true;
            }
        };
    }

    @Bean
    public OtpTask signInOtpTask() {
        return new OtpTask() {
            @Override
            public OtpType getType() {
                return OtpType.SIGN_IN;
            }

            @Override
            public boolean task(Map<String, Object> params) {
                log.info("otpTask : {}", getType());
                return true;
            }
        };
    }

    @Bean
    public OtpTask passwordResetOtpTask() {
        return new OtpTask() {
            @Override
            public OtpType getType() {
                return OtpType.PASSWORD_RESET;
            }

            @Override
            public boolean task(Map<String, Object> params) {
                log.info("otpTask : {}", getType());
                return true;
            }
        };
    }

    @Bean
    public OtpTask noneOtpTask() {
        return new OtpTask() {
            @Override
            public OtpType getType() {
                return OtpType.NONE;
            }

            @Override
            public boolean task(Map<String, Object> params) {
                log.error("otpTask : {}", getType());
                return true;
            }
        };
    }
}
