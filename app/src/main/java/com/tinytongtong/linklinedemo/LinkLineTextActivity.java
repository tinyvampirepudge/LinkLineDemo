package com.tinytongtong.linklinedemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.tinytongtong.linklinedemo.mock.MockDataUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LinkLineTextActivity extends AppCompatActivity {

    @BindView(R.id.link_line_view)
    LinkLineView linkLineView;
    @BindView(R.id.fl_link_line)
    FrameLayout flLinkLine;
    @BindView(R.id.tv_result)
    TextView tvResult;

    public static void actionStart(Context context) {
        Intent starter = new Intent(context, LinkLineTextActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_line_text);
        ButterKnife.bind(this);

        List<LinkDataBean> list = MockDataUtil.getInstance().mockLinkLineData(this, 0);
        linkLineView.setData(list);
        linkLineView.setOnChoiceResultListener((correct, yourAnswer) -> {
            // 结果
            StringBuilder sb = new StringBuilder();
            sb.append("正确与否：");
            sb.append(correct);
            sb.append("\n");
            tvResult.setText(sb.toString());
        });
    }
}
