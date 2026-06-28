package com.expense.service;

import com.expense.dao.DefaultExpenseDAO;
import com.expense.model.DefaultExpense;
import java.util.List;

public class DefaultExpenseService {

    private DefaultExpenseDAO defaultExpenseDAO =
            new DefaultExpenseDAO();

    public void save(DefaultExpense expense) {

        defaultExpenseDAO.save(expense);
    }
    public List<DefaultExpense> getExpenseList() {
        return defaultExpenseDAO.getExpenseList();
    }
    public DefaultExpense getExpenseById(int expenseId) {
        return defaultExpenseDAO.getExpenseById(expenseId);
    }
    public void update(DefaultExpense expense){
        defaultExpenseDAO.update(expense);
    }
    public void delete(int expenseId){
        defaultExpenseDAO.delete(expenseId);
    } 
    public List<DefaultExpense> selectByItemId(int itemId) {
        return defaultExpenseDAO.selectByItemId(itemId);
    }
    
    
}