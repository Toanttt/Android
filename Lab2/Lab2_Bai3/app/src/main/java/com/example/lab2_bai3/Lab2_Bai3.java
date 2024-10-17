package com.example.lab2_bai3;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class Lab2_Bai3 extends AppCompatActivity {

    private ListView lvEmployees;
    private EditText etId, etName;
    private RadioGroup rgType;
    private Button btnAdd;
    private ArrayList<Employee> employees;
    private ArrayAdapter<Employee> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab2_bai3);

        lvEmployees = findViewById(R.id.lv_employees);
        etId = findViewById(R.id.et_id);
        etName = findViewById(R.id.et_name);
        rgType = findViewById(R.id.rg_type);
        btnAdd = findViewById(R.id.btn_add);

        employees = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, employees);
        lvEmployees.setAdapter(arrayAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewEmployee();
            }
        });
    }

    public void addNewEmployee() {
        int radId = rgType.getCheckedRadioButtonId();
        String id = etId.getText().toString();
        String name = etName.getText().toString();
        Employee employee;

        if (radId == R.id.rd_fulltime) {
            employee = new EmployeeFullTime();
        } else {
            employee = new EmployeePartTime();
        }

        employee.setId(id);
        employee.setName(name);
        employees.add(employee);
        arrayAdapter.notifyDataSetChanged();
    }
}