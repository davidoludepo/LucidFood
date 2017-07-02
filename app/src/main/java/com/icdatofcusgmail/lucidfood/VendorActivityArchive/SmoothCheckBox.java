package com.icdatofcusgmail.lucidfood.VendorActivityArchive;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;

import com.icdatofcusgmail.lucidfood.R;

public class SmoothCheckBox extends View implements View.OnClickListener {

    public long duration;
    public float mStrokeWidth;
    public float mTickWidth;
    public Paint trimPaint;
    public Paint borderPaint;
    public Paint tickPaint;
    public float defaultStrikeWidth;
    public float defaultTickWidth;
    public int mWidth;
    public int mHeight;
    public int borderColor;
    public int trimColor;
    public int tickColor;
    public int mRadius;
    public int center;
    public boolean isChecked;
    public float downLength;
    public float upLength;
    public float totalLength;

    public OnCheckedChangeListener listener;

    public ValueAnimator mValueAnimator;

    public ValueAnimator mTickValueAnimator;

    public float animatedValue;

    public float tickValue;

    public Point startPoint = new Point();

    public Point breakPoint = new Point();

    public Point endPoint = new Point();

    public static final String TAG = "SmoothCheckBox";

    public static final String KEY_INSTANCE_STATE = "InstanceState";

    public Path path = new Path();

    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        this.listener = listener;
    }

    public SmoothCheckBox(Context context) {
        this(context, null);
    }

    public SmoothCheckBox(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SmoothCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.SmoothCheckBox);
        duration = a.getInt(R.styleable.SmoothCheckBox_duration, 600);

        defaultStrikeWidth = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, getResources().getDisplayMetrics());
        mStrokeWidth = a.getDimension(R.styleable.SmoothCheckBox_strikeWidth, defaultStrikeWidth);
        defaultTickWidth = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, getResources().getDisplayMetrics());
        mTickWidth = a.getDimension(R.styleable.SmoothCheckBox_tickWidth, defaultTickWidth);
        borderColor = a.getColor(R.styleable.SmoothCheckBox_borderColor, getResources().getColor(android.R.color.darker_gray));
        trimColor = a.getColor(R.styleable.SmoothCheckBox_trimColor, getResources().getColor(android.R.color.holo_green_light));
        tickColor = a.getColor(R.styleable.SmoothCheckBox_tickColor, getResources().getColor(android.R.color.white));
        a.recycle();

        trimPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        trimPaint.setStyle(Paint.Style.FILL);
        trimPaint.setColor(trimColor);

        borderPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        borderPaint.setStrokeWidth(mStrokeWidth);
        borderPaint.setColor(borderColor);
        borderPaint.setStyle(Paint.Style.STROKE);

        tickPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        tickPaint.setColor(tickColor);
        tickPaint.setStyle(Paint.Style.STROKE);
        tickPaint.setStrokeCap(Paint.Cap.ROUND);
        tickPaint.setStrokeWidth(mTickWidth);

        setOnClickListener(this);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        if (widthMode == MeasureSpec.EXACTLY) {
            mWidth = widthSize;
        } else {
            mWidth = 40;
        }

        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        if (heightMode == MeasureSpec.EXACTLY) {
            mHeight = heightSize;
        } else {
            mHeight = 40;
        }
        setMeasuredDimension(mWidth, mHeight);
        int size = Math.min(mWidth, mHeight);
        center = size / 2;
        mRadius = (int) ((size - mStrokeWidth) / 2 / 1.2f);
        startPoint.set(center * 14 / 30, center * 28 / 30);
        breakPoint.set(center * 26 / 30, center * 40 / 30);
        endPoint.set(center * 44 / 30, center * 20 / 30);

        downLength = (float) Math.sqrt(Math.pow(startPoint.x - breakPoint.x, 2f) + Math.pow(startPoint.y - breakPoint.y, 2f));
        upLength = (float) Math.sqrt(Math.pow(endPoint.x - breakPoint.x, 2f) + Math.pow(endPoint.y - breakPoint.y, 2f));
        totalLength = downLength + upLength;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        drawBorder(canvas);
        drawTrim(canvas);
        if (isChecked) {
            drawTick(canvas);
        }
        canvas.restore();
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_INSTANCE_STATE, super.onSaveInstanceState());
        bundle.putBoolean(KEY_INSTANCE_STATE, isChecked);
        return bundle;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            boolean isChecked = bundle.getBoolean(KEY_INSTANCE_STATE);
            setChecked(isChecked);
            super.onRestoreInstanceState(bundle.getParcelable(KEY_INSTANCE_STATE));
            return;
        }
        super.onRestoreInstanceState(state);
    }


    public void toggle() {
        isChecked = !isChecked;
        if (listener != null) {
            listener.onCheckedChanged(this, isChecked);
        }
        if (isChecked) {
            checkedAnimation();
        } else {
            uncheckedAnimation();
        }
    }


    public void checkedAnimation() {
        animatedValue = 0f;
        tickValue = 0f;
        mValueAnimator = ValueAnimator.ofFloat(0f, 1.2f, 1f).setDuration(2 * duration / 5);
        mValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        mTickValueAnimator = ValueAnimator.ofFloat(0f, 1f).setDuration(3 * duration / 5);
        mTickValueAnimator.setInterpolator(new LinearInterpolator());
        mTickValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                tickValue = (float) valueAnimator.getAnimatedValue();
                postInvalidate();
            }
        });
        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                animatedValue = (float) valueAnimator.getAnimatedValue();
                postInvalidate();
            }
        });
        mValueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mTickValueAnimator.start();
                Log.i(TAG," mTickValueAnimator.start();");
            }
        });
        mValueAnimator.start();
    }


    public void uncheckedAnimation() {
        animatedValue = 0f;
        mValueAnimator = ValueAnimator.ofFloat(1f, 0f).setDuration(2 * duration / 5);
        mValueAnimator.setInterpolator(new AccelerateInterpolator());
        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                animatedValue = (float) valueAnimator.getAnimatedValue();
                postInvalidate();
            }
        });
        mValueAnimator.start();
    }


    public void drawTick(Canvas canvas) {
        float temp = tickValue * totalLength;
        Log.i(TAG, "temp:" + temp + "downlength :" + downLength);
        if (Float.compare(tickValue, 0f) == 0) {
            Log.i(TAG, "startPoint : " + startPoint.x + ", " + startPoint.y);
            path.reset();
            path.moveTo(startPoint.x, startPoint.y);
        }
        if (temp > downLength) {
            path.moveTo(startPoint.x, startPoint.y);
            path.lineTo(breakPoint.x, breakPoint.y);
            Log.i(TAG, "endPoint : " + endPoint.x + ", " + endPoint.y);
            path.lineTo((endPoint.x - breakPoint.x) * (temp - downLength) / upLength + breakPoint.x, (endPoint.y - breakPoint.y) * (temp - downLength) / upLength + breakPoint.y);
        } else {
            Log.i(TAG, "down x : " + (breakPoint.x - startPoint.x) * temp / downLength + ",down y: " + (breakPoint.y - startPoint.y) * temp / downLength);
            path.lineTo((breakPoint.x - startPoint.x) * temp / downLength + startPoint.x, (breakPoint.y - startPoint.y) * temp / downLength + startPoint.y);
        }
        canvas.drawPath(path, tickPaint);
    }


    public void drawBorder(Canvas canvas) {
        float temp;
        if (animatedValue > 1f) {
            temp = animatedValue * mRadius;
        } else {
            temp = mRadius;
        }
        canvas.drawCircle(center, center, temp, borderPaint);
    }


    public void drawTrim(Canvas canvas) {
        canvas.drawCircle(center, center, (mRadius - mStrokeWidth) * animatedValue, trimPaint);
    }

    @Override
    public void onClick(View view) {
        toggle();
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean isChecked) {
        this.setChecked(isChecked, false);
    }

    public void setChecked(boolean isChecked, boolean isAnimation) {
        this.isChecked = isChecked;
        if (isAnimation) {
            if (isChecked) {
                checkedAnimation();
            } else {
                uncheckedAnimation();
            }
        } else {
            animatedValue = isChecked ? 1f : 0f;
            tickValue = 1f;
            invalidate();
        }
        if (listener != null) {
            listener.onCheckedChanged(this, isChecked);
        }
    }

    public interface OnCheckedChangeListener {
        void onCheckedChanged(SmoothCheckBox smoothCheckBox, boolean isChecked);
    }
}
