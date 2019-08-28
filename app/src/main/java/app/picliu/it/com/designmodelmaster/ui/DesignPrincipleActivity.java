package app.picliu.it.com.designmodelmaster.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import app.picliu.it.com.designmodelmaster.R;

/**
 * *  @name:picliu
 * *  @date:2019-08-29
 */
public class DesignPrincipleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designprinciple);
        initView();
    }

    private void initView() {
        TextView mTvDesignPrinciple = findViewById(R.id.tv_design_principle);
        String[] stringArray = getResources().getStringArray(R.array.design_principle);
        String tex = "";
        for (int i = 0; i < stringArray.length; i++) {
            tex = tex + "\r\n" + stringArray[i];
        }
        mTvDesignPrinciple.setText(tex);
        mTvDesignPrinciple.setMovementMethod(new ScrollingMovementMethod());
    }
}
