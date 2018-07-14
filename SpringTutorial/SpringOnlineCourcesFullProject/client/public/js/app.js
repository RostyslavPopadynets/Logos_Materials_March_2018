$(document).ready(function () {

    const urlSeparator = '/';
    const rootUrl = 'http://localhost:8080/api';
    const teachersUrl = urlSeparator + 'teachers';

    getTeachers();

    function getTeachers() {
        $.ajax({
            url: rootUrl + teachersUrl,
            method: 'GET',
            dataType: 'json',
            success: function (result) {
                console.log(result);

                $.each(result, function (key, value) {
                    $("#teachersTable tbody").append(
                        '<tr>' +
                        // '<td>' + value.teacherId + '</td>' +
                        '<td>' + value.firstName + '</td>' +
                        '<td>' + value.lastName + '</td>' +
                        '<td>' + value.email + '</td>' +
                        '<td>' +
                        '<button class="btn btn-sm btn-primary" value="' + value.teacherId + '">edit</button>' +
                        ' ' +
                        '<button class="btn btn-sm btn-danger" value="' + value.teacherId + '">delete</button>' +
                        '</td>' +
                        '<td>' +
                        '<button class="btn btn-sm btn-info" value="' + value.teacherId + '">Details</button></td>' +
                        '</tr>'
                    )
                });
            }
        })
    }

    $(document).on('click', 'button', function (e) {
        console.log($(this).val());
    })

    $('#teacherForm .btn').on('click', function (e) {
        e.preventDefault();

        let serializedForm = $('#teacherForm').serializeArray().reduce(function (a, x) {
            a[x.name] = x.value;
            return a;
        }, {});
        console.log(serializedForm);

        $.ajax({
            url: rootUrl + teachersUrl,
            method: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(serializedForm),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            complete: function (data) {
                getTeachers();
            }
        })
    })

    // $('button').on('click', function(e) {
    //     console.log('sdf');
    // })

});