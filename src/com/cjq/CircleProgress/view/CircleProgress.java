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
        //��ʼ���ܶ๤�ߣ�����

        paint = new Paint();
//        paint.setColor(color);//������ɫ
        paint.setStrokeWidth(strokeWidth);//���û��ʿ��
        paint.setStyle(style);//���û�����ʽ���οջ������

        //��ʼ��Բ�ν�����λ�þ���
        rect = new RectF(50,50,200,200);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //��������ǰ��������͸��ɫ��ջ���
        canvas.drawColor(android.R.color.transparent);
        //���ƽ�����Բ�Σ�����䣩
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
