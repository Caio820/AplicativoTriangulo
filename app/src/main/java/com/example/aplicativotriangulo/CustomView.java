package com.example.aplicativotriangulo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class CustomView extends View {

    private Paint paint;

    public CustomView(Context context) {
        super(context);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();

        paint.setColor(android.graphics.Color.parseColor("#94D3B34F"));
        canvas.drawPaint(paint);

        //paint.setStrokeWidth(10);
        paint.setColor(android.graphics.Color.RED);
        //paint.setAntiAlias(true);

        Path path = new Path();

        path.moveTo(1000, 850);
        path.lineTo(400,900);
        path.lineTo(670,250);

        canvas.drawPath(path, paint);

    }


}
