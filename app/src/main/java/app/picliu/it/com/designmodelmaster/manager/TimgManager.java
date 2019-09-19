package app.picliu.it.com.designmodelmaster.manager;

import android.os.Handler;
import android.util.Log;


import java.util.logging.LogRecord;

/**
 * *  @name:picliu
 * *  @date:2019-08-29
 */
public class TimgManager {
    private String TAG = "TimgManager";

    public void computeTime() {
        /**
         * 这里做计时，如果满足NS后调用上报接口
         */
        Log.i(TAG, "computeTime: 开始计时");
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                收到新需求后调用 countDown();
                countDown();
                upDataTime()
                ;
            }
        }, 3000);//3秒后执行Runnable中的run方法

    }

    public void upDataTime() {
        Log.i(TAG, "upDataTime: 上报服务端");
    }

    /**
     * 接到加入倒计时功能，加入新方法
     */
    public void countDown() {
        Log.i(TAG, "countDown: 倒计时装圈圈");
    }
}
