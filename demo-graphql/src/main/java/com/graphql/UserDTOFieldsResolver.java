package com.graphql;

import com.graphql.dto.Article;
import com.graphql.dto.UserDTO;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserDTOFieldsResolver implements GraphQLResolver<UserDTO> {

    public static Map<Integer, Article> articleMap = new HashMap<>();

    static {
        articleMap.put(1, new Article(1, "百年孤独"));
        articleMap.put(2, new Article(2, "钢铁是怎样练成的"));
        articleMap.put(3, new Article(3, "十万个为什么"));
        articleMap.put(4, new Article(4, "格林童话"));
        articleMap.put(5, new Article(5, "缠论"));
        articleMap.put(6, new Article(6, "高等数学"));
    }

    /**
     * 必须是get+属性名的格式
     * 后端的工作量确实增大好多
     */
    public List<Article> getArticles(UserDTO userDTO) throws Exception {
        log.info("getArticles,userId:{}", userDTO.getId());
        Thread.sleep(5000);
        if (CollectionUtils.isEmpty(userDTO.getArticleIds())) {
            return new ArrayList<>();
        }
        return userDTO.getArticleIds().stream().map(x -> articleMap.get(x)).collect(Collectors.toList());
    }
}
