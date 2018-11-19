package com.example.dell.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.R;

public class Details extends AppCompatActivity {

    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        Bundle extras = getIntent().getExtras();
        String title = null, summary = null, price = null, rating = null;
        int image = 0;
        if (extras != null) {
            title = extras.getString("title");
            summary = extras.getString("summary");
            price = extras.getString("price");
            image = extras.getInt("image");
            position = extras.getInt("position");
            rating = extras.getString("rating");
        }

        TextView tv_title = findViewById(R.id.itemtitle);
        TextView tv_summary = findViewById(R.id.summary);
        TextView tv_price = findViewById(R.id.price);
        ImageView imageView = findViewById(R.id.image);
        TextView tv_rating = findViewById(R.id.rating);

        tv_title.setText(title);
        tv_summary.setText(summary);
        tv_price.setText(price);
        tv_rating.setText(rating);
        Glide.with(Details.this).load(image).into(imageView);


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Details.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("position",position);
        startActivity(intent);
    }
}
