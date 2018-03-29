package inc.droidflick.loginsignupmysqlphptutorial.utils;

/**
 * Created by Atif Arif on 3/28/2018.
 */

public class Urls {


    /*
    *
    * @param stackOverFlow Link
    * https://stackoverflow.com/questions/41418361/android-login-using-php-mysql-and-volley?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
    *
    * */

    public static final String BASE_URL = "http://192.***.**.**/";

    public static final String BASE_URL_NEW = "http://192.***.*.*/new/";


    public static class Auth {

        public static final String loginUrl = BASE_URL + "login1.php";
        public static final String signupUrl = BASE_URL + "signup1.php";
        public static final String newloginUrl = BASE_URL_NEW + "newlogin.php";
        public static final String newsignupUrl = BASE_URL_NEW + "newsignup.php";

    }


}
