package com.finops.sbiservice.config;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
public class MongoConfig {

    @Value("${spring.mongo.host}")
    private String hostName;

    @Value("${spring.mongo.user}")
    private String userName;

    @Value("${spring.mongo.password}")
    private String password;

    @Value("${spring.mongo.db}")
    private String dbName;

    private static final String CONN_START_STRING="mongodb+srv://";

    private static final String CONN_END_STRING="?retryWrites=true&w=majority";

    public MongoClient mongoClient() {

        return MongoClients.create(CONN_START_STRING+userName+":"+password+"@"+hostName+"/"+dbName+CONN_END_STRING);
//                return MongoClients.create(CONN_START_STRING+userName+":"+password+"@"+hostName+"/"+"test");
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "SBI");
    }


}

