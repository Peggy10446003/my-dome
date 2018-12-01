package com.example.alex.viewpagertest1;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by alex on 2018/5/4.
 */

public class Tab2 extends Fragment {

    Button btnRnd;
    RelativeLayout layoutExplore;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
         return inflater.inflate(R.layout.tab2,container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        layoutExplore=(RelativeLayout) getView().findViewById(R.id.layoutExplore);
        btnRnd=(Button) getView().findViewById(R.id.buttonRnd);
        btnRnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (layoutExplore.getVisibility()==View.INVISIBLE){
                    layoutExplore.setVisibility(View.VISIBLE);
                }else{
                    layoutExplore.setVisibility(View.INVISIBLE);
                }

            }
        });
    }
}
