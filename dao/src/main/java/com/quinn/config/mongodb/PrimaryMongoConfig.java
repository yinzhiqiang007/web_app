package com.quinn.config.mongodb;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;


//@Configuration
//@ConfigurationProperties(prefix = "spring.data.mongodb.primary")
public class PrimaryMongoConfig extends AbstractMongoConfig {

    @Primary
    @Override
    public @Bean(name = "primaryMongoTemplate")
    MongoTemplate getMongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }

}
