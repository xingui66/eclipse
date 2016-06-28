package com.example.klok;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;

public class klokview extends TextView {

	private Paint mPaintBg;
	private Paint mPaintFore;
	private int mRectWidth;
	
	public klokview(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		
		mRectWidth=0;
		
		initPaint();
		//timerFresh();
	}

	public klokview(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public klokview(Context context) {
		this(context, null);
	}
	
	private void initPaint() {
		//初始化画笔
		mPaintBg=new Paint();
		mPaintBg.setColor(Color.RED);
		mPaintBg.setTextSize(30);
		mPaintBg.setAntiAlias(true);
		
		mPaintFore=new Paint();
		mPaintFore.setColor(Color.BLUE);
		mPaintFore.setTextSize(30);
		mPaintFore.setAntiAlias(true);
		
		
	}
	/*private void timerFresh() {
		postDelayed(new Runnable(){
            public void run(){
                mRectWidth++;
                invalidate();//加后注意重绘
                postDelayed(this,10);
            }
       },10);
	}
*/

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		canvas.drawText("北京欢迎你！", 30, 30, mPaintBg);
		canvas.clipRect(new RectF(0,0,mRectWidth,80));
		canvas.drawText("北京欢迎你！", 30, 30, mPaintFore);
		
		if(mRectWidth>200){
			mRectWidth=0;
		}
		mRectWidth++;
        invalidate();//加后注意重绘
		
	}
	

}
