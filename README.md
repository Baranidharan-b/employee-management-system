# Employee Management System

This is a simple Employee Management System built with Java. It provides functionalities for user authentication (login/register), adding/viewing employees, and performing CRUD operations on a database using JDBC.

## Features

- User Authentication:
  - Login Page: Users can log in using their credentials.
  - Register Page: New users can create an account by providing necessary details.

- Employee Management:
  - Add Employee: Logged-in users can add new employees to the system by providing their details.
  - View Employee: Users can view the list of employees in the system.

## Database Operations

The system uses JDBC for database operations, including CRUD (Create, Read, Update, Delete) operations on employee data.

## Technologies Used

- Java
- JDBC (Java Database Connectivity)
- HTML/CSS (for frontend pages)

## Setup

1. **Database Configuration**:
   - Install and configure your preferred relational database management system (e.g., MySQL, PostgreSQL).
   - Create a database named `employee_management`.
   - Create tables `users` and `employees` with necessary fields.

2. **Database Connection**:
   - Update `db.properties` file with your database credentials.

3. **Running the Application**:
   - Compile and run the Java application.
   - Access the application through your web browser.

## Project Structure

- `src/` : Contains the Java source files.
- `web/` : Contains the HTML/CSS files for the frontend pages.
- `db.properties` : Database configuration file.

## Usage

1. **Login/Register**:
   - Navigate to the login/register page.
   - Login with existing credentials or register as a new user.

2. **Add Employee**:
   - After logging in, navigate to the add employee page.
   - Enter the details of the employee and submit the form.

3. **View Employees**:
   - Users can view the list of employees after logging in.
   - The list displays all the employees stored in the database.

4. **CRUD Operations**:
   - Users can perform CRUD operations on employee data, including create, read, update, and delete.

## Contributing

Contributions are welcome! Please feel free to fork this repository, make changes, and submit a pull request.

https://github.com/Baranidharan-b/employee-management-system.git
