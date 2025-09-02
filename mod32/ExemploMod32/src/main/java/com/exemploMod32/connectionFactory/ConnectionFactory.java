package com.exemploMod32.connectionFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectionFactory {
    private volatile static EntityManagerFactory entityManagerFactory;
    private static final String PERSISTENCE_UNIT_NAME = "meuPersistenceUnit";

    public static EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    private static EntityManagerFactory getEntityManagerFactory() {
        EntityManagerFactory localConnection = entityManagerFactory;

        if (localConnection == null || !localConnection.isOpen()) {
            synchronized (ConnectionFactory.class) {
                localConnection = entityManagerFactory;
                if (localConnection == null || !localConnection.isOpen()) {
                    entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
                }
            }
        }
        return entityManagerFactory;
    }

    public static void close() {
        EntityManagerFactory localConnection = entityManagerFactory;
        if (localConnection != null && localConnection.isOpen()) {
            localConnection.close();
        }
    }

}
