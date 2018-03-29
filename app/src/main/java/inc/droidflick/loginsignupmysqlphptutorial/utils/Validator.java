package inc.droidflick.loginsignupmysqlphptutorial.utils;

/**
 * Created by Atif Arif on 3/28/2018.
 */

public class Validator {


    //Email Validation pattern
    public static final String regEx = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b";

    //Mobile validation pattern
    public static final String mobregEx = "^(\\+92[\\-\\s]?)?[0]?(92)?[345]\\d{9}$";


}
