<%@ page language="java" import="java.sql.ResultSet" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Show Employee Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f0f0f0;
        }
        .container {
            width: 80%;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 10px;
            border-bottom: 1px solid #ddd;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Employee Details</h1>
        <table>
            <thead>
                <tr>
                    <th>Employee Name</th>
                    <th>Employee ID</th>
                    <th>Department</th>
                    <th>Salary</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <%
                ResultSet rs = (ResultSet) request.getAttribute("result");
                if (rs != null && rs.next()) { // Check if ResultSet is not null and has records
                    do {
                %>
                <tr>
                    <td><%= rs.getString("emp_name") %></td>
                    <td><%= rs.getInt("emp_id") %></td>
                    <td><%= rs.getString("emp_dept") %></td>
                    <td><%= rs.getString("emp_salary") %></td>
                    <td>
                        <form method="post" action="deleteEmployeeServlet">
                            <input type="hidden" name="emp_id" value="<%= rs.getInt("emp_id") %>">
                            <input type="submit" value="Delete">
                        </form>
                    </td>
                </tr>
                <%
                    } while (rs.next());
                } else {
                %>
                <tr>
                    <td colspan="5">No details</td>
                </tr>
                <%
                }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
