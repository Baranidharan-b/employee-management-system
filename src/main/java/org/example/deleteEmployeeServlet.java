package org.example;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet ("/deleteEmployeeServlet")

public class deleteEmployeeServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        JdbcConnection cn = new JdbcConnection();
        try {
            System.out.println(req.getParameter("emp_id"));
            cn.delete(Integer.parseInt(req.getParameter("emp_id")));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        res.sendRedirect("showRes");
    }
}
