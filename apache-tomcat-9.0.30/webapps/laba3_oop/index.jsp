<html>
<body>
<form>
    <label>
        <input type="text" name="nameCar" placeholder="Name car">
    </label>
    <label>
        <input type="text" name="modelCar" placeholder="Model car">
    </label>
    <p><input type="submit" name="click" value="Add new car" onclick="someFunc()"></p>
</form>
<script>
    function someFunc(){
        alert(document.getElementById("nameCar").value);
    }
    document.getElementById("click").onclick = someFunc;
</script>

<button onclick="getCars()">Get list cars</button>
<div id="id01"></div>
<script type="text/javaScript">
    function addCar(nameCar, modelCar) {
        var xhr = new XMLHttpRequest();
        xhr.open('POST', 'test', true);
        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhr.onreadystatechange = function () {
            if (this.readyState === 4 && this.status === 200) {
                var myArr = JSON.parse(this.responseText);
                myFunction2(myArr);
            }
        };
        let car = {
            name: nameCar,
            model: modelCar
        };
        alert(nameCar)
        let json = JSON.stringify(car);
        alert(json);
        xhr.send(json);


        function myFunction2(arr) {
            var out = "";
            var i;
            for (i = 0; i < arr.length; i++) {

                out += '<h3>' + arr[i].name + " " + arr[i].model + '</h3>';
            }
            document.getElementById("id01").innerHTML = out;
        }
    }

    function getCars() {
        var xhr = new XMLHttpRequest();
        xhr.open('GET', 'test', true);
        xhr.onreadystatechange = function () {
            if (this.readyState === 4 && this.status === 200) {
                var myArr = JSON.parse(this.responseText);
                myFunction1(myArr);
            }
        };
        xhr.send();

        function myFunction1(arr) {
            var out = "";
            var i;
            for (i = 0; i < arr.length; i++) {

                out += '<h3>' + arr[i].name + " " + arr[i].model + '</h3>';
            }
            document.getElementById("id01").innerHTML = out;
        }
    }
</script>
</body>
</html>
