package com.example.foodapp_uaspasya;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int id = getIntent().getIntExtra("id", -1);

        ArrayList<com.example.foodapp_uaspasya.Food> list = com.example.foodapp_uaspasya.ListFood.getData(getApplicationContext());
        com.example.foodapp_uaspasya.Food food = list.get(id);

        if (food != null) {
            TextView judul = findViewById(R.id.detail_judul);
            TextView deskripsi = findViewById(R.id.detail_deskripsi);
            ImageView gambar = findViewById(R.id.detail_gambar);

            gambar.setImageDrawable(food.image);
            judul.setText(food.title);
            deskripsi.setText(food.description);
        }
    }
}