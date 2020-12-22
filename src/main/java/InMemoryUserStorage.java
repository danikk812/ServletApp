import java.util.ArrayList;
import java.util.List;

public class InMemoryUserStorage {

    static List<User> users = new ArrayList<>();
    static int userId = 1;

    public void save(User user) {
        user.setId(userId);
        users.add(user);
        userId++;
    }

    public boolean contains(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAuthorized(String login, String password) {
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public String printAllUsers() {
        StringBuilder sb = new StringBuilder();
        for (User user : users) {
            sb.append(user.toString() + "\n");
        }
        return sb.toString();
    }

    public User getByLogin(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    public User getByPassword(String password) {
        for (User user : users) {
            if (user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

}
