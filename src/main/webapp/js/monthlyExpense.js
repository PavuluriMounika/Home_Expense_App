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

            $("#monthlyExpenseBody tr").each(function() {

                let food = $(this).find(".foodValue").val();
                let item = $(this).find(".itemValue").val();
                let amount = $(this).find(".amountValue").val();
                let description = $(this).find(".descriptionValue").val();

                let object = {
                    food: food,
                    item: item,
                    amount: amount,
                    description: description
                };

                expenseList.push(object);
            });

            console.log(expenseList);

        });

});