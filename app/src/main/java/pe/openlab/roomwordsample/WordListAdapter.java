package pe.openlab.roomwordsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private final LayoutInflater mInflater;
    private List<Word> mWords;

    WordListAdapter(Context context){
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        if (mWords!=null){
            Word current = mWords.get(position);
            holder.tvWord.setText(current.getWord());
        }else{
            holder.tvWord.setText("No word");
        }

    }

    public void setWords(List<Word> mWords){
        this.mWords = mWords;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mWords!=null)
            return mWords.size();
        else
            return 0;
    }

    class WordViewHolder extends RecyclerView.ViewHolder{

        private final TextView tvWord;

        WordViewHolder(@NonNull View itemView) {
            super(itemView);
            tvWord = itemView.findViewById(R.id.textView);
        }
    }

}
