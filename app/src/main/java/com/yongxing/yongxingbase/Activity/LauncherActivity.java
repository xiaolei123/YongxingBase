package com.yongxing.yongxingbase.Activity;

import android.os.Bundle;

import com.yongxing.yongxingbase.Base.BaseActivity;
import com.yongxing.yongxingbase.R;

import butterknife.OnClick;

/**
 * Created by admin on 2017/7/19.
 */

public class LauncherActivity extends BaseActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
    }

    @Override
    public void initObj()
    {

    }

    @Override
    public void initData()
    {

    }

    @Override
    public void initView()
    {

    }

    @Override
    public void setListener()
    {

    }
    
    @OnClick(R.id.textview)
    public void clickText()
    {
        
    }
    
    @Override
    public void loadData()
    {
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                startActivity(MainActivity.class);
                finish();
            }
        }, 1500);
    }

    

}
