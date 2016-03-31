package com.example.password.view;

import com.example.password.testgit.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by pxl on 15-10-28.
 * Description
 */
public class MyCustomView extends View {

    int textColor;

    int textSize;

    String textContent;

    /**
     * 绘制时控制文本绘制的范围
     */
    private Rect mBound;

    private Paint mPaint;

    public MyCustomView(Context context) {
        this(context, null);
    }

    public MyCustomView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.MyCustomView, defStyleAttr, 0);
        int n = typedArray.getIndexCount();
        for (int i = 0; i < n; i++) {
            int arrt = typedArray.getIndex(i);
            switch (arrt) {
                case R.styleable.MyCustomView_text_color:
                    textColor = typedArray.getColor(arrt, Color.BLACK);
                    break;
                case R.styleable.MyCustomView_content:
                    textContent = typedArray.getString(arrt);
                    break;
                case R.styleable.MyCustomView_text_size:
                    textSize = typedArray.getDimensionPixelSize(arrt, 10);
                    break;
                default:
                    break;
            }
        }
        typedArray.recycle();
        mPaint = new Paint();
        mPaint.setTextSize(textSize);
        mBound = new Rect();
        mPaint.getTextBounds(textContent, 0, textContent.length(), mBound);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec,heightMeasureSpec);
        int widthMode=MeasureSpec.getMode(widthMeasureSpec);
        int widthSize=MeasureSpec.getSize(widthMeasureSpec);
        int heightMode=MeasureSpec.getMode(heightMeasureSpec);
        int heightSize=MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;
        if(widthMode==MeasureSpec.EXACTLY){
            width=widthSize;
        }else {
            float textWidth=mBound.width();
            int desired=(int)(getPaddingLeft()+textWidth+getPaddingRight());
            width=desired;
        }

        if(heightMode==MeasureSpec.EXACTLY){
            height=heightSize;
        }else {
            float textHeight=mBound.height();
            int desired=(int)(getPaddingTop()+textHeight+getPaddingBottom());
            height=desired;
        }
        setMeasuredDimension(width,height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);
        mPaint.setColor(textColor);
        canvas.drawText(textContent, getWidth() / 2 - mBound.width() / 2,
                getHeight() / 2 + mBound.height() / 2, mPaint);
    }
}
