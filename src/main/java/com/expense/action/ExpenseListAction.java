/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expense.action;

import com.expense.model.DefaultExpense;
import com.expense.service.DefaultExpenseService;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author mounika
 */
public class ExpenseListAction extends ActionSupport{
    
    private List<DefaultExpense> list;
    
    private DefaultExpenseService service= new DefaultExpenseService();
    
     public String execute() {
         list= service.getExpenseList();
         return SUCCESS;
     }

    public List<DefaultExpense> getList() {
        return list;
    }

    public void setList(List<DefaultExpense> list) {
        this.list = list;
    }
     
    
    
    
    
    
}
