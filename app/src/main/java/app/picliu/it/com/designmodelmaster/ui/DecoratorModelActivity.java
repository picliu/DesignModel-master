package app.picliu.it.com.designmodelmaster.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import app.picliu.it.com.designmodelmaster.R;
import app.picliu.it.com.designmodelmaster.decoratormodel.CountDownTimeWatch;
import app.picliu.it.com.designmodelmaster.decoratormodel.ReadTimer;
import app.picliu.it.com.designmodelmaster.decoratormodel.ui.FindBookActivity;
import app.picliu.it.com.designmodelmaster.manager.TimgManager;

/**
 * *  @name:picliu
 * *  @date:2019-08-29
 */
public class DecoratorModelActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decorator_model);
        initView();

    }

    private void initView() {
        TextView mTvStartCompute = findViewById(R.id.tv_start_compute);
        mTvStartCompute.setOnClickListener(this);
        TextView mTvStartNewCompute = findViewById(R.id.tv_start_new_compute);
        mTvStartNewCompute.setOnClickListener(this);
        TextView mTvStartPackageCompute = findViewById(R.id.tv_start_package_compute);
        mTvStartPackageCompute.setOnClickListener(this);
        TextView mTvStartFindbook = findViewById(R.id.tv_start_findbook);
        mTvStartFindbook.setOnClickListener(this);
    }

    /**
     * 常规写法
     */
    private void initOld() {
        /**
         拿我们项目里面统计阅读时长为例
         1.产品需求，没过N s 中后上报一次接口，把这期间有效阅读时长上报
         2.根据接口返回情况，是否满足金币任务获取金币

         那常规的写法我会写一个管理manager类来管理时间，和上报
         */
        TimgManager timgManager = new TimgManager();
        timgManager.computeTime();
        /**
         * 然后有一天我们的产品夏松说说要在计时的时候加个计时的圈圈
         *
         * 然后我想的就是在TimgManager管理类里面加个倒计时功能
         * 比如加入countDown()方法
         * 如果 我直接改了那就违反了六大原则中的开闭原则
         *后面如果加入功能，会让TimgManager类越来越重
         * 就像现在项目里面阅读器的BannerManager类
         * 我们应该考虑的是不修改之前写好的功能基础上面去扩展
         *
         * 这时候就要考虑引入设计模式来改善
         */


    }

    private void initNew() {
/**
 *这里是新的 封装后的计时方法
 */
        ReadTimer readTimer = new ReadTimer();
        readTimer.computeTime();
        /**
         * 收到产品夏松的新需求，要加倒计时的圈圈
         * 要遵守开闭原则
         * 不能直接去Watch去修改
         * 考虑 后期可能还会加很多别的功能，我们就考虑把Watch抽象出来，
         * 建一个TimeWatch类装饰实现Watch
         * 并且抽象出来供后面扩展使用
         */

    }

    private void initPakegeTime() {
/**
 * 加入装饰思想后的实现 计时的方法
 * 还没有收到产品的新需求
 * 具体做法
 * 新建一个装饰者抽象类 TimeWatch 没有具体的方法实现
 * 然后新建一个具体的装饰者CountDownTimeWatch继承TimeWatch
 * 里面实现以后的扩展
 */
        CountDownTimeWatch countDownTimeWatch = new CountDownTimeWatch(new ReadTimer());
        countDownTimeWatch.computeTime();
        /**
         * 收到产品的新需求后在装饰者抽象类（TimeWatch）里面加入countDown()抽象方法
         * 然后具体实现在装饰者CountDownTimeWatch
         * 再调用上面的方法 就多了实现倒计时的功能
         */
/**
 * 总结
 * 以上情况，很符合实际开发中的情况，早期的功能比较简单，可以很容易实现
 * 只有一个计时后上报服务端
 *
 * 难免在迭代过程中加入新的功能，比如加入计时器，或者埋点的功能
 * 在开发过程中，我们要考虑老的实现方法尽量只在修bug的时候去修改，比如Watch类，除非上报时间的方法接口改了
 * 我们要有扩展的思想，这个扩展是指不影响老的代码，就可以加入新的功能
 *
 * 不应该在TimeWatch类里面加入countDown()的具体实现方法
 *
 * 还有可以有更多的扩展
 * 比如后期业务里面  加入了 找书界面，也有类似的功能，
 *
 * 可能我们会想到直接在找书页使用 CountDownTimeWatch类
 *
 */
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_start_compute:
                initOld();
                break;
            case R.id.tv_start_new_compute:
                initNew();
                break;
            case R.id.tv_start_package_compute:
                initPakegeTime();
                break;
            case R.id.tv_start_findbook:
                startActivity(new Intent(DecoratorModelActivity.this, FindBookActivity.class));
                break;
            default:
                break;
        }
    }


}
