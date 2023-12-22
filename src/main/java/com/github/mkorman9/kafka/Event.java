package com.github.mkorman9.kafka;

import lombok.Builder;

import java.time.Instant;

@Builder
public record Event(
    String message,
    Instant timestamp
) {
}
