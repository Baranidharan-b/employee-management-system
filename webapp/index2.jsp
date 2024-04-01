<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f0f0f0;
        }
        .container {
            width: 50%;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
        }
        h2 {
            text-align: center;
            margin-top: 0;
        }
        .welcome {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border-radius: 8px;
            margin-bottom: 20px;
            text-align: center;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"], button.show-button {
            background-color: #4CAF50;
            color: white;
            padding: 7px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            margin-top: 10px;
        }
        input[type="submit"]:hover, button.show-button:hover {
            background-color: #45a049;
        }
        .warning {
            color: red;
            font-size: 14px;
            margin-top: 5px;
        }
    </style>
</head>
<body>
<%
HttpSession ses = request.getSession();
%>

<div class="welcome">
    <h1>Welcome <%= ses.getAttribute("username") %></h1>
</div>

<div class="container">
    <h1>Employee Details</h1>
    <form action="/Edetials" method="POST" onsubmit="return validateForm()">
        <label for="emp_name">Employee Name:</label>
        <input type="text" id="emp_name" name="emp_name" placeholder="Enter employee name">
        <div id="name-warning" class="warning"></div>

        <label for="emp_id">Employee ID:</label>
        <input type="text" id="emp_id" name="emp_id" placeholder="Enter employee ID">

        <label for="emp_dept">Department:</label>
        <input type="text" id="emp_dept" name="emp_dept" placeholder="Enter employee department">

        <label for="emp_salary">Salary:</label>
        <input type="text" id="emp_salary" name="emp_salary" placeholder="Enter employee salary">

        <input type="submit" value="Submit">
    </form>
    <!-- Added Show Employees button -->
    <form action="\showRes" method="GET">
        <button class="show-button">Show Employees</button>
    </form>
</div>

<script>
    function validateForm() {
        var nameInput = document.getElementById("emp_name").value;
        var containsNumber = /\d/.test(nameInput);
        var warning = document.getElementById("name-warning");

        if (containsNumber) {
            warning.innerHTML = "Employee name should not contain numbers.";
            return false;
        } else {
            warning.innerHTML = "";
            return true;
        }
    }
</script>

</body>
</html>
