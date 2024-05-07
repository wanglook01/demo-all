package org.example.spring.anno;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component
@PropertySource(value = {"classpath:search.properties"})
@ConfigurationProperties(prefix = "search", ignoreUnknownFields = true)
@Getter
@Setter
@ToString
public class SearchProperties {

    private Integer type;

    private String search_url;

    private String tag_url;


}
