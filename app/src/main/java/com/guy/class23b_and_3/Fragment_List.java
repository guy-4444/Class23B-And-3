package com.guy.class23b_and_3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textview.MaterialTextView;

public class Fragment_List extends Fragment {

    private CallBack_List callBackList;
    private MaterialTextView list_LBL_name;

    public void setCallBackList(CallBack_List callBackList) {
        this.callBackList = callBackList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        list_LBL_name = view.findViewById(R.id.list_LBL_name);
        list_LBL_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBackList != null) {
                    callBackList.nameClicked("Michaella");
                }
            }
        });
        return view;
    }

    public void setName(String name) {
        list_LBL_name.setText(name);
    }
}