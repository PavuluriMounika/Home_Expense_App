<%-- 
    Document   : monthlyExpense
    Created on : 12-Jul-2026, 9:21:23 pm
    Author     : mounika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>monthly entry page</title>
    </head>
    <body>
        <h1>Monthly Expense</h1><br></br>
        <label>Year</label>
        <select id="yearId">
            <option value="">Select Year</option>
        </select><br></br>
       <label>Month</label>
        <select id="monthId">
            <option value="">Select Month</option>
        </select><br></br>
        <button id="loadBtn">Load Default Expenses</button>
    </body>
</html>
