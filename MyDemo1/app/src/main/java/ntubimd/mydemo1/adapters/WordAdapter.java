package ntubimd.mydemo1.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ntubimd.mydemo1.R;
import ntubimd.mydemo1.utilse.DictionaryModel;

/**
 * Created by User on 2018/8/16.
 */

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {

    public List<DictionaryModel> data;

    public WordAdapter(){

    }
    private  void setData(List<DictionaryModel> data){
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom Layout
        View wordView = inflater.inflate(R.layout.word_item,parent,false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(wordView,context);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DictionaryModel dictionaryModel = data.get(position);
        holder.wordText.setText(dictionaryModel.getWord());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public  Context context;
        public TextView wordText;

        public ViewHolder(View itemView, Context context) {
            super(itemView);
            this.context = context;

            wordText = (TextView)itemView.findViewById(R.id.wordText);
        }
    }
}
