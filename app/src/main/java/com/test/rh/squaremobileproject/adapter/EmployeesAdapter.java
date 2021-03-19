package com.test.rh.squaremobileproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.test.rh.squaremobileproject.R;
import com.test.rh.squaremobileproject.model.Employee;

import java.util.List;

public class EmployeesAdapter extends RecyclerView.Adapter<EmployeesAdapter.EmployeeViewHolder> {

    Context mContext;
    List<Employee> employeeList;

    public EmployeesAdapter(Context mContext, List<Employee> employeeList) {
        this.mContext = mContext;
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_item_layout, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Employee employee = employeeList.get(position);

        Glide.with(mContext).load(employee.getPhoto_url_small()).into(holder.empImageView);
        holder.empNameTextView.setText(employee.getFull_name());
        holder.empPhoneTextView.setText(employee.getPhone_number());
        holder.empEmailTextView.setText(employee.getEmail_address());
        holder.empBioTextView.setText(employee.getBiography());
        holder.empTeamTextView.setText(employee.getTeam());
        holder.empTypeTextView.setText(employee.getEmployee_type().getValue());
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder {
        ImageView empImageView;
        TextView empNameTextView;
        TextView empPhoneTextView;
        TextView empEmailTextView;
        TextView empBioTextView;
        TextView empTeamTextView;
        TextView empTypeTextView;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);

            empImageView = itemView.findViewById(R.id.employeeImage);
            empNameTextView = itemView.findViewById(R.id.employeeName);
            empPhoneTextView = itemView.findViewById(R.id.employeePhone);
            empEmailTextView = itemView.findViewById(R.id.employeeEmail);;
            empBioTextView = itemView.findViewById(R.id.employeeBio);;
            empTeamTextView = itemView.findViewById(R.id.employeeTeam);;
            empTypeTextView = itemView.findViewById(R.id.employeeType);;
        }
    }
}
