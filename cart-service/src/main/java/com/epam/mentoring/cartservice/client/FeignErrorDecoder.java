package com.epam.mentoring.cartservice.client;

import com.epam.mentoring.cartservice.exceptions.ProductNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

@Component
public class FeignErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
        if (response.status() == 404) {
            return new ProductNotFoundException();
        }
        return defaultErrorDecoder.decode(s, response);
    }
}
