package com.example.alex.viewpagertest1;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 2018/5/4.
 */

public class Tab3 extends Fragment {
    List<Word> wordListCollection;
    ListView listViewCollection;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //setContentView(R.layout.activity_main);
        View view = inflater.inflate(R.layout.tab3,container, false);
        wordListCollection =new ArrayList<>();


        listViewCollection =view.findViewById(R.id.listViewCollection);

        ListAdapterCollection adapter = new ListAdapterCollection(getActivity(),R.layout.list_item_collection, wordListCollection);

        listViewCollection.setAdapter(adapter);

        return view;
    }
}
