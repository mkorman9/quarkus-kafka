package com.github.mkorman9.kafka;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class EventsSender {
    @Inject
    @Channel("events")
    Emitter<Event> eventsEmitter;

    public void send(Event event) {
        eventsEmitter.send(event);
    }
}
