package inc.droidflick.loginsignupmysqlphptutorial.network;

import com.android.volley.VolleyError;

import org.json.JSONObject;

/**
 * Created by Atif Arif on 3/28/2018.
 */

public interface VolleyJsonRequestCallBack {


    void onSuccess(JSONObject response);


    void onFailure(VolleyError error);

}
