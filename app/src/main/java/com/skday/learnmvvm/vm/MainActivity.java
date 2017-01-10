package com.skday.learnmvvm.vm;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.skday.learnmvvm.R;
import com.skday.learnmvvm.base.BaseActivity;
import com.skday.learnmvvm.databinding.ActivityMainBinding;
import com.skday.learnmvvm.utils.SimpleItemTouchHelperCallback;

public class MainActivity extends BaseActivity {

    ActivityMainBinding binding;
    MainVM vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        vm = new MainVM(this,binding);
        binding.setVm(vm);
        setSupportActionBar(binding.toolBar);
        getSupportActionBar().setTitle("Learn");
    }

    @Override
    protected void onResume() {
        super.onResume();
        vm = new MainVM(this,binding);
        binding.setVm(vm);
    }
}
