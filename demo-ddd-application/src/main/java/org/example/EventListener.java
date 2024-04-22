package org.example;

import org.example.MiEvent;

public interface EventListener<E extends MiEvent> {

    void handle(E e);
}
