package com.atividademod32.connectionFatory;

import jakarta.persistence.*;

public class ConnectionFactory {

    private volatile static EntityManagerFactory entityManagerFactory;
    private static final String PERSISTENCE_UNIT_NAME = "PostgresPersistenceUnit";


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

    public static void closeFactory() {
        EntityManagerFactory emf = entityManagerFactory;
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
