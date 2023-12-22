package com.github.mkorman9.kafka;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
@Slf4j
public class EventsReceiver {
    @Incoming("events")
    public void onEvent(Event event) {
        log.info("Received event: {} ({})", event.message(), event.timestamp());
    }
}
