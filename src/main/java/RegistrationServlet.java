import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/reg")
public class RegistrationServlet extends HttpServlet {

        private final InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login  = req.getParameter("login");
        String password = req.getParameter("password");

        if (name.length() < 1 || login.length() < 3 || password.length() < 3) {
            resp.getWriter().println("Too short name, login or password");
        }

        if (inMemoryUserStorage.users.size() > 0 && inMemoryUserStorage.contains(login)) {
            resp.getWriter().println("User with such login already exists");
        }

        User user = new User(name, login, password);
        inMemoryUserStorage.save(user);
        resp.getWriter().println("You are successfully registered!");
    }
}
