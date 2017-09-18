package client.aaron.com.dragger2andunittest;

import android.content.Context;

import client.aaron.com.dragger2andunittest.dragger2.ActivityComponent;
import client.aaron.com.dragger2andunittest.dragger2.ActivityModule;
import client.aaron.com.dragger2andunittest.dragger2.DaggerActivityComponent;

/**
 * Created by aaron on 2017/9/18.
 */

public class ComponentHolder {
    public static ActivityComponent component;
    public static void init(Context context){
        component = DaggerActivityComponent.builder().activityModule(new ActivityModule(context)).build();
    }
}
