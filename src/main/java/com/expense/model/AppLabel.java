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
@Table(name="APP_LABELS")
public class AppLabel {
    
    @Id
    @Column(name="LABEL_KEY")
    private String labelKey;
    
    
    @Column(name="LABEL_VALUE")
    private String labelValue;

    public String getLabelKey() {
        return labelKey;
    }

    public void setLabelKey(String labelKey) {
        this.labelKey = labelKey;
    }

    public String getLabelValue() {
        return labelValue;
    }

    public void setLabelValue(String labelValue) {
        this.labelValue = labelValue;
    }
    
    
     
    
    
}
