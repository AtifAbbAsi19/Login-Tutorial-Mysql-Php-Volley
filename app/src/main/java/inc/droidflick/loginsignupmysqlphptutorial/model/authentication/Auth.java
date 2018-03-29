package inc.droidflick.loginsignupmysqlphptutorial.model.authentication;

/**
 *
 * @author Atif Arif
 * Created 3/28/2018.
 */

public class Auth implements AuthInterface {

    String email;
    String password;


    /**
     * @param // 1) default constructor Auth().
     * @param // 2) copy constructor Auth(String email, String password).
     */

    public Auth() {
        this.email = "";
        this.password = "";
    }

    public Auth(String email, String password) {
        this.email = email;
        this.password = password;
    }


    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
