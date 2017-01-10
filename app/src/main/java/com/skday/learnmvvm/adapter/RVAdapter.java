package com.skday.learnmvvm.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.skday.learnmvvm.SharedPrefs.PrefTask;
import com.skday.learnmvvm.dao.DaoTask;
import com.skday.learnmvvm.vm.ListItemVM;
import com.skday.learnmvvm.R;
import com.skday.learnmvvm.databinding.ListItemBinding;
import com.skday.learnmvvm.model.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by skday on 12/22/16.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.BindingHolder> implements ItemTouchHelperAdapter{
    private List<Task> mList;
    private Context bContext;

    public RVAdapter(List<Task> mList, Context bContext){
        this.mList = mList;
        this.bContext = bContext;
    }

    @Override
    public RVAdapter.BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListItemBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.list_item, parent, false);
        return new ItemBindingHolder(binding);
    }

    @Override
    public void onBindViewHolder(RVAdapter.BindingHolder holder, int position) {
        ((ItemBindingHolder) holder).getBinding()
                .setVm(new ListItemVM(((ItemBindingHolder) holder).getBinding(), mList.get(position)));

    }

    @Override
    public int getItemCount() {
        if (mList == null) {
            return 0;
        }
        return mList.size();
    }

    public static class BindingHolder extends RecyclerView.ViewHolder{
        private ViewDataBinding binding;

        public BindingHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public ViewDataBinding getBinding() {
            return this.binding;
        }
    }

    public static class ItemBindingHolder extends BindingHolder {
        private ListItemBinding binding;

        public ItemBindingHolder(ListItemBinding binding) {
            super(binding);
            this.binding = binding;
        }

        public ListItemBinding getBinding(){
            return this.binding;
        }
    }


    //ItemTouchHelper

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        DaoTask listTask = PrefTask.getTask(bContext);
        if (fromPosition < toPosition){
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(mList,i,i+1);
                Collections.swap(listTask.getListTask(),i,i+1);
            }
        }else{
            for (int i = fromPosition; i > toPosition ; i--) {
                Collections.swap(mList,i,i-1);
                Collections.swap(listTask.getListTask(),i,i-1);
            }
        }
        PrefTask.setTask(listTask, bContext);
        notifyItemMoved(fromPosition,toPosition);
        return true;
    }

    @Override
    public void onItemDismiss(int position) {
        mList.remove(position);
        DaoTask listTask = PrefTask.getTask(bContext);
        listTask.getListTask().remove(position);
        PrefTask.setTask(listTask, bContext);
        notifyItemRemoved(position);
    }
}
