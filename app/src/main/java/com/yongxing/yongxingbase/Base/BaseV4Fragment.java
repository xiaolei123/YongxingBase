package com.yongxing.yongxingbase.Base;


import com.xiaolei.easyfreamwork.utils.Log;

/**
 * Created by admin on 2017/7/18.
 */

public abstract class BaseV4Fragment extends com.xiaolei.easyfreamwork.base.BaseV4Fragment
{
    @Override
    protected void onSetContentView()
    {
        Log.d("BaseV4Fragment", "this.getClass():" + this.getClass());
    }
}
