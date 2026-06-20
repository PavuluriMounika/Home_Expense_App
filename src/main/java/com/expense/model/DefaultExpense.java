package com.expense.model;

import java.math.BigDecimal;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "DEFAULT_EXPENSE")
public class DefaultExpense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EXPENSE_ID")
    private int expenseId;

    @Column(name = "ITEM_ID")
    private int itemId;

    @Column(name = "AMOUNT")
    @NotNull(message = "{amount.required}")
    private BigDecimal amount;

    @Column(name = "DESCRIPTION")
    private String description;

    // Getters and Setters

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
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