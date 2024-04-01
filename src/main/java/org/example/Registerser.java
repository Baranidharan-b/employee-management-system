package org.example;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/reg")
public class Registerser extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String fname = req.getParameter("fullName");
        String email = req.getParameter("email");
        String uname = req.getParameter("username");
        String pass = req.getParameter("password");
        JdbcConnection cn = new JdbcConnection();
        try {
            cn.register(fname, email, uname, pass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        res.setContentType("text/html");
        res.getWriter().println("<h2>REGISTRED SUCESSFULLY</h2>");


    }

}
