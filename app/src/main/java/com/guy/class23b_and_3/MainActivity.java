package com.guy.class23b_and_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {

    private Fragment_List fragmentList;
    private Fragment_Map fragmentMap;
    private MaterialTextView main_LBL_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_LBL_title = findViewById(R.id.main_LBL_title);

        fragmentList = new Fragment_List();
        fragmentMap = new Fragment_Map();

        fragmentList.setCallBackList(callBackList);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_LAY_frame1, fragmentList)
                .add(R.id.main_LAY_frame1, fragmentMap)
                .hide(fragmentMap)
                .commit();


    }

    private CallBack_List callBackList = new CallBack_List() {
        @Override
        public void nameClicked(String user) {
            main_LBL_title.setText(user);
            fragmentMap.setLocation(user + "'s Home");
            changeFrame();
        }
    };

    private void changeFrame() {
        getSupportFragmentManager().beginTransaction()
                .hide(fragmentList)
                .show(fragmentMap)
                .commit();
    }

    @Override
    protected void onStart() {
        super.onStart();

        fragmentList.setName("Mayo");
    }


}