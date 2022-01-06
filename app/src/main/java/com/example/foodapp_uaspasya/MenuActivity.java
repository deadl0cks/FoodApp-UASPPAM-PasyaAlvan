package com.example.foodapp_uaspasya;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        com.example.foodapp_uaspasya.DB database = new com.example.foodapp_uaspasya.DB(getApplicationContext());

        ArrayList<com.example.foodapp_uaspasya.Food> data = (ArrayList<com.example.foodapp_uaspasya.Food>) database.getFoodList(getApplicationContext());
        RecyclerView recyclerView = findViewById(R.id.list_item_view);
        com.example.foodapp_uaspasya.ListFoodAdapter adapter = new com.example.foodapp_uaspasya.ListFoodAdapter(data);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public  void masukanData(){
        com.example.foodapp_uaspasya.DB database = new com.example.foodapp_uaspasya.DB(getApplicationContext());
        ArrayList<com.example.foodapp_uaspasya.Food> data = com.example.foodapp_uaspasya.ListFood.getData(getApplicationContext());

        for (com.example.foodapp_uaspasya.Food food: data) {
            database.tambahData(food);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout_item:
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), com.example.foodapp_uaspasya.MainActivity.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.tambahdata:
                masukanData();
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}