package com.expense.service;

import com.expense.dao.DefaultExpenseDAO;
import com.expense.model.DefaultExpense;

public class DefaultExpenseService {

    private DefaultExpenseDAO defaultExpenseDAO =
            new DefaultExpenseDAO();

    public void save(DefaultExpense expense) {

        defaultExpenseDAO.save(expense);
    }
}