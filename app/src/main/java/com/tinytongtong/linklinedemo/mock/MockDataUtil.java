package com.tinytongtong.linklinedemo.mock;

import android.content.Context;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.tinytongtong.linklinedemo.LinkDataBean;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 模拟数据的
 * @Author wangdandandefather
 * @Date 2019-11-14 22:58
 * @Version
 */
public class MockDataUtil {
    private MockDataUtil() {

    }

    private static final class MockDataUtilHolder {
        private static final MockDataUtil INSTANCE = new MockDataUtil();
    }

    public static MockDataUtil getInstance() {
        return MockDataUtilHolder.INSTANCE;
    }

    /**
     * 从assets中读取对应的json文件
     *
     * @param context
     * @param assetsName
     * @return
     */
    private String getJsonFromAssets(Context context, String assetsName) {
        if (TextUtils.isEmpty(assetsName)) {
            return null;
        }
        String jsonString = "";
        try {
            StringBuffer sb = new StringBuffer();
            InputStream is = null;
            is = context.getAssets().open(assetsName);

            int len = -1;
            byte[] buf = new byte[is.available()];//为了解决部分中文乱码问题，一次读取所有的
            while ((len = is.read(buf)) != -1) {
                sb.append(new String(buf, 0, len, "UTF-8"));
            }
            is.close();
            jsonString = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    public List<LinkDataBean> mockLinkLineData(Context context, int index) {
        if (context == null) {
            return null;
        }
        List<LinkDataBean> mockResp = new ArrayList<>();
        StringBuilder sb = new StringBuilder("linkline/data_json");
        sb.append(index);
        sb.append(".json");
        if (!TextUtils.isEmpty(sb.toString())) {
            String jsonString = getJsonFromAssets(context, sb.toString());
            Type type = new TypeToken<ArrayList<LinkDataBean>>() {
            }.getType();
            try {
                mockResp = new Gson().fromJson(jsonString, type);
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
            }
        }
        return mockResp;
    }
}
