package inc.droidflick.loginsignupmysqlphptutorial.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

import inc.droidflick.loginsignupmysqlphptutorial.R;
import inc.droidflick.loginsignupmysqlphptutorial.network.VolleyJsonRequestCallBack;
import inc.droidflick.loginsignupmysqlphptutorial.network.VolleyNetwork;
import inc.droidflick.loginsignupmysqlphptutorial.network.VolleyStringRequestCallBack;
import inc.droidflick.loginsignupmysqlphptutorial.ui.core.BaseActivity;
import inc.droidflick.loginsignupmysqlphptutorial.utils.Urls;
import inc.droidflick.loginsignupmysqlphptutorial.utils.Utils;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    /*
    * @param declaration
    *
    * */

    EditText signUpEmail, signUpName, signUpPassword;
    Button signupButton, loginButton;
//    CheckBox checkBoxTerms;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public void init() {

     /*
    * @param initialization /definition
    *
    * */

        signupButton = (Button) findViewById(R.id.signupButton);
        loginButton = (Button) findViewById(R.id.loginButton);
        signUpEmail = (EditText) findViewById(R.id.signUpEmail);
        signUpName = (EditText) findViewById(R.id.signUpName);
        signUpPassword = (EditText) findViewById(R.id.signUpPassword);
        // checkBoxTerms = (CheckBox)findViewById(R.id.checkBoxTerms);


    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initUiListeners() {

        loginButton.setOnClickListener(this);
        signupButton.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.signupButton:

                requestHttp(Urls.Auth.newsignupUrl, true);
                break;

            case R.id.loginButton:
                requestHttp(Urls.Auth.newloginUrl, true);
                break;

        }


    }


    private void requestHttp(String url, boolean isString) {


        if (TextUtils.isEmpty(signUpEmail.getText().toString().trim())) {
            signUpEmail.setError(getString(R.string.please_enter_email));
            return;
        }

        if (TextUtils.isEmpty(signUpEmail.getText().toString().trim())) {
            signUpEmail.setError(getString(R.string.please_enter_email));
            return;
        }


        if (TextUtils.isEmpty(signUpName.getText().toString().trim())) {
            signUpName.setError(getString(R.string.please_enter_name));
            return;
        }


        if (TextUtils.isEmpty(signUpPassword.getText().toString().trim())) {
            signUpPassword.setError(getString(R.string.please_enter_password));
            return;
        }


        if (Utils.isOnline(this)) {
            if (isString) {
                VolleyNetwork.getInstance(this).StringRequest(url, volleyCallBack, "Test User", "example@email.com", "pass123");
            } else {
                VolleyNetwork.getInstance(this).JsonObjectRequest(url, volleyJsonCallBack, "Test User", "example@email.com", "pass123");
            }

        } else {
            Toast.makeText(this, getString(R.string.no_internet_connection), Toast.LENGTH_SHORT).show();
        }


    }

    VolleyStringRequestCallBack volleyCallBack = new VolleyStringRequestCallBack() {
        @Override
        public void onSuccess(String response) {


            /*
            *
            * @param Implement Gson FOr Json Parsing.!
            *
            * */


            //Navigate To Next Activity
            BaseActivity.startNewActivity(MainActivity.this, SecondActivity.class);

            Toast.makeText(MainActivity.this, "Registered.!", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onFailure(VolleyError error) {

            Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

        }
    };


    VolleyJsonRequestCallBack volleyJsonCallBack = new VolleyJsonRequestCallBack() {
        @Override
        public void onSuccess(JSONObject response) {

            try {
                JSONObject jsonArgs = response.getJSONObject("args");

                String msg = (String) jsonArgs.get("param1");

                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onFailure(VolleyError error) {

        }
    };


}


