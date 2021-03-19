package com.test.rh.squaremobileproject.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.test.rh.squaremobileproject.api.Api;
import com.test.rh.squaremobileproject.api.RetrofitClient;
import com.test.rh.squaremobileproject.model.Employee;
import com.test.rh.squaremobileproject.model.EmployeesWrapper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeesViewModel extends ViewModel {
    private MutableLiveData<List<Employee>> employeeList;
    Api apiInstance;

    public LiveData<List<Employee>> getEmployees() {
        if (employeeList == null) {
            employeeList = new MutableLiveData<List<Employee>>();
            loadEmployees();
        }

        return employeeList;
    }

    private void loadEmployees() {
        apiInstance = RetrofitClient.getRetrofitInstance().create(Api.class);
        Call<EmployeesWrapper> call = apiInstance.getEmployees();
        //Call<EmployeesWrapper> call = apiInstance.getEmptyEmployees();
        //Call<EmployeesWrapper> call = apiInstance.getWrongEmployees();

        call.enqueue(new Callback<EmployeesWrapper>() {
            @Override
            public void onResponse(Call<EmployeesWrapper> call, Response<EmployeesWrapper> response) {
                try {
                    employeeList.setValue(response.body().getEmployees());
                } catch (Exception e) {
                    e.printStackTrace();
                    employeeList.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<EmployeesWrapper> call, Throwable t) {
                employeeList.setValue(null);
            }
        });
    }
}
