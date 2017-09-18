package client.aaron.com.dragger2andunittest;

import android.app.Application;

/**
 * Created by aaron on 2017/9/18.
 */

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ComponentHolder.init(this);
    }
}
