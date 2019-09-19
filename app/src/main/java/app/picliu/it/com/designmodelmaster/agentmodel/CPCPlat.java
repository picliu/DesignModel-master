package app.picliu.it.com.designmodelmaster.agentmodel;

import android.util.Log;

/**
 * *  @name:picliu
 * *  @date: 2019-09-18
 * cpc广告实现类，具体主题角色
 */
public class CPCPlat implements ADPlat {
    private String TAG = "agentmodel";
    @Override
    public void onDisplay() {
        Log.i(TAG, "CPCPlat  onDisplay");
    }

}
