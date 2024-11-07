import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/solveEquation")
public class SolveEquationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double a = Double.parseDouble(request.getParameter("a"));
        double b = Double.parseDouble(request.getParameter("b"));
        double c = Double.parseDouble(request.getParameter("c"));

        double discriminant = Math.pow(b, 2) - 4 * a * c;
        String result;

        if (discriminant < 0) {
            result = "<span style='color: red;'>Pas de racines réelles</span>";
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            result = "<span style='color: blue;'>Racine double: x = " + root + "</span>";
        } else {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            result = "<span style='color: green;'>Racines: x1 = " + root1 + ", x2 = " + root2 + "</span>";
        }

        request.setAttribute("result", result);
        this.getServletContext().getRequestDispatcher("/WEB-INF/resultat2.jsp").forward(request, response);
    }
}
