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
  <button onclick=TFun()>Register</button>
  <script>
    function TFun(){
      registerClient(document.getElementById('nameClient').value, document.getElementById('lastNameClient').value,
              document.getElementById('numberClient').value);
    }
  </script>

  </body>
</html>
