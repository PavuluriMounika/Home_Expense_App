/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expense.action;

import com.expense.model.DefaultExpense;
import com.expense.service.AppLabelService;
import com.expense.service.DefaultExpenseService;
import com.opensymphony.xwork2.ActionSupport;
import java.math.BigDecimal;
import java.util.Map;

/**
 *
 * @author mounika
 */
public class DefaultExpenseAction extends ActionSupport {

    private Map<String,String> labels;

    private int itemId;
    private BigDecimal amount;
    private String description;

    public String execute() {

        AppLabelService appLabelService = new AppLabelService();

        DefaultExpense expense = new DefaultExpense();

        expense.setItemId(itemId);
        expense.setAmount(amount);
        expense.setDescription(description);

        DefaultExpenseService defaultExpenseService =
                new DefaultExpenseService();

        defaultExpenseService.save(expense);

        labels = appLabelService.getLabels();

        return SUCCESS;
    }

    // getters and setters

    public Map<String, String> getLabels() {
        return labels;
    }

    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}