package com.test.rh.squaremobileproject.api;

import com.test.rh.squaremobileproject.model.EmployeesWrapper;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("employees.json")
    Call<EmployeesWrapper> getEmployees();

    @GET("employees_malformed.json")
    Call<EmployeesWrapper> getWrongEmployees();

    @GET("employees_empty")
    Call<EmployeesWrapper> getEmptyEmployees();
}
