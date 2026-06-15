/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expense.action;

import com.expense.model.ExpenseItem;
import com.expense.service.ExpenseItemService;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author mounika
 */
public class ExpenseItemAction  extends ActionSupport{
    
    private List<ExpenseItem> itemList;
    
    public String execute(){
        
        ExpenseItemService service= new ExpenseItemService();
        itemList = service.getActiveItems();
        
        return SUCCESS;
    }

    public List<ExpenseItem> getItemList() {
        return itemList;
    }
    
    
}
