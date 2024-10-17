package com.example.lab2_bai5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class DishAdapter extends ArrayAdapter<Dish> {
    private Context context;
    private int layoutResourceId;
    private List<Dish> dishes;

    public DishAdapter(Context context, int layoutResourceId, List<Dish> dishes) {
        super(context, layoutResourceId, dishes);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.dishes = dishes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layoutResourceId, parent, false);
        }

        // Get current dish
        Dish currentDish = getItem(position);

        // Set up views
        TextView tvName = convertView.findViewById(R.id.tv_dish_name);
        tvName.setSelected(true); //kich hoat marquee
        ImageView ivThumbnail = convertView.findViewById(R.id.iv_dish_thumbnail);
        ImageView ivPromotion = convertView.findViewById(R.id.iv_dish_promotion);

        tvName.setText(currentDish.getName());
        ivThumbnail.setImageResource(currentDish.getThumbnail());

        if (currentDish.isPromotion()) {
            ivPromotion.setVisibility(View.VISIBLE);
        } else {
            ivPromotion.setVisibility(View.GONE);
        }

        return convertView;
    }
}
