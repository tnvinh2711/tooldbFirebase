package com.zinzin.tooluploaddb.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.zinzin.tooluploaddb.R;

public class DotaUnderLordsFragment extends Fragment {
    public static DotaUnderLordsFragment newInstance() {
        return new DotaUnderLordsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upload, container, false);
        Button btnUpload = view.findViewById(R.id.btn_upload);
        btnUpload.setText("upload dota underlords");
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseHtml();
            }
        });
        return view;
    }

    private void parseHtml() {
    }
}
