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
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="js/expenseList.js"></script>
    </head>
    <body>
        <div>
            <label>Item</label>

            <select id="expenseItem">
                <option value="0">All</option>
            </select>

            <button type="button" id="searchBtn">
                Search
            </button>
        </div>
        
            <label>Export</label>

            <select id="exportType">
                <option value="pdf">PDF</option>
            </select>
        </div

    <br/>
<table border="1">
    <tr>
        <th>Expense Id</th>
        <th>Item Id</th>
        <th>Amount</th>
        <th>Description</th>
    </tr>

    <tbody id="expenseTableBody">

        <s:iterator value="list">
            <tr>
                <td>
                    <a href="expenseView.action?expenseId=<s:property value='expenseId'/>">
                        <s:property value="expenseId"/>
                    </a>
                </td>
                <td><s:property value="itemId"/></td>
                <td><s:property value="amount"/></td>
                <td><s:property value="description"/></td>
            </tr>
        </s:iterator>

    </tbody>
</table>
    </body>
</html>
