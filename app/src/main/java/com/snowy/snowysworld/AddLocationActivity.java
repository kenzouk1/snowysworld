package com.snowy.snowysworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class AddLocationActivity extends AppCompatActivity {

    static int[] images;
    static String[] types;
    Spinner mSpinner;

    static{
        types = new String[]{"Origin", "Home", "Home stay", "Hotel", "Vacation", "Restaurant", "Grooming", "Vet"};
        images = new int[]{R.drawable.ic_marker_flag_pink_24px
                , R.drawable.ic_marker_push_pin_pink_24px
                , R.drawable.ic_marker_ball_pink_24px
                , R.drawable.ic_marker_ball_pink_24px
                , R.drawable.ic_marker_ball_chartreuse_24px
                , R.drawable.ic_marker_ball_chartreuse_24px
                , R.drawable.ic_marker_ball_azure_24px
                , R.drawable.ic_marker_ball_azure_24px};
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_location);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

//        CustomAdapter mCustomAdapter = new CustomAdapter(AddLocationActivity.this, images, types);
//        mSpinner.setAdapter(mCustomAdapter);
//
//        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView adapterView, View view, int i, long l) {
//                Toast.makeText(AddLocationActivity.this, types[0], Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView adapterView) {
//
//            }
//        });

    }

}
