package com.example.lab2_bai1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Lab2_Bai1 extends AppCompatActivity {

    private ListView lvPerson;
    private TextView tvSelection;

    final String arr[] = {"Teo", "Ty", "Bin", "Bo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lab2_bai1);

        lvPerson = (ListView) findViewById(R.id.lv_person);
        tvSelection = (TextView) findViewById(R.id.tv_selection);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.listview,R.id.textView, arr);
        lvPerson.setAdapter(arrayAdapter);
        lvPerson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tvSelection.setText("Position: " + position + " ; Value: " + arr[position]);
            }
        });

    }
}
