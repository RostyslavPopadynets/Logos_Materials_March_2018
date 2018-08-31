let serverUrl = 'http://localhost:8080/';
$(document).ready(function() {
    getCategories();
    $('#addCategoryForm').submit(function(e) {
        e.preventDefault();

        let name = $('#name').val();
        let description = $('#description').val();

        let category = {
            name: name,
            description: description
        };

        $.ajax({
            url: serverUrl + 'categories',
            method: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(category),
            complete: function(data) {
                if(data.status == 500) {
                    console.log('Error has occured');
                }
                if(data.status == 201) {
                    $('#addCategoryForm')[0].reset();
                    $('#categoriesTable tbody').empty();
                    getCategories();
                }
            }
        })
    });
});

function getCategories() {
    $.ajax({
        url: serverUrl + 'categories',
        method: 'GET',
        dataType: 'JSON',
        contentType: 'application/json',
        success: function(response) {
            console.log(response);
            $.each(response, function(key, value) {
                $('#categoriesTable tbody').append(
                    `
                    <tr>
                        <td>${ value.categoryId }</td>
                        <td>${ value.name }</td>
                        <td>${ value.description }</td>
                    </tr>
                    `
                );
            })
        }
    })
}