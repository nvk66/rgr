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
  </head>
  <body>
  <input type="text" id="nameClient">
  <input type="text" id="lastNameClient">
  <input type="text" id="numberClient">
  <button onclick=registerC()>Register</button>
  <script>
    function registerC(){
      registerClient(document.getElementById('nameClient').value, document.getElementById('lastNameClient').value,
              document.getElementById('numberClient').value)
    }

    function registerD() {
      registerDriver(document.getElementById('nameDriver').value,document.getElementById('lastNameDriver').value,
              document.getElementById('numberCar').value,document.getElementById('carModel').value,
              document.getElementById('carColour').value)
    }

  </script>

  <input type="text" id="nameDriver">
  <input type="text" id="lastNameDriver">
  <input type="text" id="numberCar">
  <input type="text" id="carModel">
  <input type="text" id="carColour">
  <button onclick=registerD()>RegisterDriver</button>
  </body>
</html>
