/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author magtech
 */
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String email = req.getParameter("uname");
        String password = req.getParameter("psw");
        Boolean authenticated = Boolean.FALSE;
        if(!email.isEmpty() && !password.isEmpty()){
            Cookie[] cookies = req.getCookies();
            if(cookies != null){
               for(Cookie cookie : cookies){
                   if(cookie.getValue().equalsIgnoreCase(email)){
                       authenticated = Boolean.TRUE;
                   }
                       
               }
               if(authenticated){
                   res.sendRedirect("HomePage.html");
               }else{
                       PrintWriter out = res.getWriter();
                       out.println("<h1>Invalid email and password</h1>");
                       req.getRequestDispatcher("login.html").include(req, res);
               }
            }
              else{
                res.sendRedirect("register.html");
            }
        }
    }
}
