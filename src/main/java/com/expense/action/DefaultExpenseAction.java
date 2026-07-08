/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expense.action;

import com.expense.model.DefaultExpense;
import com.expense.service.AppLabelService;
import com.expense.service.DefaultExpenseService;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.opensymphony.xwork2.ActionSupport;
import static java.lang.System.in;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.itextpdf.text.Font;
import com.itextpdf.text.Element;
/**
 *
 * @author mounika
 */
public class DefaultExpenseAction extends ActionSupport {

    private Map<String,String> labels;

    private int itemId;
    private BigDecimal amount;
    private String description;
    private int expenseId;
    private DefaultExpenseService service = new DefaultExpenseService();
    private DefaultExpense expense;
    private List<DefaultExpense> list;

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
    public String loadExpense() {

        if (expenseId > 0) {

            expense = service.getExpenseById(expenseId);
        }

        return SUCCESS;
    }
    
    public String update(){
        AppLabelService appLabelService = new AppLabelService();

        DefaultExpense expense = new DefaultExpense();
        expense.setItemId(itemId);
        expense.setAmount(amount);
        expense.setDescription(description);
        expense.setExpenseId(expenseId);
        service.update(expense);

        labels = appLabelService.getLabels();

        
        
        return SUCCESS;
    }
    public String delete() {
        service.delete(expenseId);
        return SUCCESS;
    }
    public String searchByItem() {
        if (itemId == 0) {
            list = service.getExpenseList();
        } else {
            list = service.selectByItemId(itemId);
        }
       
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

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public DefaultExpense getExpense() {
        return expense;
    }

    public void setExpense(DefaultExpense expense) {
        this.expense = expense;
    }
    public List<DefaultExpense> getList() {
        return list;
    }

    public void setList(List<DefaultExpense> list) {
        this.list = list;
    }
    public String exportPdf() {

            list = service.getExpenseList();

            HttpServletResponse response = ServletActionContext.getResponse();

            try {

                Document document = new Document();

                response.setContentType("application/pdf");

                PdfWriter.getInstance(document, response.getOutputStream());

                document.open();
                Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);

                Paragraph title = new Paragraph("Expense Report", titleFont);
                title.setAlignment(Element.ALIGN_CENTER);
                title.setSpacingAfter(20f);
                document.add(title);
                
                PdfPTable table = new PdfPTable(4);

                table.addCell("Expense Id");
                table.addCell("Item Id");
                table.addCell("Amount");
                table.addCell("Description");
                BigDecimal total = BigDecimal.ZERO;
                for(DefaultExpense expense : list){
                    total =total.add(expense.getAmount());
                }

                for (DefaultExpense expense : list) {

                    table.addCell(String.valueOf(expense.getExpenseId()));
                    table.addCell(String.valueOf(expense.getItemId()));
                    table.addCell(expense.getAmount().toString());
                    table.addCell(expense.getDescription());

                }

                document.add(table);
                Paragraph totalAmount = new Paragraph("Total Amount : ₹ " + total);
                document.add(totalAmount);
                document.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

            return NONE;
        }
    
}   