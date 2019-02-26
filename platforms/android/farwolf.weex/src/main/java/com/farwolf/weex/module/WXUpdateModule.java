package com.farwolf.weex.module;

import android.app.Notification;

import com.farwolf.update.UpdateService;
import com.farwolf.update.UpdateService_;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.WXModule;

import java.util.HashMap;

/**
 * Created by zhengjiangrong on 2018/3/22.
 */

public class WXUpdateModule extends WXModule {



    @JSMethod
    public void docheck(HashMap param)
    {
        String appid=param.get("appid")+"";
        String vcurl=param.get("url")+"";
        String theme=param.containsKey("theme")?param.get("theme")+"":null;
        boolean failtoast=param.containsKey("failtoast")?(boolean)param.get("failtoast"):false;
        boolean showprogress=param.containsKey("showprogress")?(boolean)param.get("showprogress"):false;


        UpdateService updateService= UpdateService_.getInstance_(mWXSDKInstance.getContext());
         updateService.init(appid,vcurl,theme);
         updateService.doCheck(failtoast,showprogress);
    }



    @JSMethod
    public void download(String url)
    {
        com.farwolf.update.download.UpdateService.Builder.create(url)
                .setStoreDir(null)
                .setDownloadSuccessNotificationFlag(Notification.DEFAULT_ALL)
                .setDownloadErrorNotificationFlag(Notification.DEFAULT_ALL)
                .build(mWXSDKInstance.getContext());

    }


}
