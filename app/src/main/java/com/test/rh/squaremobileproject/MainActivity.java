package com.test.rh.squaremobileproject;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.test.rh.squaremobileproject.adapter.EmployeesAdapter;
import com.test.rh.squaremobileproject.model.Employee;
import com.test.rh.squaremobileproject.viewModel.EmployeesViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView dataNotFoundTV;
    EmployeesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        dataNotFoundTV = findViewById(R.id.dataNotFoundTV);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        EmployeesViewModel viewModel = ViewModelProviders.of(this).get(EmployeesViewModel.class);
        viewModel.getEmployees().observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(List<Employee> employeeList) {
                boolean validData = false;
                for (Employee emp : employeeList) {
                    validData = validateData(emp);
                    if (!validData){
                        break;
                    }
                }

                if (employeeList == null || employeeList.size() <= 0) {
                    dataNotFoundTV.setVisibility(View.VISIBLE);
                    dataNotFoundTV.setText("No Data Found");
                    recyclerView.setVisibility(View.GONE);
                } else {
                    if (validData) {
                        dataNotFoundTV.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.VISIBLE);
                        adapter = new EmployeesAdapter(MainActivity.this, employeeList);
                        recyclerView.setAdapter(adapter);
                    } else {
                        dataNotFoundTV.setVisibility(View.VISIBLE);
                        dataNotFoundTV.setText("Data is in Wrong Format");
                        recyclerView.setVisibility(View.GONE);
                    }
                }
            }
        });
    }

    public boolean validateData(Employee emp) {
        if (!(emp.getFull_name() == null || emp.getUuid() == null || emp.email_address == null ||
                emp.getTeam() == null || emp.getEmployee_type().getValue() == null ||
                emp.getFull_name().isEmpty() || emp.getUuid().isEmpty() || emp.email_address.isEmpty() ||
                emp.getTeam().isEmpty() || emp.getEmployee_type().getValue().isEmpty())) {
            return true;
        } else {
            return false;
        }
    }
}