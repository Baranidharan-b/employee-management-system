package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.LogManager;


@WebServlet("/showRes")
public class show extends HttpServlet {
    Logger log= LoggerFactory.getLogger(show.class);
  //  java.util.logging.Logger li = (java.util.logging.Logger) LoggerFactory.getLogger(show.class);
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ResultSet rs= null;
        try {
            HttpSession ses = req.getSession();
            String uname = (String) ses.getAttribute("username");
            rs = JdbcConnection.fetchdata(uname);
            log.info("JDBC conected");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        req.setAttribute("result",rs);
        RequestDispatcher red = req.getRequestDispatcher("Show.jsp");
        red.forward(req,res);

    }
}
