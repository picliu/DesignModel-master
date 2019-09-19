package app.picliu.it.com.designmodelmaster.agentmodel;

import android.text.TextUtils;
import android.util.Log;

/**
 * *  @name:picliu
 * *  @date: 2019-09-18
 *    静态代理类，起代理作用
 */
public class Agenter implements ADPlat {
    private String TAG = "agentmodel";
    private ADPlat adPlat;

    @Override
    public void onDisplay() {
        Log.i(TAG, "经过代理后再进行对应的广告渠道展示");
        /*这里只是拿广告展示场景下举例子，这里也可以先去做上报，或者其他事情之后再进行展示*/
        adPlat.onDisplay();
    }

    public Agenter(String adConfig) {
//        根据广告配置分配具体广告实现类
        switch (adConfig) {
            case "cpc":
                adPlat = new CPCPlat();
                break;
            case "toutiao":
                adPlat = new TouTiaoPlat();
                break;
            default:
        }
    }

    /**
     * 静态代理与动态代理比较
     * 静态代理的缺点：
     *
     * 1.静态代理如果接口新增一个方法，除了所有实现类（真实主题类）需要实现这个方法外，所有代理类也需要实现此方法。增加了代码维护的复杂度。
     * 2.代理对象只服务于一种类型的对象，如果要服务多类型的对象。必须要为每一种对象都进行代理，静态代理在程序规模稍大时就无法胜任了。
     */
}
