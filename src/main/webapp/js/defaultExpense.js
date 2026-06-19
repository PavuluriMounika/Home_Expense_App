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
});