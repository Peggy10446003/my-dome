package com.example.alex.viewpagertest1;

import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 2018/5/4.
 */

public class Tab1 extends Fragment {
    ArrayList<String> wordListSearch;
    ListView listViewSearch;
    ListAdapterSearch adapterSearch;
    //db
    List<Theme> themetest = new ArrayList<Theme>();
    DbHelper dbHelper;
    themeAdapter adapterTheme;
    wordAdapter adapterWord;
    List<Word> searchedword = new ArrayList<Word>();
    SearchView sv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1,container, false);
        dbHelper = new DbHelper(getContext());
        dbHelper.createDataBase();
        themetest = dbHelper.getAllThemes();
        listViewSearch =view.findViewById(R.id.listViewSearch);

        sv=(SearchView)view.findViewById(R.id.searchView);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
//              if (searchView.isExpanded() && TextUtils.isEmpty(newText)) {
                callSearch(newText);
                Log.d("sv",newText);
//              }
                return true;
            }
            public void callSearch(String query) {
                searchedword= dbHelper.searchWord(query);
                adapterWord= new wordAdapter(getActivity(),R.layout.list_item_search,searchedword);
                listViewSearch.setAdapter(adapterWord);
            }
        });



        listViewSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                    Intent DictionaryItemOnClick = new Intent(view.getContext(),SearchItem.class);
                    Word wordtemp;

                    wordtemp= (Word) listViewSearch.getItemAtPosition(position);
                    DictionaryItemOnClick.putExtra("Title", wordtemp.getTitle());
                    DictionaryItemOnClick.putExtra("chineseContext", wordtemp.getChinese());
                    DictionaryItemOnClick.putExtra("detailContext", wordtemp.getContext());
                    startActivity(DictionaryItemOnClick);

            }
        });
        return view;
    }
}
