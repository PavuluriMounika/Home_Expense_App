package com.expense.dao;

import com.expense.model.DefaultExpense;
import com.expense.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DefaultExpenseDAO {

    public void save(DefaultExpense expense) {

        Session session = null;
        Transaction transaction = null;

        try {

            session = HibernateUtil.getSessionFactory().openSession();

            transaction = session.beginTransaction();

            session.save(expense);

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();

        } finally {

            if (session != null) {
                session.close();
            }
        }
    }
}