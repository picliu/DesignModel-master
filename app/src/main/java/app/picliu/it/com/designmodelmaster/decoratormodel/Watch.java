package app.picliu.it.com.designmodelmaster.decoratormodel;

import android.os.Handler;
import android.util.Log;

/**
 * *  @name:picliu
 * *  @date:2019-08-29
 *    抽象组件
 */
public abstract class Watch {
    public String TAG = "Watch";

    public abstract void computeTime();

    public void upDataTime() {
        Log.i(TAG, "upDataTime: 上报服务端");
    }
}
