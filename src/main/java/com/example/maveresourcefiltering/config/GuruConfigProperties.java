package com.example.maveresourcefiltering.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 *  Usar esto cuando tenes grupos de properties relacionadas
 */

@Component
@PropertySource("classpath:guru/config.properties")
@ConfigurationProperties(prefix = "guru.config")
public class GuruConfigProperties {

    private int hilos;

    private int mesesAtras;

    private String pathArchivos;

    public int getHilos() {
        return hilos;
    }

    public int getMesesAtras() {
        return mesesAtras;
    }

    public String getPathArchivos() {
        return pathArchivos;
    }

    public void setHilos(int hilos) {
        this.hilos = hilos;
    }

    public void setMesesAtras(int mesesAtras) {
        this.mesesAtras = mesesAtras;
    }

    public void setPathArchivos(String pathArchivos) {
        this.pathArchivos = pathArchivos;
    }
}
