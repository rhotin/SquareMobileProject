package com.test.rh.squaremobileproject.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EmployeesWrapper {
    @SerializedName("employees")
    private List<Employee> employees = null;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
