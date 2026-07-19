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
                                <td>
                                    <input class="foodValue" value="${expense.expenseId}">
                                </td>

                                <td>
                                    <input class="itemValue" value="${expense.itemId}">
                                </td>

                                <td>
                                    <input class="amountValue" value="${expense.amount}">
                                </td>

                                <td>
                                    <input class="descriptionValue" value="${expense.description}">
                                </td>
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
        $("#addRowBtn").click(function(){
            let row = "";
            row = `
                <tr>
                    <td>
                        <input class="foodValue">
                    </td>

                    <td>
                        <input class="itemValue">
                    </td>

                    <td>
                        <input class="amountValue">
                    </td>
                    <td>
                        <input class="descriptionValue">
                    </td>
                </tr>
                `;
            $("#monthlyExpenseBody").append(row);

        });
        $("#saveBtn").click(function() {

        let expenseList = [];

        $("#monthlyExpenseBody tr").each(function () {

            let item = $(this).find(".itemValue").val();
            let amount = $(this).find(".amountValue").val();
            let description = $(this).find(".descriptionValue").val();

            if(item !== "" && amount !== ""){

                expenseList.push({
                    itemId: item,
                    amount: amount,
                    description: description,
                    expenseYear: $("#yearId").val(),
                    expenseMonth: $("#monthId").val(),
                    activeFlag: "Y"
                });
            }
        });

        console.log("Expense List:");
        console.log(expenseList);

        $.ajax({

            url: "saveMonthlyExpenses.action",
            type: "POST",

            data: {
                expenseList: JSON.stringify(expenseList)
            },

            success: function(response) {
                console.log("Saved Successfully!");
            },

            error: function(error) {
                console.log("Error:");
                console.log(error);
            }

        });

    });

});