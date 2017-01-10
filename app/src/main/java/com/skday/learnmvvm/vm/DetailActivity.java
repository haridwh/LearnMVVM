package com.skday.learnmvvm.vm;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.skday.learnmvvm.R;
import com.skday.learnmvvm.base.BaseActivity;
import com.skday.learnmvvm.databinding.ActivityDetailBinding;

public class DetailActivity extends BaseActivity {

    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        DetailVM vm = new DetailVM(this, binding, getIntent().getExtras().getInt("position"));
        binding.setVm(vm);
        setSupportActionBar(binding.toolBar);
        getSupportActionBar().setTitle("Detail");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
