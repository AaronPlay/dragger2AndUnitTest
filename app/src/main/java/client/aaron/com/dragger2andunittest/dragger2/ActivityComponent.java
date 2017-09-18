package client.aaron.com.dragger2andunittest.dragger2;

import client.aaron.com.dragger2andunittest.LoginActivityByDragger2;
import dagger.Component;

/**
 * Created by aaron on 2017/9/17.
 */

@Component(modules = {ActivityModule.class})
public interface ActivityComponent {
    void inject(LoginActivityByDragger2 loginActivityByDragger2);
}
