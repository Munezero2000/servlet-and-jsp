import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(urlPatterns = {"/createAccount"})
public class AuthenitcationServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
        String email = req.getParameter("email");
        String role = req.getParameter("user");
        String password = req.getParameter("psw");
        if(!email.isEmpty() && !password.isEmpty()){
            Cookie userEmail =  new Cookie("email", email);
            userEmail.setMaxAge(60*60*20);
            Cookie userRole = new Cookie("userRole", role);
            userRole.setMaxAge(60*60*24);
            Cookie userPassword = new Cookie("userPassword", password);
            
            res.addCookie(userEmail);
            res.addCookie(userRole);
            res.addCookie(userPassword);
            
            res.sendRedirect("login.html");
        }
    }
}
