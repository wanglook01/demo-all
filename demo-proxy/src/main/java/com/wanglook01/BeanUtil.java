package com.wanglook01;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class BeanUtil {

    /**
     * 通过反射获取一个新对象
     */
    public static SampleBean filtrateNeedFields(SampleBean ssuInfo) {
        SampleBean newSsu = new SampleBean();
        String fields = "skuId,class1Id,skuName,price,pictures,tagDTO,core_label_list,attrMap";
        SampleBean data = getData(ssuInfo, fields, SampleBean.class);
        return data == null ? newSsu : data;
    }

    public static <T> T getData(T source, String keyStr, Class<T> clazz) {
        Set<String> keySet = new HashSet<>();
        if (keyStr == null) {
            return null;
        }
        String[] split = keyStr.split(",");
        keySet.addAll(Lists.newArrayList(split));

        T t = null;
        try {
            Constructor<T> constructor = clazz.getConstructor();
            t = constructor.newInstance();
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field field : declaredFields) {
                if (keySet.contains(field.getName())) {
                    field.setAccessible(true);
                    field.set(t, field.get(source));
                }
            }
            return t;
        } catch (Exception e) {
            log.error("getDataError", e);
        }

        return t;
    }
}
