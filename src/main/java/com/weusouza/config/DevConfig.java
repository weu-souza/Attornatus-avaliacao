package com.weusouza.config;

import com.weusouza.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {
private final DBService dbService;

@Value("$(spring.jpa.hibernate.ddl-auto)")

private String strategy;

@Autowired
    public DevConfig(DBService dbService) {
        this.dbService = dbService;
    }

    @Bean
public boolean instanciaBaseDeDados(){
    if (strategy.equals("create")){
        this.dbService.instanciaBaseDeDados();
    }
    return false;
}
}
