package com.example.lesson4_dialogfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class NameDialogFragment extends DialogFragment {


    private EditText txtFirstName, txtLastName;
    private Button btnDone;
    private NameDialogFragmentListener listener;


    public void setListener(NameDialogFragmentListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_name, container, false);
        txtFirstName = view.findViewById(R.id.txtFirstName);
        txtLastName = view.findViewById(R.id.txtLastName);
        btnDone = view.findViewById(R.id.btnDone);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = txtFirstName.getText().toString();
                String lastName = txtLastName.getText().toString();
                if (listener != null) {
                    listener.onComplete(firstName, lastName);
                }

                dismiss();
            }
        });

        return view;
    }

    public interface NameDialogFragmentListener{
        void onComplete(String firstName, String lastName);
    }
}
