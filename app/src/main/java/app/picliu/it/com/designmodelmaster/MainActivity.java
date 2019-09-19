package app.picliu.it.com.designmodelmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import app.picliu.it.com.designmodelmaster.agentmodel.AgenterActivity;
import app.picliu.it.com.designmodelmaster.ui.DecoratorModelActivity;
import app.picliu.it.com.designmodelmaster.ui.DesignPrincipleActivity;

/**
 * Android的设计模式-设计模式的六大原则
 * 一句话总结23种设计模式则
 * 创建型模式：
 * Android的设计模式-单例模式
 * Android的设计模式-建造者模式
 * Android的设计模式-工厂方法模式
 * Android的设计模式-简单工厂模式
 * Android的设计模式-抽象工厂模式
 * Android的设计模式-原型模式
 * 行为型模式：
 * Android的设计模式-策略模式
 * Android的设计模式-状态模式
 * Android的设计模式-责任链模式
 * Android的设计模式-观察者模式
 * Android的设计模式-模板方法模式
 * Android的设计模式-迭代器模式
 * Android的设计模式-备忘录模式
 * Android的设计模式-访问者模式
 * Android的设计模式-中介者模式
 * Android的设计模式-解释器模式
 * Android的设计模式-命令模式
 * 结构型模式：
 * Android的设计模式-代理模式
 * Android的设计模式-组合模式
 * Android的设计模式-适配器模式
 * Android的设计模式-装饰者模式
 * Android的设计模式-享元模式
 * Android的设计模式-外观模式
 * Android的设计模式-桥接模式
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }

    private void initview() {
        TextView mTvDesignPrinciple = findViewById(R.id.tv_design_principle);
        TextView mTvDecoratorModel = findViewById(R.id.tv_decorator_model);
        TextView mTvAgentModel = findViewById(R.id.tv_agent_model);
        mTvDesignPrinciple.setOnClickListener(this);
        mTvDecoratorModel.setOnClickListener(this);
        mTvAgentModel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.tv_design_principle:
                 intent = new Intent(MainActivity.this, DesignPrincipleActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_decorator_model:
                 intent = new Intent(MainActivity.this, DecoratorModelActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_agent_model:
                intent = new Intent(MainActivity.this, AgenterActivity.class);
                startActivity(intent);
            default:
                break;
        }
    }
}
