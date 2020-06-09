<%--
  Created by IntelliJ IDEA.
  User: Алексей
  Date: 5/20/2020
  Time: 10:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script src="scripts.js"></script>
    <style>
        body {
            background-color: coral;
        }
    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="alert alert-warning alert-dismissible fade show">
  <button type="button" class="close" data-dismiss="alert">×</button>
  <strong>Warning!</strong> Welcome to the FakeTAXI
</div>
<p>
<p>
<div class="container-fluid">
    <div class="container">
        <div class="row">
            <input type="text" id="nameClient" placeholder=" Name">
            <input type="text" id="lastNameClient" placeholder="Last name">
            <input type="text" id="numberClient" placeholder="Phone Number">
            <button type="button" class="btn btn-primary" onclick=registerC()>Register</button>
        </div>
    </div>
</div>
<p>
<p>
<p>
    <script>
        function registerC() {
            registerClient(document.getElementById('nameClient').value, document.getElementById('lastNameClient').value,
                document.getElementById('numberClient').value)
        }

        function registerD() {
            registerDriver(document.getElementById('nameDriver').value, document.getElementById('lastNameDriver').value,
                document.getElementById('carModel').value, document.getElementById('numberCar').value,
                document.getElementById('carColour').value)
        }

        function addOrder() {
            addOrders(document.getElementById('nameClientOrder').value, document.getElementById('startLocationOrder').value,
                document.getElementById('endLocationOrder').value)
        }

        function show() {
            getOrders(document.getElementById('name').value, document.getElementById('list'))
        }

    </script>
<div class="container-fluid">
    <div class="container">
        <div class="row">
            <input type="text" id="nameDriver" placeholder="Name">
            <input type="text" id="lastNameDriver" placeholder="Last name">
            <input type="text" id="numberCar" placeholder="Car Number">
            <input type="text" id="carModel" placeholder="Car model">
            <input type="text" id="carColour" placeholder="Colour">
            <button type="button" class="btn btn-primary" onclick=registerD()>RegisterDriver</button>
        </div>
    </div>
</div>
<p>
<p>
<p>
<div class="container-fluid">
    <div class="container">
        <div class="row">
            <input type="text" id="nameClientOrder" placeholder="Name">
            <input type="text" id="startLocationOrder" placeholder="From">
            <input type="text" id="endLocationOrder" placeholder="To">
            <button type="button" class="btn btn-warning" onclick=addOrder()>addOrder</button>
        </div>
    </div>
</div>
<p>
<p>
<p>
<div class="container-fluid">
    <div class="container">
        <div class="row">
            <input type="text" id="name" placeholder="Name">
            <button type="button" class="btn btn-danger" onclick=show()>getOrders</button>

        </div>
    </div>
</div>
<p><ul id="list"></ul>
</body>
</html>
