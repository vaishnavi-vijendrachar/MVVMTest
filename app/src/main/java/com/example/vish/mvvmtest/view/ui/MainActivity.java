package com.example.vish.mvvmtest.view.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.vish.mvvmtest.R;
import com.example.vish.mvvmtest.service.model.Details;
import com.example.vish.mvvmtest.view.adapter.CustomAdapter;
import com.example.vish.mvvmtest.viewmodel.ListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    CustomAdapter adapter;
    List<Details> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);

        //Initialise View Model in the Layout
        ListViewModel viewModel = ViewModelProviders.of(this).get(ListViewModel.class);

        viewModel.getDataList();

        //subscribe to LiveData
        viewModel.getDataList().observe(this, new Observer<List<Details>>() {
            @Override
            public void onChanged(@Nullable List<Details> details) {
                adapter = new CustomAdapter(getApplicationContext(),details);
                listView.setAdapter(adapter);
            }
        });
    }

}
