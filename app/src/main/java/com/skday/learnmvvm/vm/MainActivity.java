package com.skday.learnmvvm.vm;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.skday.learnmvvm.R;
import com.skday.learnmvvm.databinding.ActivityMainBinding;
import com.skday.learnmvvm.utils.SimpleItemTouchHelperCallback;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MainVM vm = new MainVM(this,binding);
        binding.setVm(vm);
    }
}
