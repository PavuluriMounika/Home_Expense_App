/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expense.dao;

import com.expense.model.ExpenseItem;
import com.expense.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author mounika
 */
public class ExpenseItemDAO {
    
    public List<ExpenseItem> getActiveItems(){
        
        Session session =HibernateUtil.getSessionFactory().openSession();
        
        List<ExpenseItem> list=session.createQuery( "FROM ExpenseItem WHERE activeFlag='Y'",ExpenseItem.class).list();
        session.close();
        return list;
        
    }
    
}
