package client.aaron.com.dragger2andunittest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

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
import dagger.Component;

public class LoginActivityByDragger2 extends AppCompatActivity implements IView {

    //通过Dragger 2 注入
    @Inject
    DBClient dbClient;
    @Inject
    HttpClient httpClient;
    @Inject
    AccelerationccelateClient mAccelerationccelateClient;
    @Inject
    BluetoothClient mBluetoothClient;
    @Inject
    DailyCheckClient mDailyCheckClient;
    @Inject
    EncryptionClient mEncryptionClient;
    @Inject
    TrackClient mTrackClient;
    @Inject
    Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Dragger 2 注入
        ActivityComponent component = ComponentHolder.component;
        component.inject(this);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ((EditText) findViewById(R.id.et_username)).getText().toString();
                String pwd = ((EditText) findViewById(R.id.et_pwd)).getText().toString();
                mPresenter.login(name, pwd);
            }
        });
    }

    @Override
    public void showMessage(String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }
}
