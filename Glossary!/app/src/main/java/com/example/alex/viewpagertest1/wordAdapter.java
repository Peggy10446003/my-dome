package com.example.alex.viewpagertest1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by alex on 2018/7/11.
 */

public class wordAdapter extends ArrayAdapter<Word> {

    Context context;
    int resource;
    List<Word> wordList;

    public wordAdapter(@NonNull Context context, int resource, @NonNull List<Word> wordList) {
        super(context, resource, wordList);
        this.context=context;
        this.resource=resource;
        this.wordList=wordList;

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View view= inflater.inflate(R.layout.list_item_search,null);

        TextView textViewTitle = view.findViewById(R.id.textViewSearch);


        String word=this.getItem(position).getTitle();
        Log.d("adapter",this.getItem(position).getTitle());
        textViewTitle.setText(word);

        return view;
    }
}
