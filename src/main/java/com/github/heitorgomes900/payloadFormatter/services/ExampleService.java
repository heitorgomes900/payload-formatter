package com.github.heitorgomes900.payloadFormatter.services;

import com.github.heitorgomes900.payloadFormatter.annotantions.ExtractInfo;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ExampleService {

    @ExtractInfo
    public String processPayload(String payload) {

        Log.info(payload);
        return payload;
    }
}
