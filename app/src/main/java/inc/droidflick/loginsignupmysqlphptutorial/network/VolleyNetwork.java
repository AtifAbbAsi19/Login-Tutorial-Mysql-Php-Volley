package inc.droidflick.loginsignupmysqlphptutorial.network;

import android.content.Context;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Atif Arif on 3/28/2018.
 */

public class VolleyNetwork {


    private static VolleyNetwork mInstance;
    private RequestQueue mRequestQueue;
    private static Context mContext;

    private VolleyNetwork(Context context) {
        // Specify the application context
        mContext = context;
        // Get the request queue
        mRequestQueue = getRequestQueue();
    }

    public static synchronized VolleyNetwork getInstance(Context context) {
        // If Instance is null then initialize new Instance
        if (mInstance == null) {
            mInstance = new VolleyNetwork(context);
        }
        // Return VolleyNetwork Singleton new Instance
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        // If RequestQueue is null the initialize new RequestQueue
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(mContext);
        }

        // Return RequestQueue
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> request) {
        // Add the specified request to the request queue
        getRequestQueue().add(request);
    }


    public static void StringRequest(String url, final VolleyStringRequestCallBack callBack, final String... data) {


        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        callBack.onSuccess(response);
                        Log.d("onSuccessResponse", response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                       callBack.onFailure(error);
//                        error.printStackTrace();
//                        Log.d("onErrorResponse", error.getMessage());


                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                try {
                    params.put("email", data[0].toString());
                    params.put("password", data[1].toString());
                    params.put("name", data[2].toString());
//                    params.put("Content-Type", "application/json");
//                    params.put("Authorization", "android");
                } catch (Exception e) {
                    Log.e("network", "Authentication Filure");
                }
                return params;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        // Add StringRequest to the RequestQueue
        VolleyNetwork.getInstance(mContext).addToRequestQueue(postRequest);

    }


    public static void JsonObjectRequest(String url, final VolleyJsonRequestCallBack callBack, final String... data) {


        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        callBack.onSuccess(response);


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        callBack.onFailure(error);
                        error.printStackTrace();
                    }
                });

        jsonRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        // Add StringRequest to the RequestQueue
        VolleyNetwork.getInstance(mContext).addToRequestQueue(jsonRequest);

    }


}
