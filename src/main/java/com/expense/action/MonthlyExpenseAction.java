/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expense.action;

import com.expense.model.DefaultExpense;
import com.expense.model.MonthlyExpense;
import com.expense.model.MonthlyExpenses;
import com.expense.service.DefaultExpenseService;
import com.expense.service.MonthlyExpenseService;
import com.opensymphony.xwork2.ActionSupport;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;

/**
 *
 * @author mounika
 */
public class MonthlyExpenseAction extends ActionSupport{
    private List<Integer> yearList;
    private List<String> monthList;
    private MonthlyExpenseService service = new MonthlyExpenseService();
    private DefaultExpenseService defaultExpenseService =new DefaultExpenseService();
    private List<MonthlyExpense> list;
    private int year;
    private  String expenseList;
    private List<MonthlyExpenses> monthlyList;

    private String month;

    private List<DefaultExpense> defaultExpenseList;
    private List<Object> finalList;
    
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
    public String loadDefaultExpenses(){

        System.out.println("Year = " + year);

        System.out.println("Month = " + month);
        defaultExpenseList = defaultExpenseService.getExpenseList();
        monthlyList=service.getMonthlyExpenses(year, month);
        finalList = new ArrayList<>();
        finalList.addAll(defaultExpenseList);
        finalList.addAll(monthlyList);

        return SUCCESS;

    }
    public String saveMonthlyExpenses() {

        Gson gson = new Gson();

        List<MonthlyExpenses> monthlyExpenses =
                gson.fromJson(
                        expenseList,
                        new TypeToken<List<MonthlyExpenses>>() {}.getType()
                );

        service.saveMonthlyExpenses(monthlyExpenses);

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public List<DefaultExpense> getDefaultExpenseList() {
        return defaultExpenseList;
    }

    public void setDefaultExpenseList(List<DefaultExpense> defaultExpenseList) {
        this.defaultExpenseList = defaultExpenseList;
    }

    public String getExpenseList() {
        return expenseList;
    }

    public void setExpenseList(String expenseList) {
        this.expenseList = expenseList;
    }

    public List<MonthlyExpenses> getMonthlyList() {
        return monthlyList;
    }

    public void setMonthlyList(List<MonthlyExpenses> monthlyList) {
        this.monthlyList = monthlyList;
    }

    public List<Object> getFinalList() {
        return finalList;
    }

    public void setFinalList(List<Object> finalList) {
        this.finalList = finalList;
    }
    
       
    
}
