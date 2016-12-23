package com.skday.learnmvvm.vm;

import android.content.Context;
import android.databinding.ObservableField;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.view.View;

import com.skday.learnmvvm.SharedPrefs.PrefTask;
import com.skday.learnmvvm.adapter.RVAdapter;
import com.skday.learnmvvm.dao.DaoTask;
import com.skday.learnmvvm.model.Task;
import com.skday.learnmvvm.adapter.TextWatcherAdapter;

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
    private DaoTask listTask;

    public MainVM(Context bContext) {
        this.bContext = bContext;
        listTask = PrefTask.getTask(bContext);
        if (listTask == null) {
            bAdapter = new RVAdapter(null);
        } else {
            mList = PrefTask.getTask(bContext).getListTask();
            bAdapter = new RVAdapter(mList);
        }
        bLayoutManager = new LinearLayoutManager(bContext);
    }

    public void submit(View view) {
        if (!isVisibility.get()) {
            isVisibility.set(true);
        } else {
            if (isFill.get()) {
                listTask = PrefTask.getTask(bContext);
                if (listTask != null) {
                    listTask.getListTask()
                            .add(new Task(inpTitle.get(), inpDetail.get()));
                    mList.add(new Task(inpTitle.get(), inpDetail.get()));
                    PrefTask.setTask(listTask, bContext);
                } else {
                    listTask = new DaoTask();
                    mList.add(new Task(inpTitle.get(), inpDetail.get()));
                    listTask.setListTask(mList);
                    PrefTask.setTask(listTask, bContext);
                    bAdapter = new RVAdapter(mList);
                }
                resetInp();
                bAdapter.notifyDataSetChanged();
                isVisibility.set(false);
                isFill.set(false);
            } else {
                resetInp();
                isVisibility.set(false);
            }
        }
    }

    public TextWatcherAdapter watcher = new TextWatcherAdapter() {
        @Override
        public void afterTextChanged(Editable editable) {
            super.afterTextChanged(editable);
            if (!(inpTitle.get().equals("") || inpDetail.get().equals(""))) {
                isFill.set(true);
            }
        }
    };

    public void resetInp(){
        inpTitle.set("");
        inpDetail.set("");
    }
}
