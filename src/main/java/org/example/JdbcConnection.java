package org.example;

import java.sql.*;


public class JdbcConnection {
    private static Connection getcon;
//    Edetials en = new Edetials();

    public static Connection getcon() {
        Connection  connection;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db1", "postgres", "password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public void con(int id, String name, String dept, int sal , String uname) {
        try {

            Connection connection = JdbcConnection.getcon();
//            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db1", "postgres","password");
            PreparedStatement pst = connection.prepareStatement("INSERT INTO "+uname+" VALUES (?,?,?,?);");
            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setString(3, dept);
            pst.setInt(4, sal);
            pst.execute();
//            while(re.next())
//                    {
//                        System.out.println(re.getString(1));
//                    }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    static JdbcConnection cn = new JdbcConnection();

    public static ResultSet fetchdata(String uname) throws SQLException {
        Connection connection = JdbcConnection.getcon();
        PreparedStatement pst = connection.prepareStatement("select * from " + uname+ ";");
        System.out.println(uname);
        return pst.executeQuery();
    }

    public void delete(int emp_id) throws SQLException {
        Connection connection = JdbcConnection.getcon();
        System.out.println(emp_id);
        PreparedStatement pst = connection.prepareStatement("delete from employees where emp_id =?;");
        pst.setInt(1, emp_id);
        pst.executeUpdate();


    }

    public void register(String name, String email, String uname, String pass) throws SQLException {
        Connection con = JdbcConnection.getcon();

        // Dynamically create the SQL string for creating the table
        String createTableSQL = "CREATE TABLE " + uname + " (\n" +
                "    emp_id SERIAL PRIMARY KEY,\n" +
                "    emp_name VARCHAR(50),\n" +
                "    emp_dept VARCHAR(50),\n" +
                "    emp_salary NUMERIC(10, 2)\n" +
                ");";

        // Execute the CREATE TABLE statement
        PreparedStatement pst1 = con.prepareStatement(createTableSQL);
        pst1.execute();

        // Insert user information into 'users' table
        PreparedStatement pst = con.prepareStatement("INSERT INTO users VALUES (?,?,?,?)");
        pst.setString(1, name);
        pst.setString(2, email);
        pst.setString(3, uname);
        pst.setString(4, pass);
        pst.execute();
    }


    public boolean verify(String uname, String pass) throws SQLException {
        Connection con = JdbcConnection.getcon();
        Statement stmt = null;
        ResultSet rs = null;
        boolean isAuthenticated = false;
        // Execute query to retrieve password for the given username
        stmt = con.createStatement();
        String sql = "SELECT password FROM users WHERE username = '" + uname + "'";
        rs = stmt.executeQuery(sql);

        // Check if username exists
        if (rs.next()) {
            // Retrieve the stored password from the result set
            String storedPassword = rs.getString("password");

            // Verify the provided password with the stored password
            if (storedPassword.equals(pass)) {
                isAuthenticated = true;
            }
        }
        return isAuthenticated;
    }
}
