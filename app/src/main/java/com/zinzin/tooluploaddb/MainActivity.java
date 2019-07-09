package com.zinzin.tooluploaddb;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zinzin.tooluploaddb.fragment.AutoChessFragment;
import com.zinzin.tooluploaddb.fragment.DotaUnderLordsFragment;
import com.zinzin.tooluploaddb.fragment.TFTFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnTFT, btnDotaLords, btnAutochess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btnTFT = findViewById(R.id.btn_tft);
        btnDotaLords = findViewById(R.id.btn_dota_underlords);
        btnAutochess = findViewById(R.id.btn_lol_Tier);
        btnTFT.setOnClickListener(this);
        btnAutochess.setOnClickListener(this);
        btnDotaLords.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_tft:
                TFTFragment tftFragment = TFTFragment.newInstance();
                goToFragment(tftFragment);
                break;
            case R.id.btn_dota_underlords:
                DotaUnderLordsFragment dotaUnderLordsFragment = DotaUnderLordsFragment.newInstance();
                goToFragment(dotaUnderLordsFragment);
                break;
            case R.id.btn_lol_counter:
                break;
            case R.id.btn_lol_Tier:
                AutoChessFragment autoChessFragment = AutoChessFragment.newInstance();
                goToFragment(autoChessFragment);
                break;
        }
    }

    private void goToFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();
    }
}
