package com.example.vish.mvvmtest.viewmodel;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

import com.example.vish.mvvmtest.service.model.Details;
import com.example.vish.mvvmtest.service.model.Result;
import com.example.vish.mvvmtest.service.repository.WebserviceRepository;


import java.util.List;

/**
 * Created by admin on 25/7/2018.
 */

public class ListViewModel extends ViewModel {

    private MutableLiveData<List<Details>> detailsList;

    public LiveData<List<Details>> getDataList() {

        if (detailsList == null) {
            detailsList = new MutableLiveData<>();
            new WebserviceRepository().getDataList(detailsList);
        }

        return detailsList;
    }

}
