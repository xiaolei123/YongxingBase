package com.yongxing.yongxingbase;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.xiaolei.easyfreamwork.Config.Config;
import com.xiaolei.easyfreamwork.application.ApplicationBreage;
import com.xiaolei.easyfreamwork.application.IApp;
import com.yongxing.yongxingbase.Config.Globals;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by admin on 2017/7/18.
 */

public class YXAPP extends android.support.multidex.MultiDexApplication implements IApp
{
    private Map<String,String> headers = new LinkedHashMap<>();
    @Override
    public void onCreate()
    {
        headers.put("Ag-Client","Android");
        Config config = new Config();
        config.setBaseUrl(Globals.SERVER_ADDRESS);
        config.setDEBUG(BuildConfig.DEBUG);
        config.setNetHeadeMap(headers);
        ApplicationBreage.getInstance().initApplication(this,config);
        super.onCreate();
    }

    @Override
    public void addActivity(Activity activity)
    {
        
    }

    @Override
    public void removeActivity(Activity activity)
    {

    }

    @Override
    public void removeAllActivity()
    {

    }

    @Override
    public Application getApplication()
    {
        return this;
    }
    

    @Override
    public Context getContext()
    {
        return this;
    }
}
