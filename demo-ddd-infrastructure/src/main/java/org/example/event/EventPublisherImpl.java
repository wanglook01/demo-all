package org.example.event;

import lombok.extern.slf4j.Slf4j;
import org.example.EventPublisher;
import org.example.MiEvent;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EventPublisherImpl implements EventPublisher {

    @Override
    public void publish(MiEvent event) {
        log.info("eventPublisher:topic:{},event:{}", event.getTopic(), event);
        //TODO ......
    }
}
