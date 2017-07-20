package com.tianjs.tianjinsuop2p.widgets

import android.content.Context
import android.support.annotation.AttrRes
import android.support.annotation.DrawableRes
import android.text.TextUtils
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.yongxing.yongxingbase.R
import com.yongxing.yongxingbase.Util.DensityUtil

/**
 * Created by xiaolei on 2017/5/10.
 */

class ContextTitle @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, @AttrRes defStyleAttr: Int = 0) : FrameLayout(context, attrs, defStyleAttr)
{
    private var ViewWidth: Int = 0
    private var ViewHeight: Int = 0
    private var leftTextVisible = View.VISIBLE
    private var leftText: CharSequence = ""
    private var leftTextSize = 14f
    private var leftTextColor = 0xff000000.toInt()
    private var leftImage = R.mipmap.ic_launcher
    private var leftImageVisible = View.VISIBLE
    private var titleText: CharSequence = ""
    private var titleTextSize = 14f
    private var titleTextColor = 0xff000000.toInt()
    private var titleVisible = View.VISIBLE
    private var titleRightImg = -1
    private var rightImage = R.mipmap.ic_launcher
    private var rightImageVisible = View.VISIBLE
    private var rightTextVisible = View.VISIBLE
    private var rightText: CharSequence = ""
    private var rightTextSize = 14f
    private var rightTextColor = 0xff000000.toInt()
    private var titleScrllo = false
    /* -------------初始化UI----------------- */

    val leftImgView by lazy {
        ImageView(context).apply {
            layoutParams = LinearLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.MATCH_PARENT).apply {

            }
            setImageResource(leftImage)
            setPadding(DensityUtil.dip2px(context, 15f), 0, DensityUtil.dip2px(context, 15f), 0)
            scaleType = ImageView.ScaleType.CENTER_INSIDE
            visibility = leftImageVisible
        }
    }

    private val leftTextview by lazy {
        TextView(context).apply {
            layoutParams = LinearLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.MATCH_PARENT).apply {
                setMargins(DensityUtil.dip2px(context, 8f), DensityUtil.dip2px(context, 0f), DensityUtil.dip2px(context, -8f), DensityUtil.dip2px(context, 0f))
            }
            text = leftText
            gravity = Gravity.CENTER
            setTextColor(leftTextColor)
            setTextSize(TypedValue.COMPLEX_UNIT_SP, leftTextSize)
            visibility = leftTextVisible
        }
    }
    private val titleTextview by lazy {
        TitleTextView(context).apply {
            layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT, Gravity.CENTER)
            layoutParams = layoutParams
            text = titleText
            gravity = Gravity.CENTER
            setTextSize(TypedValue.COMPLEX_UNIT_SP, titleTextSize)
            visibility = titleVisible
            setTextColor(titleTextColor)
            setSingleLine()
            if (titleScrllo)
            {
                ellipsize = TextUtils.TruncateAt.MARQUEE
                marqueeRepeatLimit = -1
                isFocusable = true
                setHorizontallyScrolling(true)
                isFocusableInTouchMode = true
            }
            if (titleRightImg > -1)
            {
                val drawable = context.resources.getDrawable(titleRightImg)
                drawable.setBounds(0, 0, drawable.minimumWidth, drawable.minimumHeight)
                setCompoundDrawables(null, null, drawable, null)
                compoundDrawablePadding = DensityUtil.dip2px(context, 5f)
            }
        }
    }
    private val rightTextview by lazy {
        TextView(context).apply {
            layoutParams = LinearLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.MATCH_PARENT).apply {
                setMargins(DensityUtil.dip2px(context, -8f), DensityUtil.dip2px(context, 0f), DensityUtil.dip2px(context, 8f), DensityUtil.dip2px(context, 0f))
            }
            text = rightText
            gravity = Gravity.CENTER
            setTextColor(rightTextColor)
            visibility = rightTextVisible
            setTextSize(TypedValue.COMPLEX_UNIT_SP, rightTextSize)
        }
    }
    val rightImgView by lazy {
        ImageView(context).apply {
            layoutParams = LinearLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.MATCH_PARENT)
            setImageResource(rightImage)
            setPadding(DensityUtil.dip2px(context, 15f), 0, DensityUtil.dip2px(context, 15f), 0)
            visibility = rightImageVisible
            scaleType = ImageView.ScaleType.CENTER_INSIDE
        }
    }


    private val linearLayout by lazy {
        LinearLayout(context).apply {
            layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
        }
    }
    private val lineView by lazy {
        View(context).apply {
            layoutParams = LinearLayout.LayoutParams(DensityUtil.dip2px(context, 0f), DensityUtil.dip2px(context, 1f), 1f)
        }
    }

    init
    {
        val array = getContext().obtainStyledAttributes(attrs, R.styleable.ContextTitle)
        leftTextVisible = if (array.getBoolean(R.styleable.ContextTitle_leftTextVisible, false)) View.VISIBLE else View.GONE
        leftText = array.getText(R.styleable.ContextTitle_leftText) ?: "Left"
        leftTextSize = array.getInt(R.styleable.ContextTitle_leftTextSize, 14).toFloat()
        leftTextColor = array.getColor(R.styleable.ContextTitle_leftTextColor, 0xff000000.toInt())

        leftImageVisible = if (array.getBoolean(R.styleable.ContextTitle_leftImgVisible, false)) View.VISIBLE else View.GONE
        leftImage = array.getResourceId(R.styleable.ContextTitle_leftImg, R.mipmap.ic_launcher)

        titleText = array.getText(R.styleable.ContextTitle_titleText) ?: "Title"
        titleTextSize = array.getInt(R.styleable.ContextTitle_titleTextSize, 14).toFloat()
        titleTextColor = array.getColor(R.styleable.ContextTitle_titleTextColor, 0xff000000.toInt())
        titleVisible = if (array.getBoolean(R.styleable.ContextTitle_titleVisible, true)) View.VISIBLE else View.GONE
        titleRightImg = array.getResourceId(R.styleable.ContextTitle_titleRightImg, -1)

        rightImageVisible = if (array.getBoolean(R.styleable.ContextTitle_rightImgVisible, false)) View.VISIBLE else View.GONE
        rightImage = array.getResourceId(R.styleable.ContextTitle_rightImg, R.mipmap.ic_launcher)

        rightTextVisible = if (array.getBoolean(R.styleable.ContextTitle_rightTextVisible, false)) View.VISIBLE else View.GONE
        rightText = array.getText(R.styleable.ContextTitle_rightText) ?: "Right"
        rightTextSize = array.getInt(R.styleable.ContextTitle_rightTextSize, 14).toFloat()
        rightTextColor = array.getColor(R.styleable.ContextTitle_rightTextColor, 0xff000000.toInt())

        titleScrllo = array.getBoolean(R.styleable.ContextTitle_titleScrllo, false)

        array.recycle()
        InitUI()
    }

    private fun InitUI()
    {
        /* --------组合在一起---------- */
        linearLayout.addView(leftImgView)
        linearLayout.addView(leftTextview)
        this.addView(titleTextview)
        linearLayout.addView(lineView)
        linearLayout.addView(rightTextview)
        linearLayout.addView(rightImgView)
        this.addView(linearLayout)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int)
    {
        // 父容器传过来的宽度的值
        ViewWidth = View.MeasureSpec.getSize(widthMeasureSpec) - paddingLeft - paddingRight
        // 父容器传过来的高度的值
        ViewHeight = View.MeasureSpec.getSize(heightMeasureSpec) - paddingLeft - paddingRight

        if (titleScrllo)
        {
            val layoutParams = titleTextview.layoutParams
            layoutParams.width = ViewWidth * 4 / 9
            titleTextview.layoutParams = layoutParams
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }


    fun setLeftTextVisible(leftTextVisible: Int)
    {
        this.leftTextVisible = leftTextVisible
    }

    fun setLeftText(leftText: CharSequence)
    {
        this.leftText = leftText
    }

    /**
     * 默认单位SP

     * @param leftTextSize
     */
    fun setLeftTextSize(leftTextSize: Float?)
    {
        this.leftTextSize = leftTextSize!!
    }

    fun setLeftTextColor(leftTextColor: Int)
    {
        this.leftTextColor = leftTextColor
    }

    fun setLeftImage(leftImage: Int)
    {
        this.leftImage = leftImage
    }

    fun setLeftImageVisible(leftImageVisible: Int)
    {
        this.leftImageVisible = leftImageVisible
    }

    fun setTitleText(titleText: CharSequence)
    {
        this.titleText = titleText
        titleTextview.text = titleText
    }

    /**
     * 默认单位SP

     * @param titleTextSize
     */
    fun setTitleTextSize(titleTextSize: Float)
    {
        this.titleTextSize = titleTextSize
    }

    fun setTitleTextColor(titleTextColor: Int)
    {
        this.titleTextColor = titleTextColor
    }

    fun setTitleVisible(titleVisible: Int)
    {
        this.titleVisible = titleVisible
    }

    fun setRightImage(rightImage: Int)
    {
        this.rightImage = rightImage
    }

    fun setRightImageVisible(rightImageVisible: Int)
    {
        this.rightImageVisible = rightImageVisible
    }

    fun setRightTextVisible(rightTextVisible: Int)
    {
        this.rightTextVisible = rightTextVisible
    }

    fun setRightText(rightText: CharSequence)
    {
        this.rightText = rightText
    }

    /**
     * 默认单位SP

     * @param rightTextSize
     */
    fun setRightTextSize(rightTextSize: Float)
    {
        this.rightTextSize = rightTextSize
    }

    fun setRightTextColor(rightTextColor: Int)
    {
        this.rightTextColor = rightTextColor
    }
    
    fun setOnLeftImageClick(listener: View.OnClickListener) {
        leftImgView.setOnClickListener(listener)
    }
    
    fun setOnLeftTextClick(listener: View.OnClickListener)
    {
        leftTextview.setOnClickListener(listener)
    }

    fun setOnTitleClick(listener: View.OnClickListener)
    {
        titleTextview.setOnClickListener(listener)
    }

    fun setOnRightTextClick(listener: View.OnClickListener)
    {
        rightTextview.setOnClickListener(listener)
    }

    fun setOnRightImageClick(listener: View.OnClickListener)
    {
        rightImgView.setOnClickListener(listener)
    }

    fun setTitleRightImg(@DrawableRes titleRightImg: Int)
    {
        this.titleRightImg = titleRightImg
        if (titleRightImg > -1)
        {
            val rightDrawable = context.resources.getDrawable(titleRightImg)
            rightDrawable.setBounds(0, 0, rightDrawable.minimumWidth, rightDrawable.minimumHeight)
            titleTextview.setCompoundDrawables(null, null, rightDrawable, null)
            titleTextview.compoundDrawablePadding = DensityUtil.dip2px(context, 5f)
        }
    }

    /**
     * 获取标题文字

     * @return
     */
    fun getTitleText(): String
    {
        return titleTextview.text.toString()
    }

    fun setLeftTextTag(tag: Any)
    {
        leftTextview.tag = tag
    }

    fun <T> getLeftTextTag(): T
    {
        return leftTextview.tag as T
    }

    fun setLeftImgTag(tag: Any)
    {
        leftImgView.tag = tag
    }

    fun <T> getLeftImgTag(): T
    {
        return leftImgView.tag as T
    }

    fun setTitleTextTag(tag: Any)
    {
        titleTextview.tag = tag
    }

    fun <T> getTitleTextTag(): T
    {
        return titleTextview.tag as T
    }

    fun setRightTextTag(tag: Any)
    {
        rightTextview.tag = tag
    }

    fun <T> getRightTextTag(): T
    {
        return rightTextview.tag as T
    }

    fun setRightImgTag(tag: Any)
    {
        rightImgView.tag = tag
    }

    fun <T> getRightImgTag(): T
    {
        return rightImgView.tag as T
    }
}

class TitleTextView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : TextView(context, attrs, defStyleAttr)
{
    override fun isFocused(): Boolean
    {
        return true
    }
}