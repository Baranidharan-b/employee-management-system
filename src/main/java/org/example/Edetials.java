package org.example;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet ("/Edetials")

public class Edetials  extends HttpServlet {
public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

    String name = req.getParameter("emp_name");
    int id = Integer.parseInt(req.getParameter("emp_id"));
    String dept = req.getParameter("emp_dept");
    int sal = Integer.parseInt(req.getParameter("emp_salary"));
    HttpSession ses = req.getSession();
    String uname = (String) ses.getAttribute("username");
    System.out.println(uname);
    JdbcConnection je = new JdbcConnection();
    je.con(id,name,dept,sal,uname);

    //response
   res.setContentType("text/html");
    res.getWriter().println("<h2>REGISTRED SUCESSFULLY</h2>");
   // res.getWriter().println("<p><br> NAME :" + name + "</br><br> ID :" + id + "</br><br> DEPARTMENT:"+ dept+ "<br> SALARY:" + sal +"</br></p>");

}
}
