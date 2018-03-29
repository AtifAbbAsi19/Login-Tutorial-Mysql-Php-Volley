package inc.droidflick.loginsignupmysqlphptutorial.ui.core;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Atif Arif on 3/28/2018.
 */

public abstract class BaseActivity extends AppCompatActivity {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
//        hideTitleBar(); //full screen Application View

    }

    private void hideTitleBar() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    protected void onStart() {
        getLayoutId();
        init();
        initUiListeners();
        super.onStart();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }

    public abstract void init();

    public abstract int getLayoutId();

    public abstract void initUiListeners();


    public static void startNewActivity(Activity activity, Class clazz) {

//        startNewActivty(new Intent(activity,clazz));
        Intent intent = new Intent(activity, clazz);
        activity.startActivity(intent);

    }

    public static void startNewActivity(Activity activity, Class clazz, Bundle args) {

//        startNewActivty(new Intent(activity,clazz));
        Intent intent = new Intent(activity, clazz);
        intent.putExtras(args);
        activity.startActivity(intent);

    }

}
