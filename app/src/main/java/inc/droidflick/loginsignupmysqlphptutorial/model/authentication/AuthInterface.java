package inc.droidflick.loginsignupmysqlphptutorial.model.authentication;

/**
 * Created by Atif Arif on 3/28/2018.
 */

public interface AuthInterface {


    void setEmail(String email);

    String getEmail();


    void setPassword(String password);

    String getPassword();

}
