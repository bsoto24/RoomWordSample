package pe.openlab.roomwordsample;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class WordRepository {

    private WordDAO mWordDAO;
    private LiveData<List<Word>> mAllWords;

    public WordRepository(Application application){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDAO = db.wordDao();
        mAllWords = mWordDAO.getAllWords();
    }

    public LiveData<List<Word>> getAllWords(){
        return mAllWords;
    }

    public void insert(Word word){
        new insertAsyncTask(mWordDAO).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Word, Void, Void>{

        private WordDAO myAsyncTaskDAO;

        insertAsyncTask(WordDAO dao){
            myAsyncTaskDAO = dao;
        }

        @Override
        protected Void doInBackground(final Word... params) {
            myAsyncTaskDAO.insert(params[0]);
            return null;
        }
    }

}
