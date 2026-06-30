$(document).ready(function () {

    $.ajax({
        url: "expenseItems.action",
        type: "GET",
        success: function(data) {

            let options = "";

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

            console.log(response);

        }
    });

});

});