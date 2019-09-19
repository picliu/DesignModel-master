package app.picliu.it.com.designmodelmaster.decoratormodel;

import android.os.Handler;
import android.util.Log;

/**
 * *  @name:picliu
 * *  @date:2019-08-29
 */
public class FindBookTimer extends Watch {
    @Override
    public void computeTime() {
        /**
         * 这里做计时，如果满足N S后调用上报接口
         *
         * 如果在开始计时的时候 产品需要加上埋点，那找书和阅读器两边埋点的方法肯定会不一样
         * 其实可以把Timer也抽象出去扩展使用，思想和计时Watch一样这里就不重复举例了
         */
        /**
         * 具体调用埋点的方法 maidian()
         */
//        maidian();
        Log.i(TAG, "computeTime: 开始计时");
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                upDataTime();
            }
        }, 3000);//3秒后执行Runnable中的run方法
    }

    /**
     * 具体埋点的实现方法
     */
    public void maidian() {
        Log.i(TAG, "maidian: FindBookTimer");
    }
}
