package com.atividadeMod33.connection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectionFactory {
    private volatile static EntityManagerFactory entityManagerFactory;
    private static final String PERSISTENCE_UNIT_NAME = "atividadeMod33";


    public static EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    private static EntityManagerFactory getEntityManagerFactory() {
        EntityManagerFactory localEntityManagerFactory = entityManagerFactory;
        if (localEntityManagerFactory == null || !localEntityManagerFactory.isOpen()) {
            synchronized (ConnectionFactory.class) {
                localEntityManagerFactory = entityManagerFactory;
                if (localEntityManagerFactory == null || !localEntityManagerFactory.isOpen()) {
                    entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
                }
            }
        }
        return entityManagerFactory;
    }
}
