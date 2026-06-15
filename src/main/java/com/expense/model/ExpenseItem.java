/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expense.model;

import javax.persistence.*;

/**
 *
 * @author mounika
 */
@Entity
@Table(name ="EXPENSE_ITEM")
public class ExpenseItem {
    
    @Id
    @Column(name = "ITEM_ID")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int itemId;
    
    @Column(name = "ITEM_NAME")
    private String itemName;
    
    @Column(name = "ACTIVE_FLAG")
    private String activeFlag;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(String activeFlag) {
        this.activeFlag = activeFlag;
    }
    
}
