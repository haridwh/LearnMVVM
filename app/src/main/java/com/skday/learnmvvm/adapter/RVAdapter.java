package com.skday.learnmvvm.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.skday.learnmvvm.ListItemVM;
import com.skday.learnmvvm.R;
import com.skday.learnmvvm.databinding.ListItemBinding;
import com.skday.learnmvvm.model.Task;

import java.util.List;

/**
 * Created by skday on 12/22/16.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.BindingHolder>{
    private List<Task> mList;

    public RVAdapter(List<Task> mList){
        this.mList = mList;
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
}
