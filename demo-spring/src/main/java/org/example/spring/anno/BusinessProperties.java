package org.example.spring.anno;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "business", ignoreUnknownFields = true)
@Getter
@Setter
public class BusinessProperties {

    private Integer type;


}
