package me.dong.removeconditionalstatement.coffee.legacy;

import org.springframework.stereotype.Service;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by ethan.kim on 2018. 4. 22..
 */
@Service
@Slf4j
public class CoffeeLegacyService {

    public void buyCoffee(Map<String, Object> params) {
        makeOrder(params);
        checkOrder(params);
        issueReceipt(params);
        deliveryOrder(params);
        makeCoffee(params);
        deliveryCoffee(params);
    }

    private void makeOrder(Map<String, Object> params) {
        log.info("make Order");
    }

    private void checkOrder(Map<String, Object> params) {
        log.info("check Order");
    }

    private void issueReceipt(Map<String, Object> params) {
        log.info("issue Receipt");
    }

    private void deliveryOrder(Map<String, Object> params) {
        log.info("delivery Order");
    }

    private void makeCoffee(Map<String, Object> params) {
        log.info("make Coffee");
    }

    private void deliveryCoffee(Map<String, Object> params) {
        log.info("delivery Coffee");
    }
}
