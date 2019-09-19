package app.picliu.it.com.designmodelmaster.agentmodel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Proxy;

import app.picliu.it.com.designmodelmaster.R;

/**
 * *  @name:picliu
 * *  @date: 2019-09-18
 * <p>
 * <p>
 * 角色说明：
 * Subject（抽象主题类）：接口或者抽象类，声明真实主题与代理的共同接口方法。
 * RealSubject（真实主题类）：也叫做被代理类或被委托类，定义了代理所表示的真实对象，负责具体业务逻辑的执行，客户端可以通过代理类间接的调用真实主题类的方法。
 * Proxy（代理类）：也叫委托类，持有对真实主题类的引用，在其所实现的接口方法中调用真实主题类中相应的接口方法执行。
 * Client（客户端类）：使用代理模式的地方。
 */
public class AgenterActivity extends AppCompatActivity {

    private TextView mTvAgentOldFunction;
    private AdManager adManager;
    private String adConfig = "toutiao";
    private TextView mTvAgentAgentFunction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent);


        /** 代理模式
         *
         * a.应用场景
         * 当一个对象不能或者不想直接访问另一个对象时，可以通过一个代理对象来间接访问。为保证客户端使用的透明性，委托对象和代理对象要实现同样的接口。
         *
         * 被访问的对象不想暴露全部内容时，可以通过代理去掉不想被访问的内容。
         *
         *
         * b.这里用我们项目里面 广告加载场景  做带入，
         * 根据服务端返回的配置去展示 由代理着去管理cpc还是穿山甲广告渠道
         *这里比方可能不太恰当
         *
         * 好比  我们要去购买ipone手机（我们要展示广告）
         *  但是国内没有，我们需要找代购，即代理（我们不知道展示哪家广告，或者后端告诉我们该不该展示广告，中间以代理模式代理展示广告动作）
         *  又或者，我们不知道哪个国家有货，港版还是美版，只有代购他知道（我们业务场景：我们不知道后端配置要求展示哪家广告cpc还是穿山甲）
         *
         *  这里的“我”最终只需要能收到代购买的手机就行，所以只关心购买的事，代购处理怎么买（我们业务中，只关心最终广告的展示，代理类负责处理展示哪家广告）
         *
         * 那这里的设计思路
         * Subject（抽象主题类）:角色是广告的   展示方法，具体实现方法抽象出去给具体实现类实现（ADPlat）
         * RealSubject（真实主题类）：是据图广告渠道实现类，里面有具体实现广告的展示方法（CPCPlat、ToutiaoPlat）
         * Proxy（代理类）：来协调展示哪家广告或者展不展示广告（DynamicAgenter、Agenter）
         * lient（客户端类）：使用代理模式的地方 。
         *  *
         *
         * */
        initview();
    }

    private void initview() {
        mTvAgentOldFunction = findViewById(R.id.tv_agent_old_function);
        mTvAgentOldFunction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goOldFunction();
            }
        });

        mTvAgentAgentFunction = findViewById(R.id.tv_agent_agent_function);
        mTvAgentAgentFunction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goAgentFunction();
            }
        });

        TextView mTvDynamicAgentFunction = findViewById(R.id.tv_dynamic_agent_function);
        mTvDynamicAgentFunction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goDynamicAgentFunction();
            }
        });
    }

    /**
     * 动态代理实现
     */
    private void goDynamicAgentFunction() {

        DynamicAgenter dynamicAgenter = new DynamicAgenter(adConfig);
        ClassLoader classLoader = ((TouTiaoPlat) dynamicAgenter.getAdPlat()).getClass().getClassLoader();
        ADPlat proxyInstance = (ADPlat) Proxy.newProxyInstance(classLoader, new Class[]{ADPlat.class}, dynamicAgenter);
        proxyInstance.onDisplay();


    }

    /**
     * 代理模式实现
     */
    private void goAgentFunction() {
        Agenter agenter = new Agenter(adConfig);
        agenter.onDisplay();
    }

    /**
     * 没经过设计模式的方法
     */
    private void goOldFunction() {
        if (adManager == null) {
            adManager = new AdManager();
        }
        adManager.onDisplay(adConfig);
    }

    /**
     *  静态代理与动态代理
     *   从代码的角度来分，代理可以分为两种：一种是静态代理，另一种是动态代理。
     *
     *   静态代理就是在程序运行前就已经存在代理类的字节码文件，代理类和委托类的关系在运行前就确定了。上面的例子实现就是静态代理。
     *
     *   动态代理类的源码是在程序运行期间根据反射等机制动态的生成，所以不存在代理类的字节码文件。代理类和委托类的关系是在程序运行时确定。
     *
     *   下面我们实现动态代理，Java提供了动态的代理接口InvocationHandler，实现该接口需要重写invoke()方法：
     */
}
