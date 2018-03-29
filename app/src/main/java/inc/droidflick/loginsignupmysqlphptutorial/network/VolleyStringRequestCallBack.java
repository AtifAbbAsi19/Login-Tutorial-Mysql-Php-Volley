package inc.droidflick.loginsignupmysqlphptutorial.network;

import com.android.volley.VolleyError;

/**
 * Created by Atif Arif on 3/28/2018.
 */

public interface VolleyStringRequestCallBack {


    void onSuccess(String response);


    void onFailure(VolleyError error);

}
