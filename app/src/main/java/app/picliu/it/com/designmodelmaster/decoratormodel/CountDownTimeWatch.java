package app.picliu.it.com.designmodelmaster.decoratormodel;

import android.util.Log;

/**
 * *  @name:picliu
 * *  @date:2019-08-29
 *    具体的装饰者  用来实现扩展的需求
 */
public class CountDownTimeWatch extends TimeWatch {
    public CountDownTimeWatch(Watch watch) {
        super(watch);
    }

    /**
     * 实现倒计时的方法
     */
    @Override
    public void countDown() {
        Log.i(TAG, "countDown: 倒计时装圈圈");
    }

    @Override
    public void computeTime() {
        /**
         * 收到需求  需要开启倒计时功能   countDown();
         */
//        countDown();
        super.computeTime();
    }
}
