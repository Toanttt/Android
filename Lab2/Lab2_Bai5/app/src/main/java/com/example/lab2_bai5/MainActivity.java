package com.example.lab2_bai5;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    private Spinner spinner;
    private List<Dish> dishList = new ArrayList<>();
    private DishAdapter dishAdapter;
    private ThumbnailAdapter thumbnailAdapter;
    private List<Thumbnail> thumbnails = Arrays.asList(Thumbnail.values());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);
        spinner = findViewById(R.id.spinner);
        Button btnAdd = findViewById(R.id.btn_add);

        // Setup Dish Adapter
        dishAdapter = new DishAdapter(this, R.layout.item_dish, dishList);
        gridView.setAdapter(dishAdapter);

        // Setup Thumbnail Adapter
        thumbnailAdapter = new ThumbnailAdapter(this, R.layout.item_thumbnail, thumbnails);
        spinner.setAdapter(thumbnailAdapter);


        // Add button action
        btnAdd.setOnClickListener(v -> {
            String dishName = ((EditText) findViewById(R.id.et_name)).getText().toString();
            boolean isPromotion = ((CheckBox) findViewById(R.id.cb_promotion)).isChecked();
            Thumbnail selectedThumbnail = thumbnails.get(spinner.getSelectedItemPosition());

            Dish dish = new Dish(dishName, selectedThumbnail.getImg(), isPromotion);
            dishList.add(dish);
            dishAdapter.notifyDataSetChanged();

            // Reset fields
            ((EditText) findViewById(R.id.et_name)).setText("");
            ((CheckBox) findViewById(R.id.cb_promotion)).setChecked(false);
            spinner.setSelection(0);

            Toast.makeText(this, "Added successfully", Toast.LENGTH_SHORT).show();
        });
    }
}
