$(document).ready(function() {

    $("#saveBtn").click(function() {

        var itemId = $("#expenseItem").val();
        var amount = $("#amount").val();
        var description = $("#description").val();
         $.ajax({

            url: "saveDefaultExpense.action",
            type: "POST",
            data : {
                itemId : itemId,

               amount : amount,

               description : description
        },
        success: function(response) {
                console.log("saved");
            },

        error: function() {
                console.log("error");
            }

        });
       
    });

});