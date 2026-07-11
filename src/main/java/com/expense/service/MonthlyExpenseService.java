package com.expense.service;

import com.expense.dao.MonthlyExpenseDAO;
import com.expense.model.MonthlyExpense;
import java.util.List;

public class MonthlyExpenseService {

    MonthlyExpenseDAO dao = new MonthlyExpenseDAO();

    public List<MonthlyExpense> getMonthlyExpenses() {

        return dao.getMonthlyExpenses();

    }

}