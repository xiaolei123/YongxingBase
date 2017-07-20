package com.yongxing.yongxingbase.Activity;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.xiaolei.easyfreamwork.common.listeners.Action;
import com.xiaolei.easyfreamwork.utils.Log;
import com.yongxing.yongxingbase.Adapter.PageAdapter;
import com.yongxing.yongxingbase.Base.BaseV4Activity;
import com.yongxing.yongxingbase.Base.BaseV4Fragment;
import com.yongxing.yongxingbase.Fragment.HomeFragment;
import com.yongxing.yongxingbase.Fragment.LicaiFragment;
import com.yongxing.yongxingbase.Fragment.MineFragment;
import com.yongxing.yongxingbase.Fragment.MoreFragment;
import com.yongxing.yongxingbase.R;
import com.yongxing.yongxingbase.Util.PermisstionUtil;

import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;


public class MainActivity extends BaseV4Activity
{
    @BindView(R.id.radio_group)
    RadioGroup radio_group;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    private HomeFragment homeFragment;      // 这里保持一个强引用，避免保存在list里面弱引用被虚拟机回收
    private LicaiFragment licaiFragment;    // 这里保持一个强引用，避免保存在list里面弱引用被虚拟机回收
    private MineFragment mineFragment;      // 这里保持一个强引用，避免保存在list里面弱引用被虚拟机回收
    private MoreFragment moreFragment;      // 这里保持一个强引用，避免保存在list里面弱引用被虚拟机回收
    private List<BaseV4Fragment> fragmentList = new LinkedList<>();
    private PageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initObj()
    {
        homeFragment = new HomeFragment();
        licaiFragment = new LicaiFragment();
        mineFragment = new MineFragment();
        moreFragment = new MoreFragment();
        if (fragmentList.size() <= 0)
        {
            fragmentList.add(homeFragment);
            fragmentList.add(licaiFragment);
            fragmentList.add(mineFragment);
            fragmentList.add(moreFragment);
        }
        pageAdapter = new PageAdapter(getSupportFragmentManager(), fragmentList);
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
        viewpager.setAdapter(pageAdapter);
        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId)
            {
                switch (checkedId)
                {
                    case R.id.home:
                        if (viewpager.getCurrentItem() != 0)
                            viewpager.setCurrentItem(0);
                        break;
                    case R.id.licai:
                        if (viewpager.getCurrentItem() != 1)
                            viewpager.setCurrentItem(1);
                        break;
                    case R.id.mine:
                        if (viewpager.getCurrentItem() != 2)
                            viewpager.setCurrentItem(2);
                        break;
                    case R.id.more:
                        if (viewpager.getCurrentItem() != 3)
                            viewpager.setCurrentItem(3);
                        break;
                }
            }
        });
        viewpager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener()
        {
            @Override
            public void onPageSelected(int position)
            {
                ((RadioButton) radio_group.getChildAt(position)).setChecked(true);
                switch (position)
                {
                    case 0:
                        homeFragment.OnPageSeleted();
                        break;
                    case 1:
                        licaiFragment.OnPageSeleted();
                        break;
                    case 2:
                        mineFragment.OnPageSeleted();
                        break;
                    case 3:
                        moreFragment.OnPageSeleted();
                        break;
                }
            }
        });
    }

    @Override
    public void loadData()
    {
        ((RadioButton) radio_group.getChildAt(0)).setChecked(true);
        PermisstionUtil.checkPermisstion(this,new String[]{
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
        });
    }

    @Override
    protected void onDestroy()
    {
        viewpager.removeAllViews();
        viewpager.setAdapter(null);
        fragmentList.clear();
        super.onDestroy();
    }

    private int clickTime = 0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            Log.e("ClickBACK", "判断是否是0？" + clickTime);
            if (clickTime == 0)
            {
                Log.e("ClickBACK", "是0" + clickTime);
                clickTime = 1;
                handler.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        Log.e("ClickBACK", "handler是" + clickTime);
                        if (clickTime == 1)
                        {
                            moveTaskToBack(false);
                            Log.e("ClickBACK", "moveTaskToBack(false)");
                        } else
                        {
                            Log.e("ClickBACK", "是否退出程序？");
                            Alert("是否退出程序？", "否", null, "是", new Action()
                            {
                                @Override
                                public void action()
                                {
                                    finish();
                                }
                            });
                        }
                        clickTime = 0;
                    }
                }, 200);
            } else
            {
                clickTime = 2;
            }
            return super.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }
}
