/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expense.action;

import com.expense.service.AppLabelService;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

/**
 *
 * @author mounika
 */
public class DefaultExpenseAction extends ActionSupport {
    
    private Map<String ,String> labels;

    public String execute() {
        
        AppLabelService service = new AppLabelService();
        labels =service.getLabels();
        return SUCCESS;
    }

    public Map<String, String> getLabels() {
        return labels;
    }

    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }
    
}
