/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expense.service;

import com.expense.dao.AppLabelDAO;
import java.util.Map;

/**
 *
 * @author mounika
 */
public class AppLabelService {
    
    private AppLabelDAO appLabelDAO = new AppLabelDAO();
    
    public Map<String,String> getLabels(){
        return appLabelDAO.getLabels();
    }
    
    
    
}
