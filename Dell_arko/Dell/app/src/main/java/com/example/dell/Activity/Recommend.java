package com.example.dell.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dell.Adapter.ItemsAdapter;
import com.example.dell.Class.Items;
import com.example.dell.R;

import java.util.ArrayList;

public class Recommend extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);
        ArrayList<Items> itemsArrayList = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.recommender_recycler_view);
        itemsArrayList.add(new Items("Laptop1","very good laptop","100" ,"5", R.drawable.dell));
        ItemsAdapter itemsAdapter = new ItemsAdapter(Recommend.this, itemsArrayList, false);
        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(itemsAdapter);
    }
}
