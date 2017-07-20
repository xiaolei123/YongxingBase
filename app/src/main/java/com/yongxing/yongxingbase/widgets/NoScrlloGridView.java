package com.yongxing.yongxingbase.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by xiaolei on 2017/3/28.
 */

public class NoScrlloGridView extends GridView
{
    public NoScrlloGridView(Context context)
    {
        super(context);
    }

    public NoScrlloGridView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public NoScrlloGridView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
