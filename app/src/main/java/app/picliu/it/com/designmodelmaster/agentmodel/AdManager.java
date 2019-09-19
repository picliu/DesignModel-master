package app.picliu.it.com.designmodelmaster.agentmodel;

import android.util.Log;

/**
 * *  @name:picliu
 * *  @date: 2019-09-18
 */
public class AdManager {
    private String TAG = "agentmodel";

    public AdManager() {
    }

    public void onDisplay(String adConfig) {
        switch (adConfig) {
            case "cpc":
                disPlayCpc();
                break;
            case "toutiao":
                disPlayToutiao();
                break;
            default:
        }
    }

    public void disPlayCpc() {
/**
 * 就是直接使用广告实现类对象调用对应的方法，与代理模式相比中间使用了第三方来调用而已
 */
        new CPCPlat().onDisplay();
    }

    public void disPlayToutiao() {
        new TouTiaoPlat().onDisplay();
    }
}
