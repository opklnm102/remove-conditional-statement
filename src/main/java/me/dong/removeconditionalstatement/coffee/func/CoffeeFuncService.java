package me.dong.removeconditionalstatement.coffee.func;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by ethan.kim on 2018. 4. 22..
 */
@Service
@Slf4j
public class CoffeeFuncService {

    // 반환이 없으면 Consumer<T> 사용
    private List<Consumer<Map<String, Object>>> coffeeTasks;

    public CoffeeFuncService() {
        coffeeTasks = new ArrayList<>();
        coffeeTasks.add(this::makeOrder);
        coffeeTasks.add(this::checkOrder);
        coffeeTasks.add(this::issueReceipt);
        coffeeTasks.add(this::deliveryOrder);
        coffeeTasks.add(this::makeCoffee);
        coffeeTasks.add(this::deliveryCoffee);
    }

    public void buyCoffee(Map<String, Object> params) {
        coffeeTasks.forEach(task -> task.accept(params));
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
