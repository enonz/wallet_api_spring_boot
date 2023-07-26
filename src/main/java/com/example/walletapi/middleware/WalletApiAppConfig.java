package com.example.walletapi.middleware;

import com.example.walletapi.middleware.WalletApiInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WalletApiAppConfig implements WebMvcConfigurer {
    @Autowired
    WalletApiInterceptor walletApiInterceptor;

    @Override
    public void addInterceptors(@NonNull InterceptorRegistry interceptorRegistry) {
        interceptorRegistry.addInterceptor(walletApiInterceptor);
    }
}
