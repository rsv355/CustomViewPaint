package com.example.krishnakumar.customviewpaint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by krishnakumar on 12-02-2016.
 */
public class MyView extends View {

    private Paint _paint;
    private Path _path;

    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        _paint = new Paint();
        _path = new Path();
        _paint.setColor(Color.BLUE);
        _paint.setAntiAlias(true);
        _paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(_path,_paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchx = event.getX();
        float touchy = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                _path.moveTo(touchx,touchy);
                break;
            case MotionEvent.ACTION_MOVE:
                _path.lineTo(touchx,touchy);
                break;
            case MotionEvent.ACTION_UP:
                break;

        }
        invalidate();
        return true;
    }
}
