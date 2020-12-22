import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/acc")
public class MyAccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") != null) {
            User user = (User) req.getSession().getAttribute("user");
            resp.getWriter().println("id:" + user.getId());
            resp.getWriter().println("name:" + user.getName());
            resp.getWriter().println("login:" + user.getLogin());
            resp.getWriter().println("password:" + user.getPassword());
        } else {
            resp.getWriter().println("You have not authorized!");
        }
    }
}
