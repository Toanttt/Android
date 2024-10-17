package com.example.lab2_bai5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ThumbnailAdapter extends ArrayAdapter<Thumbnail> {
    private Context context;
    private List<Thumbnail> thumbnails;

    public ThumbnailAdapter(Context context, int resource, List<Thumbnail> thumbnails) {
        super(context, resource, thumbnails);
        this.context = context;
        this.thumbnails = thumbnails;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_thumbnail, parent, false);
        }

        // Lấy các view từ item_thumbnail.xml
        ImageView ivThumbnail = convertView.findViewById(R.id.iv_thumbnail);
        TextView tvThumbnailName = convertView.findViewById(R.id.tv_thumbnail_name);

        // Lấy thumbnail hiện tại
        Thumbnail thumbnail = thumbnails.get(position);

        // Hiển thị hình ảnh và tên của thumbnail
        ivThumbnail.setImageResource(thumbnail.getImg());
        tvThumbnailName.setText(thumbnail.getName());

        return convertView;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_selected_thumbnail, parent, false);
        }

        TextView tvSelectedThumbnailName = convertView.findViewById(R.id.tv_selected_thumbnail_name);
        ImageView ivThumbnail = convertView.findViewById(R.id.iv_selected_thumbnail);
        ivThumbnail.setImageResource(thumbnails.get(position).getImg());
        tvSelectedThumbnailName.setText(thumbnails.get(position).getName());

        return convertView;
    }
}
