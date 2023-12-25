package com.wanglook01.observable;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;

import java.beans.PropertyChangeSupport;
import java.util.Objects;

@Slf4j
public final class ObservableBeanFactory {

    @SuppressWarnings("all")
    public static <T> T createBean(Class<T> beanClass, PropChangeDTO dto) {
        try {
            if (Objects.equals(dto.getUserId(), 111L) && Objects.equals(dto.getRequestUrl(), "/api/list")) {
                BeanMethodInterceptor interceptor = new BeanMethodInterceptor();
                Enhancer e = new Enhancer();
                e.setSuperclass(beanClass);
                e.setCallback(interceptor);
                T bean = (T) e.create();
                //可监听的配置,这个是一个观察者模式，本质上不加这个直接代码写死也是可以的，但是用这个逼格高
                PropertyChangeSupport pcs = new PropertyChangeSupport(bean);
                pcs.addPropertyChangeListener(new PropertyChangeLoggingListener());
                interceptor.setTarget(pcs, dto.getObservablePropList());
                return bean;
            }
            return beanClass.newInstance();
        } catch (Exception e) {
            log.error("createBean error,{}", beanClass.getName(), e);
            throw new RuntimeException("createBeanError");
        }
    }

}
