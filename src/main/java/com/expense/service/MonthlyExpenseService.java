package com.expense.service;

import com.expense.dao.MonthlyExpenseDAO;
import com.expense.model.MonthlyExpense;
import com.expense.model.MonthlyExpenses;
import java.util.List;

public class MonthlyExpenseService {

    MonthlyExpenseDAO dao = new MonthlyExpenseDAO();

    public List<MonthlyExpense> getMonthlyExpenses() {

        return dao.getMonthlyExpenses();

    }
    public void saveMonthlyExpenses(List<MonthlyExpenses> expenseList) {
        dao.saveMonthlyExpenses(expenseList);
    }
    public List<MonthlyExpenses> getMonthlyExpenses(int year,String month) {

        return dao.getMonthlyExpenses(year, month);
    }
}