package com.wanglook01.strategy.v1;

import com.google.common.collect.Lists;
import com.wanglook01.dto.D3Data;
import com.wanglook01.service.D3DataService;
import com.wanglook01.util.DateUtil;
import com.wanglook01.util.ExcelUtil;
import com.wanglook01.util.MathUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class StrategyV1 {

    /**
     * 通过前2期的数据，加减和0运算能不能找到这一期的2个数据，最少要求就是得到本期的2个数据
     * 计算一下得到的概率
     */
    public static void main(String[] args) {
        List<D3Data> dataList = D3DataService.get();
        List<Integer> dateList = dataList.stream().map(D3Data::getDate).collect(Collectors.toList());
        //格式：日期-经过计算得到的可能的数字的个数-命中中奖的数字的个数
        List<StrategyV1DTO> dtoList = new ArrayList<>();
        //从2开始
        for (int i = 2; i < dateList.size(); i++) {
            Integer date = dateList.get(i);
            D3Data cur = dataList.stream().filter(x -> x.getDate().equals(date)).findFirst().orElse(null);
            List<Integer> forecastNumList = forecastResult(dataList, dateList, date);
            //
            StrategyV1DTO dto = new StrategyV1DTO();
            dto.setDate(date);
            dto.setForecastNumList(forecastNumList);
            dto.setForecastNumCount(forecastNumList.size());
            dto.setHitCount(hitCount(cur, forecastNumList));
            //
            dtoList.add(dto);
        }
        fillGe2Interval(dtoList);
        //按照这种算法,计算命中2个的频率，70%，说明有效
        double hit0Ratio = MathUtil.percent(MathUtil.div4(dtoList.stream().filter(x -> x.getHitCount() == 0).count(), dtoList.size()));
        double hit1Ratio = MathUtil.percent(MathUtil.div4(dtoList.stream().filter(x -> x.getHitCount() == 1).count(), dtoList.size()));
        double hit2Ratio = MathUtil.percent(MathUtil.div4(dtoList.stream().filter(x -> x.getHitCount() == 2).count(), dtoList.size()));
        double hit3Ratio = MathUtil.percent(MathUtil.div4(dtoList.stream().filter(x -> x.getHitCount() == 3).count(), dtoList.size()));
        log.info("hit0Ratio:{}", hit0Ratio);
        log.info("hit1Ratio:{}", hit1Ratio);
        log.info("hit2Ratio:{}", hit2Ratio);
        log.info("hit3Ratio:{}", hit3Ratio);
        log.info("allRatio:{}", MathUtil.add(hit0Ratio, hit1Ratio, hit2Ratio, hit3Ratio));
        //从另一个角度校验，命中2个以上，预估的数字的个数的百分比，如果个数太多，那么就没有意义了
        //有一定的参考作用
        List<StrategyV1DTO> hitGe2List = dtoList.stream().filter(x -> x.getHitCount() >= 2).collect(Collectors.toList());
        List<Integer> forecastNumCountList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        for (Integer forecastNumCount : forecastNumCountList) {
            long matchCount = hitGe2List.stream().filter(x -> x.getForecastNumCount().equals(forecastNumCount)).count();
            double percent = MathUtil.percent(MathUtil.div4(matchCount, hitGe2List.size()));
            log.info("hitGe2,forecastNumCount:{},percent:{}", forecastNumCount, percent);
        }
        //间隔频率，大于等于2的数据中间隔了多少期
        ExcelUtil.writeSimpleData(dtoList, "strategy1.xlsx");

    }

    /**
     * 统计个数
     */
    private static Integer hitCount(D3Data cur, List<Integer> calAllResultList) {
        List<Integer> curList = Arrays.stream(cur.getRed().split(",")).map(Integer::parseInt).collect(Collectors.toList());
        int count = 0;
        for (Integer num : curList) {
            if (calAllResultList.contains(num)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 和上一个的间隔
     */
    private static void fillGe2Interval(List<StrategyV1DTO> dtoList) {
        StrategyV1DTO prev = null;
        for (StrategyV1DTO dto : dtoList) {
            if (dto.getHitCount() < 2) {
                continue;
            }
            if (prev == null) {
                prev = dto;
            } else {
                Integer diff = DateUtil.diff(prev.getDate(), dto.getDate());
                dto.setGe2Interval(diff);
                prev = dto;
            }
        }

    }

    /**
     * num1-3,num1-3,交叉相加
     * 去掉大于9的，并且要去重
     */
    @SuppressWarnings("all")
    private static List<Integer> forecastResult(List<D3Data> dataList, List<Integer> dateList, Integer date) {
        try {
            //日期可能不连续，所以不能用日期来判断，必须使用index
            D3Data prev2 = dataList.get(dateList.indexOf(date) - 2);
            D3Data prev = dataList.get(dateList.indexOf(date) - 1);
            //
            List<Integer> prev2NumList = Arrays.stream(prev2.getRed().split(",")).map(Integer::parseInt).collect(Collectors.toList());
            List<Integer> prevNumList = Arrays.stream(prev.getRed().split(",")).map(Integer::parseInt).collect(Collectors.toList());
            Set<Integer> resultSet = new HashSet<>();
            for (Integer prev2Num : prev2NumList) {
                for (Integer prevNum : prevNumList) {
                    resultSet.add(prev2Num + prevNum);
                }
            }
            resultSet.addAll(prev2NumList);
            resultSet.addAll(prevNumList);
            return Lists.newArrayList(resultSet).stream().filter(x -> x >= 0 && x <= 9).sorted().collect(Collectors.toList());
        } catch (Exception e) {
            log.error("forecastResult error,date:{}", date);
            throw e;
        }
    }
}
