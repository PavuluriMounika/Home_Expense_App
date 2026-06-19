<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="js/defaultExpense.js"></script>
<h2>Default Expense Entry</h2>

<div>
    <label>
        <s:property value="labels['label.expense.item']"/>
    </label>
    <br/>
    
    <select id="expenseItem">
        <option>Loading...</option>
    </select>
</div>

<br/>

<div>
    <label>
        <s:property value="labels['label.amount']"/>
    </label>
    <br/>

    <input type="text" id="amount"/>
</div>

<br/>

<div>
    <label>
        <s:property value="labels['label.description']"/>
    </label>
    <br/>

    <textarea id="description" rows="3" cols="30"></textarea>
</div>

<br/>

<div>
    <button type="button" id="saveBtn">
        <s:property value="labels['button.save']"/>
    </button>

    <button type="button" id="saveNewBtn">
        <s:property value="labels['button.save.new']"/>
    </button>

    <button type="reset" id="resetBtn">
        <s:property value="labels['button.reset']"/>
    </button>
</div>

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