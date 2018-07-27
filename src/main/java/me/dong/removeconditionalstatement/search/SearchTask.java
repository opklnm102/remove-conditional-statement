package me.dong.removeconditionalstatement.search;

import java.util.Map;

/**
 * Created by ethan.kim on 2018. 7. 27..
 */
public interface SearchTask {

    String groupKey();

    void doSearch(Map<String, Object> params);
}
