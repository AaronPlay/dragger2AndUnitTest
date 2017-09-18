package client.aaron.com.dragger2andunittest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import client.aaron.com.dragger2andunittest.client.AccelerationccelateClient;
import client.aaron.com.dragger2andunittest.client.BluetoothClient;
import client.aaron.com.dragger2andunittest.client.DBClient;
import client.aaron.com.dragger2andunittest.client.DailyCheckClient;
import client.aaron.com.dragger2andunittest.client.EncryptionClient;
import client.aaron.com.dragger2andunittest.client.HttpClient;
import client.aaron.com.dragger2andunittest.client.TrackClient;

public class LoginActivity extends AppCompatActivity implements IView {
    Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        DBClient dbClient = new DBClient();
        HttpClient httpClient = new HttpClient();
        AccelerationccelateClient mAccelerationccelateClient = new AccelerationccelateClient();
        BluetoothClient mBluetoothClient = new BluetoothClient();
        DailyCheckClient mDailyCheckClient = new DailyCheckClient();
        EncryptionClient mEncryptionClient = new EncryptionClient();
        TrackClient mTrackClient = new TrackClient();

        mPresenter = new Presenter(
                this,
                dbClient,
                httpClient,
                mAccelerationccelateClient,
                mBluetoothClient,
                mDailyCheckClient,
                mEncryptionClient,
                mTrackClient
        );

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ((EditText) findViewById(R.id.et_username)).getText().toString();
                String pwd = ((EditText) findViewById(R.id.et_pwd)).getText().toString();
                mPresenter.login(name, pwd);
            }
        });
    }

    //为单元测试开放
    public void setPresenter(Presenter presenter) {
        mPresenter = presenter;
    }

    public Presenter getPresenter() {
        return mPresenter;
    }

    @Override
    public void showMessage(String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }
}
