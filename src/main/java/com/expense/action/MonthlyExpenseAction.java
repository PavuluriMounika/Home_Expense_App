/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expense.action;

import com.expense.model.MonthlyExpense;
import com.expense.service.MonthlyExpenseService;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author mounika
 */
public class MonthlyExpenseAction extends ActionSupport{
    private MonthlyExpenseService service = new MonthlyExpenseService();
    private List<MonthlyExpense> list;
    
    public String execute(){
        list = service.getMonthlyExpenses();
         return SUCCESS;
    }
    public List<MonthlyExpense> getList() {
    return list;
    }

    public void setList(List<MonthlyExpense> list) {
        this.list = list;
    }
    
    
}
