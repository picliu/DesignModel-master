package app.picliu.it.com.designmodelmaster.agentmodel;

import android.util.Log;

/**
 * *  @name:picliu
 * *  @date: 2019-09-18
 * 头条具体实现，具体主题
 */
public class TouTiaoPlat implements ADPlat {
    private String TAG = "agentmodel";

    @Override
    public void onDisplay() {
        Log.i(TAG, "TouTiaoPlat  onDisplay");
    }


}
