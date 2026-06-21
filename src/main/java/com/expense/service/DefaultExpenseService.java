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
    
}