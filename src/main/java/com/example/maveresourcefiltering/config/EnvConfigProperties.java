package com.example.maveresourcefiltering.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 *  Usar esto cuando properties activables segun variable de entorno ej: ENV_TARGET
 */

@Component
@PropertySource("classpath:env/config-${env.target}.properties")
@ConfigurationProperties(prefix = "app.config")
public class EnvConfigProperties {

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
