<%-- 
    Document   : expenseList
    Created on : 21-Jun-2026, 9:32:31 pm
    Author     : mounika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
    <table border="1">
        <tr>
            <th>Expense Id</th>
            <th>Item Id</th>
            <th>Amount</th>
            <th>Description</th>
        </tr>

        <s:iterator value="list">
            <tr>
                <td><a href="defaultExpense.action?expenseId=<s:property value='expenseId'/>">
                     <s:property value="expenseId"/></a></td>
                <td><s:property value="itemId"/></td>
                <td><s:property value="amount"/></td>
                <td><s:property value="description"/></td>
            </tr>
        </s:iterator>
    </table>
    </body>
</html>
