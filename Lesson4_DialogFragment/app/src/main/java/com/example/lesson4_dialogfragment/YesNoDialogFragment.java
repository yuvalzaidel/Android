package com.example.lesson4_dialogfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class YesNoDialogFragment extends DialogFragment {

    private YesNoDialogListener listener;
    private TextView lblQuestion;
    private String question;

    public void setListener(YesNoDialogListener listener) {
        this.listener = listener;
    }

    public void setQuestion(String question) {
        this.question = question;
        if (lblQuestion != null) {
            lblQuestion.setText(question);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_yesno, container, false);
        lblQuestion = view.findViewById(R.id.lblQuestion);
        lblQuestion.setText(question);
        view.findViewWithTag("yes").setOnClickListener(onClickListener);
        view.findViewWithTag("no").setOnClickListener(onClickListener);
        return view;
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String tag = (String)view.getTag();
            if (listener != null) {
                listener.onDecision(tag.equals("yes"));
            }
            dismiss();
        }
    };

    public interface YesNoDialogListener{
        void onDecision(boolean yes);
    }
}
