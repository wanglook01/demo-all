package com.wanglook01.strategy.v1;

import lombok.Data;

import java.util.List;

@Data
public class StrategyV1DTO {
    private Integer date;
    private Integer forecastNumCount;
    private List<Integer> forecastNumList;
    private Integer hitCount;

    private Integer ge2Interval;
}
