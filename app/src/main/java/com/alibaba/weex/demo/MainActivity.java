package com.alibaba.weex.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXRenderStrategy;

public class MainActivity extends AppCompatActivity {

    private FrameLayout mContainer;
    protected WXSDKInstance mWeexInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContainer = (FrameLayout)findViewById(R.id.container);
        mWeexInstance = new WXSDKInstance(this);
        mWeexInstance.registerRenderListener(new IWXRenderListener() {
            @Override
            public void onViewCreated(WXSDKInstance wxsdkInstance, View view) {
                if (mContainer != null){
                    mContainer.addView(view);
                }
            }

            @Override
            public void onRenderSuccess(WXSDKInstance wxsdkInstance, int i, int i1) {
                Log.w("Weex", "onRenderSuccess calling...");
            }

            @Override
            public void onRefreshSuccess(WXSDKInstance wxsdkInstance, int i, int i1) {
                Log.w("Weex", "onRefreshSuccess calling...");
            }

            @Override
            public void onException(WXSDKInstance wxsdkInstance, String s, String s1) {
                Log.e("Weex", "onException calling...");
            }
        });
        //http://100.84.44.83:8081/weex_tmp/h5_render/tech_list.js?wsport=8082
        //mWeexInstance.render("qijianWeex", WXFileUtils.loadFileContent("tech_list.js", this), null, null, -1, -1, WXRenderStrategy.APPEND_ASYNC);
        mWeexInstance.renderByUrl("wxdemo", "http://100.84.44.83:8081/weex_tmp/h5_render/tech_list.js?wsport=8082", null, null, -1, -1, WXRenderStrategy.APPEND_ASYNC);
    }
}
