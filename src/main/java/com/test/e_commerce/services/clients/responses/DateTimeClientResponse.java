package com.test.e_commerce.services.clients.responses;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class DateTimeClientResponse {

    private OffsetDateTime creationAt;

    private OffsetDateTime updatedAt;
}
