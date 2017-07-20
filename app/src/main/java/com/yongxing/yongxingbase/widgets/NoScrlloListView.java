package com.yongxing.yongxingbase.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by xiaolei on 2017/3/1.
 */

public class NoScrlloListView extends ListView
{
    public NoScrlloListView(Context context)
    {
        super(context);
    }

    public NoScrlloListView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public NoScrlloListView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }
    
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
