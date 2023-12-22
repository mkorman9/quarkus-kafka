package com.github.mkorman9.kafka;

import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.RestResponse;

import java.time.Instant;

@Path("/event/send")
@Produces(MediaType.APPLICATION_JSON)
@Consumes({})
@RunOnVirtualThread
public class EventsSendingResource {
    @Inject
    EventsSender eventsSender;

    @GET
    public RestResponse<Void> sendEvent() {
        eventsSender.send(
            Event.builder()
                .message("some message")
                .timestamp(Instant.now())
                .build()
        );

        return RestResponse.ok();
    }
}
