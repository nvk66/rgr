<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <meta charset="utf-8">
</head>
<body>
<input type="text" id="firstname" value="Ivan">
<input type="text" id="lastname" value="Ivanov">
<input type="text" id="age" value="1">
<input type="text" id="group" value="PIN-191">
<input type="text" id="subject"value="OOP">

<button onclick="load()" id="button">Load</button>

<button onclick="addJson()" id="addbutton">Add</button>
<p>
<div id="text"></div>
</p>

<ul id="list">
    <li></li>
</ul>

<script>

    function addJson(){
        var xhr = new XMLHttpRequest();
        xhr.open('POST','Main');
        var json ='';

        xhr.onreadystatechange = function () {
            if (xhr.readyState != 4) return;
            if (xhr.status != 200) {
                // обработать ошибку
                alert(xhr.status + ': ' + xhr.statusText);
            }
            ;
        }
        json ={ 'name' : document.getElementById("firstname").value ,
            'lastName' : document.getElementById("lastname").value ,
            'age' : document.getElementById("age").value ,
            'group' : document.getElementById("group").value ,
            'subject' : document.getElementById("subject").value } ;
        xhr.send(JSON.stringify(json));
    }

    function load() {

        var xhr = new XMLHttpRequest();

        xhr.open('GET', 'Main', true);

        xhr.onreadystatechange = function () {
            if (xhr.readyState != 4) return;
            if (xhr.status != 200) {
                // обработать ошибку
                alert(xhr.status + ': ' + xhr.statusText);
            } else {
                try {
                    var students = JSON.parse(xhr.responseText);
                } catch (e) {
                    alert("Некорректный ответ " + e.message);
                }
                show(students)
            }
            ;
        }

        xhr.send();

    }

    function show(students) {
        var li = list;
        while(li.firstChild) {
            li.removeChild(li.firstChild);
        }

        students.forEach(function (student) {
            li = list.appendChild(document.createElement('li'));
            li.innerHTML = student.lastName + ' ' + student.firstName + ' ' + student.age + ' ' + student.group + ' ' +
                student.subject;
        });


    }
</script>
</body>
</html>