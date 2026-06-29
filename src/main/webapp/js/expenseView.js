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
    
    $("#deleteBtn").click(function(){
        var expenseId = $("#expenseId").val();
        
        if (confirm("Are you sure you want to delete this expense?")) {
            
            $.ajax({
                url : "deleteExpense.action",
                type: "POST",
                data : {
                    expenseId : expenseId
                },
                success: function(response){
                    console.log("deleted");
                     window.location.href = "expenseList.action";
                }
                
            });
            
        }
        
    });
    $("#searchBtn").click(function () {

        var itemId = $("#expenseItem").val();

        $.ajax({

           url: "searchItem.action",

            type: "GET",

            data: {
                     itemId: itemId
            },

            success: function(response) {

                console.log(response);

            }

        });

    });
    
    
    
});