<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Expense</title>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="js/expenseView.js"></script>
    <script src="js/defaultExpense.js"></script>

</head>

<body>

    <h2>Edit Expense</h2>

    <input type="hidden" id="expenseId"/>

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
        <button type="button" id="updateBtn">
            Update
        </button>

        <button type="button" id="cancelBtn">
            Cancel
        </button>
        <button type="button" id="deleteBtn">
            Delete
        </button>
    </div>

</body>
</html>