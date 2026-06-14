package com.expense.util;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final Logger logger =
            Logger.getLogger(HibernateUtil.class);

    private static SessionFactory sessionFactory;

    static {

        try {

            sessionFactory = new Configuration()
                    .configure()
                    .buildSessionFactory();

            logger.info("SessionFactory created successfully");

        } catch (Throwable ex) {

            logger.error("SessionFactory creation failed", ex);

            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {

        return sessionFactory;
    }
}