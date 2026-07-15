$(document).ready(function () {
    let isTableVisible = false;
    
    $("#loadBtn").click(function(){
        var year = $("#yearId").val();
        var month = $("#monthId").val();
        let rows = "";
        if(isTableVisible){
           $("#monthlyExpenseTable").hide();
            isTableVisible = false;
            $(this).text("Load Default Expenses");
            return;
            
        }
        
        $.ajax({

                url: "loadDefaultExpenses.action",
                type: "GET",

                data: {
                    year: year,
                    month: month
                },
                success: function(response){
                    $.each(response,function(i,expense){
                        rows += `
                            <tr>
                                <td>${expense.expenseId}</td>
                                <td>${expense.itemId}</td>
                                <td>${expense.amount}</td>
                                <td>${expense.description}</td>
                            </tr>
                            `;

                    });
                    $("#monthlyExpenseBody").html(rows);
                    isTableVisible = true;
                     $("#monthlyExpenseTable").show();
                    $("#loadBtn").text("Hide Default Expenses");
                    
                    console.log(response);

                }

            });
            

        });

});