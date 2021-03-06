package ca.sait.mylogin.servlets;
import ca.sait.mylogin.models.User;
import ca.sait.mylogin.services.AccountService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet 
{
      @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        
        if(session.getAttribute("username") != null) 
        {
             String query = request.getQueryString();
        
            if(query != null && query.contains("logout")) 
            {
                session.invalidate();
                
                request.setAttribute("message", "You have successfully logged out.");
            }
            else 
            {
                response.sendRedirect("home");
                return;
            }
        }
            
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

    }    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if(username == null || username.isEmpty()|| password == null || password.isEmpty()) 
        {
            request.setAttribute("message", "Your username or password is missing.");            
        }
        else 
        {
            AccountService account = new AccountService();
            User user = account.login(username, password);
            
            if(user != null) 
            {
                request.getSession().setAttribute("username", username);
                
                response.sendRedirect("home");
                return;
            }
            else 
            {
                request.setAttribute("username", username);
                request.setAttribute("message", "Your username or password is invalid.");
            }
        }   
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

}
