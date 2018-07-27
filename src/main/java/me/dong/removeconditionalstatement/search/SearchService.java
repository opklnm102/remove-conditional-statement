package me.dong.removeconditionalstatement.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * 순서에 상관없는 작업들로 구성하면 병렬로 실행할 수 있다
 * <p>
 * Created by ethan.kim on 2018. 7. 27..
 */
@Service
@Slf4j
public class SearchService {

    // interface로 DI하고 gropuKey로 필요한 task를 분류하여 실행
    // 순서에 상관없는 작업들로 구성되어 있기 때문에 가능
    @Autowired
    private List<SearchTask> searchTasks;

    public void search(String groupKey, Map<String, Object> params) {
        searchTasks.parallelStream()
                .filter(searchTask -> searchTask.groupKey().equals(groupKey))
                .forEach(task -> task.doSearch(params));
    }
}
