package com.wanglook01.observable;

import lombok.extern.slf4j.Slf4j;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

@Slf4j
public class PropertyChangeLoggingListener implements PropertyChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String[] split = evt.getPropertyName().split("\\|");
        log.info("propertyChange:{},【{}--->{}】,location:{}",
                evt.getSource().getClass().getSimpleName() + "." + split[1],
                evt.getOldValue(), evt.getNewValue(), split[0]);
    }

}
