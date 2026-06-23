$(document).ready(function() {

    function saveExpense(clearForm) {

    var itemId = $("#expenseItem").val();
    var amount = $("#amount").val();
    var description = $("#description").val();

    $.ajax({
        url: "saveDefaultExpense.action",
        type: "POST",
        data: {
            itemId: itemId,
            amount: amount,
            description: description
        },
        success: function() {
            console.log("saved");
            if (clearForm) {
                console.log("cleared");
                $("#expenseItem").prop("selectedIndex", 0);
                $("#amount").val("");
                $("#description").val("");
            }
        }
    });
    }
    $("#saveBtn").click(function() {
        saveExpense(false);
    });
    $("#saveNewBtn").click(function() {
        saveExpense(true);
    });
    $("#resetBtn").click(function() {

        $("#expenseItem").prop("selectedIndex", 0);
        $("#amount").val("");
        $("#description").val("");

    });
   
    // Load Expense Items Dropdown
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

            // Load expense for edit
            const expenseId = new URLSearchParams(window.location.search)
                    .get("expenseId");

            if (expenseId) {

                $.ajax({
                    url: "loadExpense.action",
                    type: "GET",
                    data: {
                        expenseId: expenseId
                    },
                    success: function (expense) {

                        console.log(expense);

                        $("#expenseItem").val(expense.itemId);
                        $("#amount").val(expense.amount);
                        $("#description").val(expense.description);
                    }
                });
            }
        }
    });


});