package com.cjq.CircleProgress.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by android on 2015/5/14.
 */
public class CircleProgress extends View {
    private float max=100;
    private float progress=0;
    private float targetProgress=100;
    private int color = Color.RED;
    private int strokeWidth=30;
    private Paint.Style style= Paint.Style.STROKE;
    private Paint paint;
    private int color_background= Color.BLUE;
    private RectF rect;

    public void setColor(int color) {
        this.color = color;
    }

    public void setColor_background(int color_background) {
        this.color_background = color_background;
    }

    public void setStyle(Paint.Style style) {
        this.style = style;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public void setProgress(float progress) {
        this.targetProgress = progress;
    }

    public CircleProgress(Context context) {
        this(context, null);
    }

    public CircleProgress(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleProgress(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        //初始化很多工具，参数

        paint = new Paint();
//        paint.setColor(color);//画笔颜色
        paint.setStrokeWidth(strokeWidth);//设置画笔宽度
        paint.setStyle(style);//设置画笔样式，镂空还是填充

        //初始化圆形进度条位置矩形
        rect = new RectF(50,50,200,200);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //画布作画前，首先用透明色清空画布
        canvas.drawColor(android.R.color.transparent);
        //绘制进度条圆形（无填充）
        paint.setColor(color_background);

        rect.left = strokeWidth/2;
        rect.right = getWidth()-strokeWidth/2;
        rect.top = strokeWidth/2;
        rect.bottom = getHeight() -strokeWidth*2/3;
        canvas.drawArc(rect,0,360,false,paint);
        paint.setColor(color);
        if(progress<=targetProgress)
            progress+=max/100;
        int x = (int) (360*(progress/max));

        canvas.drawArc(rect,-90,x,false,paint);
        this.invalidate();
        super.onDraw(canvas);
    }
}
