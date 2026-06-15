/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expense.service;

import com.expense.dao.ExpenseItemDAO;
import com.expense.model.ExpenseItem;
import java.util.List;

/**
 *
 * @author mounika
 */
public class ExpenseItemService {
    
    private ExpenseItemDAO dao= new ExpenseItemDAO();
    
    public List<ExpenseItem> getActiveItems(){
        return dao.getActiveItems();
    }
    
}
