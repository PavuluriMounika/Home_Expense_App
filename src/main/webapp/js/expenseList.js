$(document).ready(function () {

    $.ajax({
        url: "expenseItems.action",
        type: "GET",
        success: function(data) {

            let options = "<option value='0'>All</option>";

            $.each(data, function(i, item) {
                options += "<option value='" + item.itemId + "'>"
                         + item.itemName + "</option>";
            });

            $("#expenseItem").html(options);
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
            let rows = "";
            $.each(response,function(i,expense){
                console.log(rows);
                rows += `
                    <tr>
                        <td>
                            <a href="expenseView.action?expenseId=${expense.expenseId}">
                                ${expense.expenseId}
                            </a>
                        </td>
                        <td>${expense.itemId}</td>
                        <td>${expense.amount}</td>
                        <td>${expense.description}</td>
                    </tr>`;
                
            });

            console.log(response);
            
            $("#expenseTableBody").html(rows);
        }
    });

    });
    $("#exportType").change(function () {

        console.log("PDF selected");

        var exportType = $(this).val();

        if (exportType === "pdf") {
            window.open("exportPdf.action", "_blank");
        }

    });

});