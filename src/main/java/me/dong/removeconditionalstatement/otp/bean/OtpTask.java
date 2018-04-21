package me.dong.removeconditionalstatement.otp.bean;

import java.util.Map;

import me.dong.removeconditionalstatement.otp.OtpType;

/**
 * Created by ethan.kim on 2018. 4. 22..
 */
public interface OtpTask {

    OtpType getType();

    void task(Map<String, Object> params);
}
