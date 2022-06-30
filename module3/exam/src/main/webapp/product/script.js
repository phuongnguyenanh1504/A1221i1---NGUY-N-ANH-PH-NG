$(document).ready(function () {
    // Tao filter
    $("#myInput").on("keyup", function () {
        if ($("#selectValue").val() == "All") {
            var value = $(this).val().toLowerCase();
            $("#myTable tr").filter(function () {
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            });
        } else {
            myFunction();
        }
    });

    function myFunction() {
        var input, filter, selectValue, table, tr, td, i, txtValue, index;
        selectValue = document.getElementById("selectValue").value;
        input = document.getElementById("myInput");
        filter = input.value.toUpperCase();
        table = document.getElementById("myTable");
        tr = table.getElementsByTagName("tr");
        switch (selectValue) {
            case "name":
                index = 1;
                break;
            case "price":
                index = 2;
                break;
            case "quantity":
                index = 3;
                break;
            case "color":
                index = 4;
                break;
            case "category":
                index = 5;
                break;
        }
        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[index];
            if (td) {
                txtValue = td.textContent || td.innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    };
    // tao button edit
    $('.btn-edit').click(function () {
        let id = $(this).data("id");
        let name = $(this).data("name");
        let price = $(this).data("price");
        let quantity = $(this).data("quantity");
        let color = $(this).data("color");
        let category = $(this).data("category");
        $("#product_id").val(id);
        $("#product_name").val(name);
        $("#product_price").val(price);
        $("#product_quantity").val(quantity);
        $("#product_color").val(color);
        $("#product_category").val(category);
    });
    $('.confirm-edit').click(function () {
        $('#form_edit').attr("action", "/product?action=edit&id=" + id);
    })
    // Tao function delete
    $('.btn-delete').click(function () {
        let id = $(this).data("id");
        $('.btn-confirm-delete').attr("href", "/product?action=delete&id=" + id);
    })
    $('.btn-search').click(function () {
        let key = $('#select-sort').val();
        let value = $('#input-search').val();
        $('.btn-search').attr('href', '/product?action=search&key=' + key + '&value=' + value);
    })
});