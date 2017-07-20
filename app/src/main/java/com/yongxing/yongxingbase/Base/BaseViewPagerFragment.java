package com.yongxing.yongxingbase.Base;

import com.xiaolei.easyfreamwork.utils.Log;
import com.yongxing.yongxingbase.interfaces.viewpagerOnPageSeleted;

/**
 * Created by admin on 2017/7/19.
 */

public abstract class BaseViewPagerFragment extends BaseV4Fragment implements viewpagerOnPageSeleted
{
    @Override
    protected void onSetContentView()
    {
    }
    /**
     * 在ViewPager里，当被Viewpager选中的时候
     */
    @Override
    public void OnPageSeleted()
    {
        Log.d("BaseViewPagerFragment", "this.getClass():" + this.getClass());
    }
}
