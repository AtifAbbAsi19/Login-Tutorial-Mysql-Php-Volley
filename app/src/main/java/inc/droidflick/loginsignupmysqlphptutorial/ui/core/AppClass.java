package inc.droidflick.loginsignupmysqlphptutorial.ui.core;

import android.app.Application;

import inc.droidflick.loginsignupmysqlphptutorial.network.VolleyNetwork;

/**
 * Created by Atif Arif on 3/28/2018.
 */

public class AppClass extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        RootView.getInstance();//Init RootViews for static data
        VolleyNetwork.getInstance(this);


    }


}
