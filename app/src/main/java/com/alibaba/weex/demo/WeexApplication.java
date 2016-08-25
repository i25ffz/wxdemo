package com.alibaba.weex.demo;

import android.app.Application;
import com.taobao.weex.InitConfig;
import com.taobao.weex.WXSDKEngine;

/**
 * Created by qijian on 16/7/22.
 */
public class WeexApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        InitConfig.Builder builder = new InitConfig.Builder();
        builder.setImgAdapter(new ImageAdapter());
//        builder.setHttpAdapter(new DefaultWXHttpAdapter());
        InitConfig config = builder.build();
        WXSDKEngine.initialize(this,config);
    }
}
