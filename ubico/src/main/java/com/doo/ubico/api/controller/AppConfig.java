package com.doo.ubico.api.controller;

import com.doo.ubico.data.dao.factory.sql.azuresql.AzureSqlDAOFactory;
import com.doo.ubico.data.dao.factory.DAOFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public DAOFactory daoFactory() {
        return new AzureSqlDAOFactory();
    }
}