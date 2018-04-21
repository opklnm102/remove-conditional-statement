package me.dong.removeconditionalstatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import me.dong.removeconditionalstatement.coffee.bean.CoffeeBeanService;
import me.dong.removeconditionalstatement.coffee.func.CoffeeFuncService;
import me.dong.removeconditionalstatement.coffee.legacy.CoffeeLegacyService;
import me.dong.removeconditionalstatement.otp.OtpType;
import me.dong.removeconditionalstatement.otp.bean.OtpBeanService;
import me.dong.removeconditionalstatement.otp.func.OtpFuncService;
import me.dong.removeconditionalstatement.otp.legacy.OtpLegacyService;

@SpringBootApplication
@Slf4j
public class RemoveConditionalStatementApplication {

    @Autowired
    private CoffeeBeanService coffeeBeanService;

    @Autowired
    private CoffeeLegacyService coffeeLegacyService;

    @Autowired
    private CoffeeFuncService coffeeFuncService;

    @Autowired
    private OtpLegacyService otpLegacyService;

    @Autowired
    private OtpBeanService otpBeanService;

    @Autowired
    private OtpFuncService otpFuncService;

    public static void main(String[] args) {
        SpringApplication.run(RemoveConditionalStatementApplication.class, args);
    }

    @EventListener(value = ApplicationReadyEvent.class)
    public void listenReadyEvent() {
        Map<String, Object> params = new HashMap<>();

        log.info("--- buy Coffee Legacy ---");
        coffeeLegacyService.buyCoffee(params);

        log.info("--- buy Coffee Bean ---");
        coffeeBeanService.buyCoffee(params);

        log.info("--- buy Coffee Func ---");
        coffeeFuncService.buyCoffee(params);

        for (OtpType otpType : OtpType.values()) {
            log.info("--- send OTP {} ---", otpType);
            otpLegacyService.sendOtp(otpType, params);
            otpBeanService.sendOtp(otpType, params);
            otpFuncService.sendOtp(otpType, params);
        }
    }
}
