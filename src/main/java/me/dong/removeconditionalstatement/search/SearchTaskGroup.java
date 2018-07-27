package me.dong.removeconditionalstatement.search;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by ethan.kim on 2018. 7. 27..
 */
@Configuration
@Slf4j
public class SearchTaskGroup {

    @Bean
    public SearchTask searchUser() {
        return new SearchTask() {
            @Override
            public String groupKey() {
                return "user";
            }

            @Override
            public void doSearch(Map<String, Object> params) {
                log.info("searchUser");
            }
        };
    }

    @Bean
    public SearchTask searchEvent() {
        return new SearchTask() {
            @Override
            public String groupKey() {
                return "event";
            }

            @Override
            public void doSearch(Map<String, Object> params) {
                log.info("searchEvent");
            }
        };
    }

    @Bean
    public SearchTask searchProduct() {
        return new SearchTask() {
            @Override
            public String groupKey() {
                return "product";
            }

            @Override
            public void doSearch(Map<String, Object> params) {
                log.info("searchProduct");
            }
        };
    }

    @Bean
    public SearchTask searchRecommandProduct() {
        return new SearchTask() {
            @Override
            public String groupKey() {
                return "product";
            }

            @Override
            public void doSearch(Map<String, Object> params) {
                log.info("searchRecommandProduct");
            }
        };
    }
}
