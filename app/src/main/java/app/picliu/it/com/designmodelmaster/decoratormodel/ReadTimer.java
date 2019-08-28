package app.picliu.it.com.designmodelmaster.decoratormodel;

import android.os.Handler;
import android.util.Log;

/**
 * *  @name:picliu
 * *  @date:2019-08-29
 *    具体业务组件
 */
public class ReadTimer extends Watch {
    @Override
    public void computeTime() {
        /**
         * 这里做计时，如果满足NS后调用上报接口
         */
        Log.i(TAG, "computeTime: 开始计时");
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                upDataTime();
            }
        }, 3000);//3秒后执行Runnable中的run方法
    }


}
