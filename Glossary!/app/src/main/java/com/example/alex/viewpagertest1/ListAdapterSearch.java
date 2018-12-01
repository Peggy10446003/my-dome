package com.example.alex.viewpagertest1;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by alex on 2018/5/10.
 */

public class ListAdapterSearch extends ArrayAdapter<String> {

    Context context;
    int resource;
    List<String> wordList;

    public ListAdapterSearch(@NonNull Context context, int resource, @NonNull List<String> wordList) {
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


        String word=this.getItem(position);
        Log.d("adapter",this.getItem(position));
        textViewTitle.setText(word);

        return view;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return super.getFilter();

    }
}
