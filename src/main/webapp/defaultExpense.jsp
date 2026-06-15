<%-- 
    Document   : defaultExpense
    Created on : 15-Jun-2026, 10:13:12 am
    Author     : mounika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<h2>Default Expense Entry</h2>

Expense Item:
<select id="expenseItem">
    <option>Loading...</option>
</select>

<script>
$(document).ready(function () {

    $.ajax({
        url: "expenseItems.action",
        type: "GET",
        success: function (data) {

            let options = "";

            $.each(data, function (i, item) {
                options += "<option value='" + item.itemId + "'>"
                         + item.itemName + "</option>";
            });

            $("#expenseItem").html(options);
        }
    });

});
</script>