package ntubimd.mydemo1;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import ntubimd.mydemo1.adapters.WordAdapter;
import ntubimd.mydemo1.utilse.DictionaryModel;

/**
 * Created by User on 2018/8/9.
 */

public class Tab1 extends Fragment {
    public static final String fileDictionary="dictionary.txt";
    private List<DictionaryModel> data;
    private RecyclerView rvWord;
    private WordAdapter wordAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1, container, false);
        return rootView;

        //rvWord = (RecyclerView) findViewById(R.id.rvWord);
        //rvWord.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        //data = new ArrayList<>();
        //readFromAsset(getApplicationContext(),fileDictionary);
        //wordAdapter = new WordAdapter();
        //wordAdapter.setData(data);
        //rvWord.setAdapter(wordAdapter);
    }
    private void readFromAsset(Context context, String fileName){
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open(fileName)));
            String mLine;
            int i = 0;
            while ((mLine=reader.readLine()) != null){
                String[] lineData = mLine.split("-");
                data.add(new DictionaryModel(""+i,lineData[0],lineData[1]));
                i++;
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
