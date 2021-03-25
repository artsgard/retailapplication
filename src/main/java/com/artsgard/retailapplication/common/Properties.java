package com.artsgard.retailapplication.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties
public class Properties {

    //@Value("${properties.common.image-path}")
    //public String imagePath;

    @Value("${server.servlet.context-path}")
    public String applicationContext;

}

