package com.example.lab2_bai4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lvEmployees;
    private EmployeeAdapter employeeAdapter;
    private ArrayList<Employee> employeeList;
    private CheckBox cb_manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvEmployees = findViewById(R.id.lv_employees);
        EditText etFullName = findViewById(R.id.et_name);
        Button btnAdd = findViewById(R.id.btn_add);
        cb_manager = findViewById(R.id.cb_manager);

        employeeList = new ArrayList<>();
        employeeAdapter = new EmployeeAdapter(this, R.layout.item_employee, employeeList);
        lvEmployees.setAdapter(employeeAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName = etFullName.getText().toString().trim();
                boolean isManager = cb_manager.isChecked();

                Employee employee = new Employee(fullName, isManager);
                employeeList.add(employee);
                employeeAdapter.notifyDataSetChanged();
            }
        });
    }
}
