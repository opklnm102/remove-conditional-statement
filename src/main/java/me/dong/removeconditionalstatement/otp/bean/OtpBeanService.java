package me.dong.removeconditionalstatement.otp.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import me.dong.removeconditionalstatement.otp.OtpType;

/**
 * Created by ethan.kim on 2018. 4. 22..
 */
@Service
public class OtpBeanService implements InitializingBean {

    @Autowired
    private List<OtpTask> otpTasks;

    private Map<OtpType, OtpTask> otpTaskMap;

    @Override
    public void afterPropertiesSet() throws Exception {
        otpTaskMap = otpTasks.stream()
//                .collect(Collectors.toMap(OtpTask::getType, otpTask -> otpTask));
                .collect(Collectors.toMap(OtpTask::getType, Function.identity()));
    }

    public void sendOtp(OtpType otpType, Map<String, Object> params) {
        otpTaskMap.getOrDefault(otpType, otpTaskMap.get(OtpType.NONE))
                .task(params);
    }
}
