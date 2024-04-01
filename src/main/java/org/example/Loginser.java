package org.example;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class Loginser extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
         String uname = req.getParameter("username");
         String pass = req.getParameter("password");
         JdbcConnection cn = new JdbcConnection();
        try {
            if (cn.verify(uname, pass))
            {
                HttpSession ses = req.getSession();
                ses.setAttribute("username", uname);
                String se = (String)ses.getAttribute("username");
                res.setContentType("text/html");
                res.getWriter().println("<h2>LOGIN SUCESSFULLY</h2>");
                res.getWriter().println("<h2>Welcome! </h2>"+se);
                res.sendRedirect("ack.jsp");
                System.out.println("git");
            }
            else {
                res.setContentType("text/html");
                res.getWriter().println("<h2>INCORRECT USERNAME OR PASSWORD</h2>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
