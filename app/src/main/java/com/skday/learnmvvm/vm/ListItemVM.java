package com.skday.learnmvvm.vm;

import android.databinding.ObservableField;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import com.skday.learnmvvm.databinding.ListItemBinding;
import com.skday.learnmvvm.model.Task;
import com.skday.learnmvvm.utils.ItemTouchHelperViewHolder;

/**
 * Created by skday on 12/22/16.
 */

public class ListItemVM extends RecyclerView.ViewHolder {
    public ObservableField<String> bTitle = new ObservableField<>();
    public ObservableField<String> bDetail = new ObservableField<>();

    public ListItemVM(ListItemBinding binding, Task data){
        super(binding.getRoot());
        bTitle.set(data.getTitle());
        bDetail.set(data.getDetail());
    }
}
