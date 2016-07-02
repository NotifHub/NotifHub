package synapsehub.cd.notifhub;

import android.app.Application;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by michelo on 7/2/16.
 */

public class NothifHubApplication extends Application {

    public static SharedPreferences prefs;


    @Override
    public void onCreate() {
        super.onCreate();
        prefs = getSharedPreferences("synapsehub.cd.notifhub",MODE_PRIVATE);

    }

}
