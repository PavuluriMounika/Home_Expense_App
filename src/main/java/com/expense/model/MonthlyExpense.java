package com.expense.model;

import java.math.BigDecimal;
import javax.persistence.*;

@Entity
@Table(name = "MONTHLY_EXPENSE")
public class MonthlyExpense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MONTHLY_EXPENSE_ID")
    private int monthlyExpenseId;

    @Column(name = "DEFAULT_EXPENSE_ID")
    private int defaultExpenseId;

    @Column(name = "MONTH_NO")
    private int monthNo;

    @Column(name = "YEAR_NO")
    private int yearNo;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    public MonthlyExpense() {
    }

    public int getMonthlyExpenseId() {
        return monthlyExpenseId;
    }

    public void setMonthlyExpenseId(int monthlyExpenseId) {
        this.monthlyExpenseId = monthlyExpenseId;
    }

    public int getDefaultExpenseId() {
        return defaultExpenseId;
    }

    public void setDefaultExpenseId(int defaultExpenseId) {
        this.defaultExpenseId = defaultExpenseId;
    }

    public int getMonthNo() {
        return monthNo;
    }

    public void setMonthNo(int monthNo) {
        this.monthNo = monthNo;
    }

    public int getYearNo() {
        return yearNo;
    }

    public void setYearNo(int yearNo) {
        this.yearNo = yearNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}