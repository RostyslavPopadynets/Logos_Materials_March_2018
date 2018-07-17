const urlSeparator = '/';
const rootUrl = 'http://localhost:8080/api';
const teachersUrl = urlSeparator + 'teachers';

$(document).ready(function () {

    getTeachers();

    $('#showTeacherForm').on('click', function () {
        $('#teacherForm').toggle("show");
    });

    $('#showTeachersTable').on('click', function() {
        $('#teachersTable').toggle("show");
    });

    $('#teacherForm .btn').on('click', function (e) {
        addTeacher(e);
    });

    $(document).on('click', '#teachersTable tbody button', function (e) {
        let value = $(this).val();
        let operation = $(this).data('id');
        console.log(operation + ' ' + value);

        switch (operation) {
            case "delete":
                deleteTeacher(value);
                break;

            case "details":
                teacherDetails(value);
                break;

            case "edit":
                editTeacher(value);
                break;
        }

    })
});

function getTeachers() {
    $.ajax({
        url: rootUrl + teachersUrl,
        method: 'GET',
        dataType: 'json',
        success: function (result) {
            $("#teachersTable tbody").empty();
            if (result.length < 0) {
                $('#teachersTable').empty();
            }

            $.each(result, function (key, value) {
                $("#teachersTable tbody").append(
                    '<tr>' +
                    // '<td>' + value.teacherId + '</td>' +
                    '<td>' + value.firstName + '</td>' +
                    '<td>' + value.lastName + '</td>' +
                    '<td>' + value.email + '</td>' +
                    '<td>' +
                    '<button class="btn btn-sm btn-info" data-id="details" value="' + value.teacherId + '">Details</button></td>' +
                    '<td>' +
                    '<button class="btn btn-sm btn-primary" data-id="edit" value="' + value.teacherId + '">edit</button>' +
                    ' ' +
                    '<button class="btn btn-sm btn-danger" data-id="delete" value="' + value.teacherId + '">delete</button>' +
                    '</td>' +
                    '</tr>'
                    // '<td>' +
                    // '<button class="btn btn-sm btn-info" data-id="details" value="' + value.teacherId + '">Create course</button></td>' +
                    // '</tr>'
                )
            });
        }
    })
}

function addTeacher(e) {
    e.preventDefault();
    // let serializedForm = $('#teacherForm').serializeArray().reduce(function (a, x) {
    //     a[x.name] = x.value;
    //     return a;
    // }, {});
    // console.log(serializedForm);
    let fName = $('#firstName').val();
    let lName = $('#lastName').val();
    let email = $('#email').val();
    let age = $('#age').val();
    let description = $('#description').val();

    if (fName === "" || fName === null,
        lName === "" || lName === null,
        email === "" || email === null,
        age === "" || age === null,
        description === "" || description === null) {
        $('#result').text('Fields cant be empty').css("color", "red");
        return;
    }

    $.ajax({
        url: rootUrl + teachersUrl,
        method: 'POST',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify({
            "firstName": fName,
            "lastName": lName,
            "email": email,
            "age": age,
            "description": description
        }),
        // headers: {
        //     'Accept': 'application/json',
        //     'Content-Type': 'application/json'
        // },
        complete: function (data) {
            $('#teacherForm')[0].reset();
            getTeachers();
        }
    })
}

function deleteTeacher(teacherId) {
    console.log('Delete');
    let result = confirm('Do you really gonna delete this user?');
    if (result) {
        $.ajax({
            url: rootUrl + teachersUrl + urlSeparator + teacherId,
            method: 'DELETE',
            success: function () {
                getTeachers();
            }
        })
    }
}

function editTeacher(teacherId) {
    console.log('Edit');
}

function teacherDetails(teacherId) {
    console.log('Details');
}