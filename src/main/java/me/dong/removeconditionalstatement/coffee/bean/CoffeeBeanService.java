package me.dong.removeconditionalstatement.coffee.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * cafe에서 커피를 주문한다고 생각했을 때 커피를 받기 까지의 과정을 task로 분류
 * 커피 주문
 * 주문 확인
 * 영수증 발급
 * 주문 전달
 * 커피 제조
 * 커피 전달
 * <p>
 * Created by ethan.kim on 2018. 4. 22..
 */
@Service
@Slf4j
public class CoffeeBeanService {

    @Autowired
    private CoffeeTask makeOrderTask;

    @Autowired
    private CoffeeTask checkOrderTask;

    @Autowired
    private CoffeeTask issueReceiptTask;

    @Autowired
    private CoffeeTask deliveryOrderTask;

    @Autowired
    private CoffeeTask makeCoffeeTask;

    @Autowired
    private CoffeeTask deliveryCoffeeTask;

    private List<CoffeeTask> coffeeTasks;

    @PostConstruct
    public void setUp() {
        coffeeTasks = new ArrayList<>();
        coffeeTasks.add(makeOrderTask);
        coffeeTasks.add(checkOrderTask);
        coffeeTasks.add(issueReceiptTask);
        coffeeTasks.add(deliveryOrderTask);
        coffeeTasks.add(makeCoffeeTask);
        coffeeTasks.add(deliveryCoffeeTask);
    }

    // or use constructor injection
    // List<CoffeeTask> coffeeTasks -> CoffeeTask...
    // Map<String, CoffeeTask> coffeeTasks -> <CoffeeTask bean name, CoffeeTask bean>
//    public CoffeeBeanService(List<CoffeeTask> coffeeTasks) {
//        this.coffeeTasks = coffeeTasks;
//    }

    public void buyCoffee(Map<String, Object> params) {
        coffeeTasks.forEach(coffeeTask -> coffeeTask.doTask(params));
    }
}
