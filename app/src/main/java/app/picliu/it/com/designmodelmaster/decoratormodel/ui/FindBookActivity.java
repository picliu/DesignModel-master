package app.picliu.it.com.designmodelmaster.decoratormodel.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import app.picliu.it.com.designmodelmaster.R;
import app.picliu.it.com.designmodelmaster.decoratormodel.CountDownTimeWatch;
import app.picliu.it.com.designmodelmaster.decoratormodel.FindBookTimer;
import app.picliu.it.com.designmodelmaster.decoratormodel.ReadTimer;

/**
 * *  @name:picliu
 * *  @date:2019-08-29
 */
public class FindBookActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decorator_model);
        initView();
    }

    private void initView() {
        /**
         * 业务上多了个找书功能，也能看书，也算阅读时长
         */
        findViewById(R.id.tv_start_findbook).setVisibility(View.GONE);
        findViewById(R.id.tv_start_package_compute).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
/**
 *   如果还是使用ReadTimer，可能就会和阅读器耦合，两边难免后面会有不同的业务，
 *   比如两边可能会有不同的埋点或者其他区分的功能更
 *   这时候应该考虑
 *   新加一个 具体业务组件FindBookTimer类
 */
//                new CountDownTimeWatch(new ReadTimer()).computeTime();

                /**
                 * 加入了新的具体业务组件FindBookTimer类
                 * 里面比阅读器多了埋点的功能
                 * 或者有和阅读器不一样的埋点功能
                 */
                new CountDownTimeWatch(new FindBookTimer()).computeTime();
            }
        });
    }
}
