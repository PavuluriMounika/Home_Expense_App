$(document).ready(function() {
    
    $("#updateBtn").click(function(){
        var expenseId =$("#expenseId").val();
        var itemId = $("#expenseItem").val();
        var amount = $("#amount").val();
        var description = $("#description").val();
        console.log("expenseId = " + expenseId);
        console.log("itemId = " + itemId);
        console.log("amount = " + amount);
        console.log("description = " + description);
        $.ajax({
            url: "updateExpense.action",
            type: "POST",
            data: {
                expenseId: expenseId,
                itemId: itemId,
                amount: amount,
                description: description
            },
            success:function(response){
                console.log("udpated");
            }
        });
        
        
    });
    $("#cancelBtn").click(function() {

        window.location.href = "expenseList.action";

    });
});