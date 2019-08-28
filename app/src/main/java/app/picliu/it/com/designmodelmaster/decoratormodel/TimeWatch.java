package app.picliu.it.com.designmodelmaster.decoratormodel;

import android.os.Handler;
import android.util.Log;

/**
 * *  @name:picliu
 * *  @date:2019-08-29
 * 抽象装饰者   用来扩展用
 */
public abstract class TimeWatch extends Watch {
    private Watch watch;

    public TimeWatch(Watch watch) {
        this.watch = watch;
    }

    @Override
    public void computeTime() {
//        coumtDownWrong();/**  这里调用是不可取的，虽然也能实现产品需求/
        watch.computeTime();
    }

    /**
     * 收到产品夏松倒计时功能的需求后的倒计时抽象方法
     */
    public abstract void countDown();

    /**
     * 如果直接在这里加实现方法，也会导致这个类会也来越臃肿
     * 是不可取的
     */
    public void coumtDownWrong() {
        Log.i(TAG, "countDown: 倒计时装圈圈");
    }
}
