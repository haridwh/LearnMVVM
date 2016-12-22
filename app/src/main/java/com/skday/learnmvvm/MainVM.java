package com.skday.learnmvvm;

import android.content.Context;
import android.databinding.ObservableField;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.skday.learnmvvm.adapter.RVAdapter;
import com.skday.learnmvvm.model.Task;
import com.skday.learnmvvm.util.TextWatcherAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skday on 12/18/16.
 */

public class MainVM {

    public ObservableField<String> inpTitle = new ObservableField<>("");
    public ObservableField<String> inpDetail = new ObservableField<>("");
    public ObservableField<Boolean> isVisibility = new ObservableField<>(false);
    public ObservableField<Boolean> isFill = new ObservableField<>(false);
    private List<Task> mList = new ArrayList<>();
    private Context bContext;
    public RVAdapter bAdapter;
    public LinearLayoutManager bLayoutManager;

    public MainVM(Context bContext) {
        this.bContext = bContext;
        mList.add(new Task("Coba1", "coba coba"));
        mList.add(new Task("Coba2", "coba coba"));

        bAdapter = new RVAdapter(mList);
        bLayoutManager = new LinearLayoutManager(bContext);
    }

    public void submit(View view) {
        if (!isVisibility.get()) {
            isVisibility.set(true);
        } else {
            if (isFill.get()) {
                mList.add(new Task(inpTitle.get(), inpDetail.get()));
                inpTitle.set("");
                inpDetail.set("");
                bAdapter.notifyDataSetChanged();
                isVisibility.set(false);
                isFill.set(false);
            }else{
                inpTitle.set("");
                inpDetail.set("");
                isVisibility.set(false);
            }
        }
    }

    public TextWatcherAdapter watcher = new TextWatcherAdapter(){
        @Override
        public void afterTextChanged(Editable editable) {
            super.afterTextChanged(editable);
            if (!(inpTitle.get().equals("") || inpDetail.get().equals(""))) {
                isFill.set(true);
            }
        }
    };
}
