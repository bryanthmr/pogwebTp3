import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class Servlet_Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String message;
        if ("test".equals(username) && "test".equals(password)) {
            message = "Welcome to your First JSP page";
            request.setAttribute("message", message);
            this.getServletContext().getRequestDispatcher("/WEB-INF/resultat.jsp").forward(request, response);
        } else {
            message = "Identification Failure";
            request.setAttribute("message", message);
            this.getServletContext().getRequestDispatcher("/WEB-INF/resultat.jsp").forward(request, response);
        }
    }
}
