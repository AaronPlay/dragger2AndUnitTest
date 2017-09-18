package client.aaron.com.dragger2andunittest;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import client.aaron.com.dragger2andunittest.client.AccelerationccelateClient;
import client.aaron.com.dragger2andunittest.client.BluetoothClient;
import client.aaron.com.dragger2andunittest.client.DBClient;
import client.aaron.com.dragger2andunittest.client.DailyCheckClient;
import client.aaron.com.dragger2andunittest.client.EncryptionClient;
import client.aaron.com.dragger2andunittest.client.HttpClient;
import client.aaron.com.dragger2andunittest.client.TrackClient;
import client.aaron.com.dragger2andunittest.dragger2.ActivityComponent;
import client.aaron.com.dragger2andunittest.dragger2.ActivityModule;
import client.aaron.com.dragger2andunittest.dragger2.DaggerActivityComponent;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyByte;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by aaron on 2017/9/17.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class LoginActivityUnitTest {
    private String name = "123";
    private String pwd = "123";

    @Test
    public void LoginActivityTest() {
        LoginActivity activity = Robolectric.setupActivity(LoginActivity.class);
        Presenter presenter = mock(Presenter.class);
        activity.setPresenter(presenter);

        ((EditText) activity.findViewById(R.id.et_username)).setText(name);
        ((EditText) activity.findViewById(R.id.et_pwd)).setText(pwd);
        ((Button) activity.findViewById(R.id.btn)).performClick();
        verify(presenter).login(name, pwd);
    }

    @Test
    public void LoginActivityDragger2Test() {
        ActivityModule activityModule = spy(new ActivityModule(RuntimeEnvironment.application));
        ActivityComponent activityComponent = DaggerActivityComponent.builder().activityModule(activityModule).build();
        Presenter presenter = mock(Presenter.class);

        when(activityModule.providesPresenter(
                any(DBClient.class),
                any(HttpClient.class),
                any(AccelerationccelateClient.class),
                any(BluetoothClient.class),
                any(DailyCheckClient.class),
                any(EncryptionClient.class),
                any(TrackClient.class)
                )
        ).thenReturn(presenter);

        LoginActivityByDragger2 activity = Robolectric.setupActivity(LoginActivityByDragger2.class);
        activityComponent.inject(activity);
        ((EditText) activity.findViewById(R.id.et_username)).setText(name);
        ((EditText) activity.findViewById(R.id.et_pwd)).setText(pwd);
        ((Button) activity.findViewById(R.id.btn)).performClick();
        verify(presenter).login(name, pwd);
    }
}
