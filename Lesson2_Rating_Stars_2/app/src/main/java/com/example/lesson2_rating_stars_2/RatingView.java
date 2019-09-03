package com.example.lesson2_rating_stars_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RatingView extends LinearLayout {

    private CheckBox[] chkStars;
    private int value;
    private OnRatingChangedListener changedListener;
    private TextView lblQuestion;

    public RatingView(Context context) {
        super(context);
        setOrientation(VERTICAL);
        chkStars = new CheckBox[5];
        LinearLayout layout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.layout_rating, this, false);
        addView(layout);
        for (int i = 1; i <= 5; i++) {
            CheckBox chkStar = layout.findViewWithTag(String.valueOf(i));
            chkStars[i-1] = chkStar;
            chkStar.setOnClickListener(listener);
        }
        value = -1;
        lblQuestion = layout.findViewById(R.id.lblQuestion);

    }

    public void setQuestion(String question){
        lblQuestion.setText(question);
    }



    private OnClickListener listener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            int tag = Integer.valueOf((String)view.getTag());
            setChecked(tag);
            if (changedListener != null) {
                changedListener.onRatingChanged(RatingView.this);
            }
        }
    };

    private void setChecked(int tag) {
        for (int i = 1; i <= 5; i++) {
            chkStars[i-1].setChecked(i <= tag);
        }
        value = tag;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        setChecked(value);
    }

    public void setOnRatingChangedListener(OnRatingChangedListener changedListener) {
        this.changedListener = changedListener;
    }

    public interface OnRatingChangedListener{
        void onRatingChanged(RatingView ratingView);
    }
}
