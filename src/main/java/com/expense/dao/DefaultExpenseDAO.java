package com.expense.dao;

import com.expense.model.DefaultExpense;
import com.expense.util.HibernateUtil;
import java.util.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DefaultExpenseDAO {
    Session session = null;
    Transaction transaction = null;

    public void save(DefaultExpense expense) {

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
    
    public List<DefaultExpense> getExpenseList(){
        
        session = HibernateUtil.getSessionFactory().openSession();
        List<DefaultExpense> expenseList =session.createQuery("from DefaultExpense", DefaultExpense.class)
               .list();
        session.close();

        return expenseList;
    }
    
    public DefaultExpense getExpenseById(int expenseId){
        session = HibernateUtil.getSessionFactory().openSession();
        DefaultExpense expense = session.get(DefaultExpense.class, expenseId);
        session.close();
        return expense;  
            
    }
    
    public void update(DefaultExpense expense) {

        try {

            session = HibernateUtil.getSessionFactory().openSession();

            transaction = session.beginTransaction();

            session.update(expense);

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
    
    public void delete(int expenseId){
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();

            transaction = session.beginTransaction();

            DefaultExpense expense =
                    session.get(DefaultExpense.class, expenseId);

            if (expense != null) {
                session.delete(expense);
            }

            transaction.commit();
        
        }catch (Exception e) {

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