package com.andree.panjaitan.parkeebe.config;

import com.andree.panjaitan.parkeebe.shared.SuccessResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.ErrorResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

public class CustomResponseAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if ((!(o instanceof ErrorResponse)) && (!(o instanceof SuccessResponse))) {
            SuccessResponse<Object> responseBody = new SuccessResponse<>(o);
            return responseBody;
        }
        return o;
    }
}
