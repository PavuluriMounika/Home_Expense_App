<%-- 
    Document   : monthlyExpense
    Created on : 12-Jul-2026, 9:21:23 pm
    Author     : mounika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="js/monthlyExpense.js"></script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>monthly entry page</title>
    </head>
    <body>
        <h1>Monthly Expense</h1><br></br>
        <label>Year</label>
            <s:select
        id="yearId"
        name="year"
        list="yearList"
        headerKey=""
        headerValue="Select Year"/><br></br>
        <label>Month</label>
        <s:select
            id="monthId"
            name="month"
            list="monthList"
            headerKey=""
            headerValue="Select Month"/><br></br>
        <button id="loadBtn">Load Default Expenses</button>
        <div id="monthlyExpenseTable" style="display: none">   
                <table border="1">
                <thead>
                    <tr>
                        <th>Expense Id</th>
                        <th>Item Id</th>
                        <th>Amount</th>
                        <th>Description</th>
                    </tr>
                </thead>

                <tbody id="monthlyExpenseBody">

                </tbody>
            </table>
        </div>
        <button id="addRowBtn">Add Row</button>
    </body>
</html>
