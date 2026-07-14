/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expense.action;

import com.expense.model.MonthlyExpense;
import com.expense.service.MonthlyExpenseService;
import com.opensymphony.xwork2.ActionSupport;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author mounika
 */
public class MonthlyExpenseAction extends ActionSupport{
    private List<Integer> yearList;
    private List<String> monthList;
    private MonthlyExpenseService service = new MonthlyExpenseService();
    private List<MonthlyExpense> list;
    
    public String execute(){
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR); 
        String[] months = new DateFormatSymbols().getMonths();
        yearList = new ArrayList<>();
        monthList = new ArrayList<>();
        for (int i = currentYear - 2; i <= currentYear + 2; i++) {
            yearList.add(i);
        }
        for (int i = 0; i < 12; i++) {
            monthList.add(months[i]);
        }
        //list = service.getMonthlyExpenses();
         return SUCCESS;
    }
    public List<MonthlyExpense> getList() {
    return list;
    }

    public void setList(List<MonthlyExpense> list) {
        this.list = list;
    }

    public List<Integer> getYearList() {
        return yearList;
    }

    public void setYearList(List<Integer> yearList) {
        this.yearList = yearList;
    }

    public List<String> getMonthList() {
        return monthList;
    }

    public void setMonthList(List<String> monthList) {
        this.monthList = monthList;
    }

      
}
