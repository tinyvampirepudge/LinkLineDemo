package com.tinytongtong.linklinedemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;


import com.tinytongtong.linklinedemo.mock.MockDataUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LinkLineShowModeActivity extends AppCompatActivity {

    @BindView(R.id.link_line_view)
    LinkLineView linkLineView;
    @BindView(R.id.fl_link_line)
    FrameLayout flLinkLine;

    public static void actionStart(Context context) {
        Intent starter = new Intent(context, LinkLineShowModeActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_line_show_mode);
        ButterKnife.bind(this);

        List<LinkDataBean> list = MockDataUtil.getInstance().mockLinkLineData(this,0);
        linkLineView.justShowResult(list);
    }
}
