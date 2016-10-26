package com.example.lenovo.jiyuying20160905;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by lenovo on 2016/9/5.
 */
public class MyView extends TextView {

    private Paint paint,paint1;

    public MyView(Context context) {
        super(context);
    }
String hcolor="#ff0";
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint1 = new Paint();
        paint.setColor(Color.GRAY);
        paint1.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        paint1.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(250,50,50,paint);
        canvas.drawText("用户头像",225,50,paint1);
    }
}
