<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Portal</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #eaeaea;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            width: 90%;
            max-width: 500px;
            background-color: #ffffff;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        h1 {
            font-size: 2.5rem;
            color: #333;
            margin-bottom: 30px;
        }
        .status-message {
            background-color: #48c774;
            color: white;
            padding: 15px;
            border-radius: 8px;
            margin-bottom: 30px;
        }
        .welcome-message {
            font-size: 1.5rem;
            margin-bottom: 30px;
            color: #333;
        }
        .button-container {
            display: grid;
            grid-template-columns: repeat(2, 1fr);
            gap: 20px;
        }
        .button {
            background-color: #3273dc;
            color: white;
            padding: 15px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-size: 1rem;
            text-decoration: none;
            transition: background-color 0.3s ease;
        }
        .button:hover {
            background-color: #275ba7;
        }
        .footer {
            background-color: #232323;
            color: #f5f5f5;
            padding: 15px;
            position: absolute;
            bottom: 0;
            left: 0;
            width: 100%;
            text-align: center;
            font-size: 0.9rem;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Employee Portal</h1>
        <div class="status-message">Access Granted</div>
        <div class="welcome-message">Hello, Employee!</div>
        <div class="button-container">
            <a href="index2.jsp" class="button">Add Employee</a>
            <a href="/showRes" class="button">View Employees</a>
        </div>
    </div>
    <div class="footer">
        © 2024 Employee Portal. All Rights Reserved.
    </div>
</body>
</html>
