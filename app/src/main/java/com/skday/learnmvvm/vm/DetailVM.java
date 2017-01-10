package com.skday.learnmvvm.vm;

import android.content.Context;
import android.databinding.ObservableField;
import android.os.Bundle;

import com.skday.learnmvvm.SharedPrefs.PrefTask;
import com.skday.learnmvvm.databinding.ActivityDetailBinding;
import com.skday.learnmvvm.model.Task;

/**
 * Created by skday on 1/10/17.
 */

public class DetailVM {
    public ObservableField<String> txtTitle = new ObservableField<>();
    public ObservableField<String> txtDetail = new ObservableField<>();

    private Context context;
    private ActivityDetailBinding binding;
    private int position;

    public DetailVM(Context context, ActivityDetailBinding binding, int position) {
        this.context = context;
        this.binding = binding;
        this.position = position;

        Task task = PrefTask.getTask(context).getListTask().get(position);
        txtTitle.set(task.getTitle());
        txtDetail.set(task.getDetail());
    }
}
