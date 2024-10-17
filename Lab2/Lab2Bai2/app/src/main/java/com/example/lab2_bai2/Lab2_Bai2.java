package com.example.lab2_bai2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class Lab2_Bai2 extends AppCompatActivity {

    private ListView lvPerson;
    private TextView tvSelection;
    private EditText etInput;
    private Button btnAdd;

    private ArrayList<String> personList;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab2_bai2);

        lvPerson = findViewById(R.id.lv_person);
        tvSelection = findViewById(R.id.tv_selection);
        etInput = findViewById(R.id.et_input);
        btnAdd = findViewById(R.id.btn_add);

        personList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this, R.layout.list_item, personList);
        lvPerson.setAdapter(arrayAdapter);

        // Sự kiện nhấn nút "Nhập"
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etInput.getText().toString();
                if (!input.isEmpty()) {
                    personList.add(input); // Thêm vào ArrayList
                    arrayAdapter.notifyDataSetChanged(); // Cập nhật ListView
                    etInput.setText(""); // Xóa ô nhập
                }
            }
        });

        // Sự kiện nhấn vào phần tử ListView
        lvPerson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tvSelection.setText("Position: " + position + " ; Value: " + personList.get(position));
            }
        });

        // Sự kiện nhấn lâu để xóa phần tử
        lvPerson.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                personList.remove(position); // Xóa phần tử khỏi ArrayList
                arrayAdapter.notifyDataSetChanged(); // Cập nhật ListView
                return true; // Trả về true để chỉ ra rằng sự kiện đã được xử lý
            }
        });
    }
}
