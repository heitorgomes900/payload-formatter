package com.github.heitorgomes900.payloadFormatter.services;

import com.github.heitorgomes900.payloadFormatter.annotantions.ExtractInfo;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@ExtractInfo
@Interceptor
public class ExtractInfoInterceptor {

    @AroundInvoke
    public Object extractInfo(InvocationContext context) throws Exception {
        Object[] parameters = context.getParameters();
        for (int i = 0; i< parameters.length; i++) {
            if (parameters[i] instanceof String) {
                String param = (String) parameters[i];
                String extractedValue = extractInfoFromPayload(param);
                parameters[i] = extractedValue;
            }
        }
        context.setParameters(parameters);
        return context.proceed();
    }

    private String extractInfoFromPayload(String payload) {
        String[] parts = payload.split("\\.");
        for (String part : parts) {
            if (part.startsWith("op")){
                return part;
            }
        }
        return null;
    }
}
