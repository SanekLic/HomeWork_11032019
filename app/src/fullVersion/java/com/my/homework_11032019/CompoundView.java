package com.my.homework_11032019;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class CompoundView extends LinearLayout {
    private ImageView iconImageView;
    private List<Integer> colorList;
    private ListIterator<Integer> colorListIterator;

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

    private void createColorList() {
        colorList = new ArrayList<>();
        colorList.add(ContextCompat.getColor(getContext(), R.color.colorIconOne));
        colorList.add(ContextCompat.getColor(getContext(), R.color.colorIconTwo));
        colorList.add(ContextCompat.getColor(getContext(), R.color.colorIconThree));
        colorList.add(ContextCompat.getColor(getContext(), R.color.colorIconFour));
        colorList.add(ContextCompat.getColor(getContext(), R.color.colorIconFive));
        colorList.add(ContextCompat.getColor(getContext(), R.color.colorIconSix));
        colorList.add(ContextCompat.getColor(getContext(), R.color.colorIconSeven));
        colorList.add(ContextCompat.getColor(getContext(), R.color.colorIconEight));
        colorListIterator = colorList.listIterator();
    }

    private void initial(Context context) {
        this.setOrientation(VERTICAL);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_compound, this);

        setIconImageView();
        createColorList();
        setOnClickListeners();
    }

    private void setIconImageView() {
        iconImageView = findViewById(R.id.iconImageView);
        iconImageView.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_colors));
    }

    private void setOnClickListeners() {
        iconImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!colorListIterator.hasNext()) {
                    colorListIterator = colorList.listIterator();
                }

                DrawableCompat.setTint(iconImageView.getDrawable(), colorListIterator.next());
            }
        });
    }
}
