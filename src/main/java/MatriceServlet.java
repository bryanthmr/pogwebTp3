import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/matrix")
public class MatriceServlet extends HttpServlet {
    private int[][] matrix = new int[10][10]; // Initialisation de la matrice de 10x10

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String xParam = request.getParameter("x");
        String yParam = request.getParameter("y");

        if (xParam != null && yParam != null) {
            try {
                int x = Integer.parseInt(xParam);
                int y = Integer.parseInt(yParam);
                if (x >= 0 && x < 10 && y >= 0 && y < 10) {
                    out.println("<p>Valeur à la position (" + x + ", " + y + ") : " + matrix[x][y] + "</p>");
                } else {
                    out.println("<p style='color:red;'>Erreur : Coordonnées hors des limites de la matrice.</p>");
                }
            } catch (NumberFormatException e) {
                out.println("<p style='color:red;'>Erreur : Paramètres non valides.</p>");
            }
        } else {
            out.println("<table border='1'>");
            for (int i = 0; i < 10; i++) {
                out.println("<tr>");
                for (int j = 0; j < 10; j++) {
                    out.println("<td>" + matrix[i][j] + "</td>");
                }
                out.println("</tr>");
            }
            out.println("</table>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String xParam = request.getParameter("x");
        String yParam = request.getParameter("y");
        String valParam = request.getParameter("val");

        if (xParam == null && yParam == null && valParam == null) {
            // Réinitialiser la matrice si la requête POST est sans paramètres
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    matrix[i][j] = 0;
                }
            }
        } else {
            try {
                int x = Integer.parseInt(xParam);
                int y = Integer.parseInt(yParam);
                int val = Integer.parseInt(valParam);

                if (x >= 0 && x < 10 && y >= 0 && y < 10) {
                    matrix[x][y] = val;
                }
            } catch (NumberFormatException | NullPointerException e) {
                response.getWriter().println("<p style='color:red;'>Erreur : Paramètres non valides ou manquants.</p>");
            }
        }
        response.sendRedirect("matrix");
    }
}
