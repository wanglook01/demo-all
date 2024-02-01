package com.wanglook01;

import com.google.common.collect.Lists;
import com.wanglook01.observable.ObservableBeanFactory;
import com.wanglook01.observable.PropChangeDTO;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:/Temp/code/cglib");
        PropChangeDTO dto = new PropChangeDTO();
        dto.setRequestUrl("/api/list");
        dto.setUserId(111L);
        dto.setObservablePropList(Arrays.asList("skuId", "class1Id", "skuName", "price", "pictures", "tagDTO", "core_label_list", "attrMap"));
        /* Will not be observed */
        SampleBean regular = new SampleBean();
        regular.setSkuId(100L);
        regular.setSkuId(200L);
        regular.setSkuId(300L);
        regular.setClass1Id(100);
        regular.setSkuName("土豆");
        regular.setPrice(100D);
        regular.setPictures(Lists.newArrayList("abc"));
        regular.setTagDTO(SampleBean.TagDTO.get(1, 1, "qw", "tips", "location"));
        regular.setCore_label_list(Lists.newArrayList(SampleBean.TagDTO.get(1, 1, "qw", "tips", "location")));
        Map<String, SampleBean.TagDTO> map = new HashMap<>();
        map.put("abc", SampleBean.TagDTO.get(1, 1, "qw", "tips", "location"));
        regular.setAttrMap(map);


        /* Will be observed */
        SampleBean observableBean = ObservableBeanFactory.createBean(SampleBean.class, dto);
        //基础的一些字段，Long,Double,String,Integer等
        observableBean.setSkuId(100L);
        observableBean.setSkuId(200L);
        observableBean.setClass1Id(100);
        observableBean.setClass1Id(200);
        observableBean.setSkuName("土豆");
        observableBean.setSkuName("西红柿");
        observableBean.setPrice(100D);
        observableBean.setPrice(200D);
        //集合，比较的竟然是集合中元素，震惊，也就是调用了equals方法
        observableBean.setPictures(Lists.newArrayList("http", "https"));
        observableBean.setPictures(Lists.newArrayList("http", "https"));
        observableBean.setPictures(Lists.newArrayList("http", "https", "http", "https"));
        //对象，比较的时候调用了equals和toString方法
        observableBean.setTagDTO(SampleBean.TagDTO.get(1, 1, "qw", "tips", "location"));
        observableBean.setTagDTO(SampleBean.TagDTO.get(1, 1, "qw", "tips", "location"));
        observableBean.setTagDTO(SampleBean.TagDTO.get(1, 1, "abc", "tips", "location"));
        //对象集合
        //Map
        //测试一下反射,要求反射创建对象的时候，必须使用可监测的对象创建方式，普通的new是没有办法的
        //结果：反射没有起作用，监控不到
        SampleBean sampleBean = BeanUtil.filtrateNeedFields(observableBean);
        System.out.println(sampleBean);

    }
}