package com.example.productos.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class MessageConfig {

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        // Cargar los archivos de mensajes desde resources
        messageSource.setBasename("classpath:messages");  // "messages" es el prefijo de los archivos .properties
        messageSource.setDefaultEncoding("UTF-8");  // Definir la codificación de los archivos
        return messageSource;
    }
}
