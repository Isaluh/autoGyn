package com.bamboobyte.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class ConexaoBD {
    
    @Autowired
    private EntityManagerFactory entityManagerFactory;  // O Spring cria isso automaticamente

    // Método para obter a instância do EntityManager
    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();  // Obtém a instância do EntityManager a partir do EntityManagerFactory
    }

    // Método para configurar o JpaTransactionManager
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
