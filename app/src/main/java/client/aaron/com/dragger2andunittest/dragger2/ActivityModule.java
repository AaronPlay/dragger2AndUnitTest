package client.aaron.com.dragger2andunittest.dragger2;


import android.content.Context;

import javax.inject.Singleton;

import client.aaron.com.dragger2andunittest.Presenter;
import client.aaron.com.dragger2andunittest.client.AccelerationccelateClient;
import client.aaron.com.dragger2andunittest.client.BluetoothClient;
import client.aaron.com.dragger2andunittest.client.DBClient;
import client.aaron.com.dragger2andunittest.client.DailyCheckClient;
import client.aaron.com.dragger2andunittest.client.EncryptionClient;
import client.aaron.com.dragger2andunittest.client.HttpClient;
import client.aaron.com.dragger2andunittest.client.TrackClient;
import dagger.Module;
import dagger.Provides;

/**
 * Created by aaron on 2017/9/17.
 */
@Module
public class ActivityModule {
    private Context mContext;

    public ActivityModule(Context context) {
        mContext = context;
    }

    @Provides
    public Presenter providesPresenter( DBClient dbClient, HttpClient httpClient, AccelerationccelateClient accelerationccelateClient, BluetoothClient bluetoothClient, DailyCheckClient dailyCheckClient, EncryptionClient encryptionClient, TrackClient trackClient){
        return  new Presenter(mContext,dbClient,httpClient,accelerationccelateClient,bluetoothClient,dailyCheckClient,encryptionClient,trackClient);
    }

    @Provides
    public HttpClient providesHttpClient() {
        return new HttpClient();
    }

    @Provides
    public AccelerationccelateClient providesAccelerationccelateClient() {
        return new AccelerationccelateClient();
    }

    @Provides
    public BluetoothClient providesBluetoothClient() {
        return new BluetoothClient();
    }

    @Provides
    public DailyCheckClient providesDailyCheckClient() {
        return new DailyCheckClient();
    }

    @Provides
    public DBClient providesDBClient() {
        return new DBClient();
    }

    @Provides
    public EncryptionClient providesEncryptionClient() {
        return new EncryptionClient();
    }

    @Provides
    public TrackClient providesTrackClient() {
        return new TrackClient();
    }
}