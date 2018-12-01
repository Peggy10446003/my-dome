package com.example.alex.viewpagertest1;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by alex on 2018/5/10.
 */

public class ListAdapterCollection extends ArrayAdapter<Word> {

    Context context;
    int resource;
    List<Word> wordList;

    public ListAdapterCollection(@NonNull Context context, int resource, @NonNull List<Word> wordList) {
        super(context, resource, wordList);
        this.context=context;
        this.resource=resource;
        this.wordList=wordList;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View view= inflater.inflate(R.layout.list_item_collection,null);

        TextView textViewTitle = view.findViewById(R.id.textViewTitle);
        TextView textViewContext = view.findViewById(R.id.textViewContext);

        Word word=wordList.get(position);
        textViewTitle.setText(word.getTitle());
        textViewContext.setText(word.getContext());

        view.findViewById(R.id.buttonCopy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        view.findViewById(R.id.buttonRemove).findViewById(R.id.buttonRemove).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeItem(position);
            }
        });;

        return view;
    }


    private void removeItem(final int pos){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Are you sure to remove this word from your collection?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                wordList.remove(pos);
                notifyDataSetChanged();
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}
