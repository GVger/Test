package cn.vger.service;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;

public class LrcView extends TextView implements Runnable {

	private LrcPlay lrcPlay;
	private String lrcPath ="null";
	private long currentTime;
	private Paint currentPaint, oldPaint;

	private float width;
	private float height;
	private float textHeight = 40;
	private float oldTextSize = 20;

	private Canvas canvas;
	private Handler handler;

	private boolean isShowLrc = true;

	public LrcView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public LrcView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public LrcView(Context context) {
		super(context);
		init();
	}

	private void init() {
		setFocusable(true);// 焦点

		currentPaint = new Paint();
		currentPaint.setAntiAlias(true);
		currentPaint.setTextAlign(Paint.Align.CENTER);// 文本中间对齐

		oldPaint = new Paint();
		oldPaint.setAntiAlias(true);
		oldPaint.setTextAlign(Paint.Align.CENTER);// 文本中间对齐
	}

	public void setLrc(String lrcPath) {
		lrcPlay = new LrcPlay(lrcPath);
		this.lrcPath = lrcPath;
	}

	public void setCurrentTime(long currentTime) {
		this.currentTime = currentTime;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		this.canvas = canvas;
		if (handler == null) {
			handler = new Handler();
			handler.post(this);
		}
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		this.width = w;
		this.height = h;
	}

	@Override
	public void run() {
		if (isShowLrc) {
			handler.postDelayed(this, 500);
			if (canvas == null) {
				return;
			}
			currentPaint.setColor(Color.RED);
			oldPaint.setColor(Color.WHITE);

			currentPaint.setTextSize(28);
			currentPaint.setTypeface(Typeface.SERIF);

			oldPaint.setTextSize(oldTextSize);
			oldPaint.setTypeface(Typeface.DEFAULT);

			setText("");
			if (lrcPath.equals("null")) {
				canvas.drawText("没有歌词", width / 2, height / 2, currentPaint);
			} else {
				canvas.drawText(lrcPlay.getLrc(currentTime), width / 2,
						height / 2, currentPaint);

				float tempY = height / 2;

				for (int i = (lrcPlay.getLrcIndex(currentTime) - 1); i >= 0; i--) {
					tempY = tempY - textHeight;
					canvas.drawText(lrcPlay.getLrcFromIndex(i), width / 2,
							tempY, oldPaint);
				}
				tempY = height / 2;
				for (int i = (lrcPlay.getLrcIndex(currentTime) + 1); i < lrcPlay
						.getIndexMax(); i++) {
					tempY = tempY + textHeight;
					canvas.drawText(lrcPlay.getLrcFromIndex(i), width / 2,
							tempY, oldPaint);
				}
			}
		}
	}
	
	@Override
	protected void onDetachedFromWindow() {
		isShowLrc = false;
		super.onDetachedFromWindow();
	}
}