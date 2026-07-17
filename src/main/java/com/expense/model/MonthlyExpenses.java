package com.expense.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MONTHLY_EXPENSES")
public class MonthlyExpenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MONTHLY_EXPENSE_ID")
    private int monthlyExpenseId;

    @Column(name = "EXPENSE_YEAR")
    private int expenseYear;

    @Column(name = "EXPENSE_MONTH")
    private String expenseMonth;

    @Column(name = "ITEM_ID")
    private int itemId;

    @Column(name = "AMOUNT")
    private double amount;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ACTIVE_FLAG")
    private String activeFlag;

    public int getMonthlyExpenseId() {
        return monthlyExpenseId;
    }

    public void setMonthlyExpenseId(int monthlyExpenseId) {
        this.monthlyExpenseId = monthlyExpenseId;
    }

    public int getExpenseYear() {
        return expenseYear;
    }

    public void setExpenseYear(int expenseYear) {
        this.expenseYear = expenseYear;
    }

    public String getExpenseMonth() {
        return expenseMonth;
    }

    public void setExpenseMonth(String expenseMonth) {
        this.expenseMonth = expenseMonth;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(String activeFlag) {
        this.activeFlag = activeFlag;
    }
}