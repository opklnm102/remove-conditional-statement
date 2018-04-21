package me.dong.removeconditionalstatement.coffee.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by ethan.kim on 2018. 4. 22..
 */
@Configuration
@Slf4j
public class CoffeeTaskGroup {

    @Bean
    public CoffeeTask makeOrderTask() {
        return params -> log.info("make Order");
    }

    @Bean
    public CoffeeTask checkOrderTask() {
        return params -> log.info("check Order");
    }

    @Bean
    public CoffeeTask issueReceiptTask() {
        return params -> log.info("issue Receipt");
    }

    @Bean
    public CoffeeTask deliveryOrderTask() {
        return params -> log.info("delivery Order");
    }

    @Bean
    public CoffeeTask makeCoffeeTask() {
        return params -> log.info("make Coffee");
    }

    @Bean
    public CoffeeTask deliveryCoffeeTask() {
        return new CoffeeTask() {
            @Override
            public void doTask(Map<String, Object> params) {
                log.info("delivery Coffee");
            }
        };
    }
}
