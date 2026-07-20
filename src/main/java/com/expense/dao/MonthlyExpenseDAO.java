/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expense.dao;

import com.expense.model.MonthlyExpense;
import com.expense.model.MonthlyExpenses;
import java.util.List;
import com.expense.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
/**
 *
 * @author mounika
 */
public class MonthlyExpenseDAO {
    Session session = null;
    Transaction transaction = null;

    
    public List<MonthlyExpense> getMonthlyExpenses(){
        List<MonthlyExpense> list = null;

        try {

            session = HibernateUtil.getSessionFactory().openSession();

            transaction = session.beginTransaction();
            Query<MonthlyExpense> query = session.createQuery("FROM MonthlyExpense", MonthlyExpense.class);
            list = query.list();
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
        return list;
        
    }
    public void saveMonthlyExpenses(List<MonthlyExpenses> expenseList) {

        try {

            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            for (MonthlyExpenses expense : expenseList) {
                session.save(expense);
            }

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
    public List<MonthlyExpenses> getMonthlyExpenses(int year,String month){
        List<MonthlyExpenses> list = null;

        try {

            session = HibernateUtil.getSessionFactory().openSession();

            transaction = session.beginTransaction();
            Query<MonthlyExpenses> query =
                    session.createQuery(
                        "FROM MonthlyExpenses " +
                        "WHERE expenseYear = :year " +
                        "AND expenseMonth = :month",
                        MonthlyExpenses.class
                    );            query.setParameter("year", year);
            query.setParameter("month",month);
            list=query.list();
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
        return list;
        
    }
    
}
