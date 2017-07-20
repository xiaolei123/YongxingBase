package com.yongxing.yongxingbase.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yongxing.yongxingbase.Base.BaseV4Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 统一的 FragmentPagerAdapter
 * Created by admin on 2017/7/19.
 */

public class PageAdapter extends FragmentPagerAdapter
{
    private List<BaseV4Fragment> fragmentList;
    private List<Fragment> pages = new ArrayList<Fragment>();
    public PageAdapter(FragmentManager fm, List<BaseV4Fragment> fragmentList)
    {
        super(fm);
        this.fragmentList = fragmentList;
    }
    @Override
    public Fragment getItem(int position)
    {
        Fragment page = null;
        if (pages.size() > position)
        {
            page = pages.get(position);
            if (page != null)
            {
                return page;
            }
        }
        while (position >= pages.size())
        {
            pages.add(null);
        }
        page = fragmentList.get(position);
        pages.set(position, page);
        //return fragmentList.get(position);
        return page;
    }
    
    @Override
    public int getCount()
    {
        return fragmentList.size();
    }
}
