package app.picliu.it.com.designmodelmaster.agentmodel;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * *  @name:picliu
 * *  @date: 2019-09-18
 * 动态代理类
 */
public class DynamicAgenter implements InvocationHandler {
    private String TAG = "agentmodel";

    public Object getAdPlat() {
        return adPlat;
    }

    private Object adPlat;

    public DynamicAgenter(String adConfig) {
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


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Log.i(TAG, "动态代理方法调用 method=" + method.getName());
        Object result = method.invoke(adPlat, args);
        return result;
    }

    /**
     * 动态代理的优点：
     *
     * 1.可以通过一个代理类完成全部的代理功能，接口中声明的所有方法都被转移到调用处理器一个集中的方法中处理（InvocationHandler.invoke）。当接口方法数量较多时，我们可以进行灵活处理，而不需要像静态代理那样每一个方法进行中转。
     * 2.动态代理的应用使我们的类职责更加单一，复用性更强。
     *
     *
     * 动态代理的缺点：
     * 1.不能对类进行代理，只能对接口进行代理，如果我们的类没有实现任何接口，那么就不能使用这种方式进行动态代理（因为$Proxy()这个类集成了Proxy,Java的集成不允许出现多个父类）。
     */
}
