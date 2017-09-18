package client.aaron.com.dragger2andunittest;

import android.content.Context;
import android.widget.Toast;

import client.aaron.com.dragger2andunittest.client.AccelerationccelateClient;
import client.aaron.com.dragger2andunittest.client.BluetoothClient;
import client.aaron.com.dragger2andunittest.client.DBClient;
import client.aaron.com.dragger2andunittest.client.DailyCheckClient;
import client.aaron.com.dragger2andunittest.client.EncryptionClient;
import client.aaron.com.dragger2andunittest.client.HttpClient;
import client.aaron.com.dragger2andunittest.client.TrackClient;

/**
 * Created by aaron on 2017/9/17.
 */

public class Presenter {
    private Context mContext;
    private DBClient mDbClient;
    private HttpClient mHttpClient;
    private AccelerationccelateClient mAccelerationccelateClient;
    private BluetoothClient mBluetoothClient;
    private DailyCheckClient mDailyCheckClient;
    private EncryptionClient mEncryptionClient;
    private TrackClient mTrackClient;

    public Presenter(Context context, DBClient dbClient, HttpClient httpClient, AccelerationccelateClient accelerationccelateClient, BluetoothClient bluetoothClient, DailyCheckClient dailyCheckClient, EncryptionClient encryptionClient, TrackClient trackClient) {
        mContext = context;
        mDbClient = dbClient;
        mHttpClient = httpClient;
        mAccelerationccelateClient = accelerationccelateClient;
        mBluetoothClient = bluetoothClient;
        mDailyCheckClient = dailyCheckClient;
        mEncryptionClient = encryptionClient;
        mTrackClient = trackClient;
    }

    public void login(String username, String pwd){
        mDbClient.doSomething();
        mHttpClient.doSomething();
        mAccelerationccelateClient.doSomething();
        mBluetoothClient.doSomething();
        mDailyCheckClient.doSomething();
        mEncryptionClient.doSomething();
        mTrackClient.doSomething();

        if(username.equals("123") && pwd.equals("123")){
            Toast.makeText(mContext, "登陆成功",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(mContext, "登陆失败",Toast.LENGTH_SHORT).show();
        }
    }
}
