import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/auth")
public class AuthorizationServlet extends HttpServlet {

    private InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if(inMemoryUserStorage.users.size() > 0 && inMemoryUserStorage.isAuthorized(login, password)) {
            User authorizedUser = inMemoryUserStorage.getByLogin(login);
            req.getSession().setAttribute("user", authorizedUser);
            resp.getWriter().println("Authentication succeeded");
        } else {
            resp.getWriter().println("Wrong login or password");
        }
    }
}
