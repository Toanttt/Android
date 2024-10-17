package com.example.lab2_bai4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EmployeeAdapter employeeAdapter;
    private ArrayList<Employee> employeeList;
    private CheckBox cbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        EditText etFullName = findViewById(R.id.et_name);
        Button btnAdd = findViewById(R.id.btn_add);
        cbManager = findViewById(R.id.cb_manager);

        employeeList = new ArrayList<>();
        employeeAdapter = new EmployeeAdapter(this, employeeList);
        recyclerView.setAdapter(employeeAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName = etFullName.getText().toString().trim();
                boolean isManager = cbManager.isChecked();

                Employee employee = new Employee(fullName, isManager);
                employeeList.add(employee);
                employeeAdapter.notifyDataSetChanged();
            }
        });
    }
}
