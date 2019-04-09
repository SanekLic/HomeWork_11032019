package com.my.homework_11032019;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CompoundView extends LinearLayout {
    private ImageView iconImageView;

    public CompoundView(Context context) {
        super(context);

        initial(context);
    }

    public CompoundView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initial(context);
    }

    public CompoundView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        initial(context);
    }

    private void initial(Context context) {
        this.setOrientation(VERTICAL);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_compound, this);

        setIconImageView();
    }

    private void setIconImageView() {
        iconImageView = findViewById(R.id.iconImageView);
        iconImageView.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_colors));
    }
}
