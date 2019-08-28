package app.picliu.it.com.designmodelmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import app.picliu.it.com.designmodelmaster.ui.DecoratorModelActivity;
import app.picliu.it.com.designmodelmaster.ui.DesignPrincipleActivity;

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
        mTvDesignPrinciple.setOnClickListener(this);
        mTvDecoratorModel.setOnClickListener(this);
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
            default:
                break;
        }
    }
}
