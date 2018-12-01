package com.example.alex.viewpagertest1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SearchItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_item);
        Bundle bundle = getIntent().getExtras();


        TextView title;
        TextView context;
        title=(TextView) findViewById(R.id.textViewTitle);
        context=(TextView)findViewById(R.id.textViewContext);
        title.setText(bundle.getString("Title"));
        context.setText(bundle.getString("chineseContext")+"\n"+bundle.getString("detailContext"));


    }
}
