package com.example.dell.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.Activity.Details;
import com.example.dell.Class.Items;
import com.example.dell.R;

import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder> {


    private Context mContext;
    private List<Items> mItemsList;
    private static final String TAG = "ItemsAdapter";
    private boolean mAutoReoder;

    public ItemsAdapter(Context mContext, List<Items> mItemsList, boolean mAutoReoder) {
        this.mContext = mContext;
        this.mItemsList = mItemsList;
        this.mAutoReoder = mAutoReoder;
    }

    @NonNull
    @Override
    public ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.items_card, viewGroup, false);
        /*ImageView imageView = itemView.findViewById(R.id.item_thumbnail);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, Details.class);
                mContext.startActivity(intent);
                Log.d(TAG, "onClick: Buttonclicked");
            }
        });*/
        return new ItemsViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull ItemsViewHolder holder, final int position) {

        final Items item = mItemsList.get(position);
        if(mAutoReoder){
            holder.autoReorder.setVisibility(View.VISIBLE);
        }
        holder.title.setText(item.getmItemName());
        holder.price.setText(item.getmPrice());
        Glide.with(mContext).load(item.getmItemThumbnail()).into(holder.article_thumbnail);
        holder.article_thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("title",item.getmItemName());
                bundle.putString("summary",item.getmItemSummary());
                bundle.putString("price",item.getmPrice());
                bundle.putInt("image",item.getmItemThumbnail());
                bundle.putInt("position",position);
                bundle.putString("rating",item.getmRating());
                Intent intent = new Intent(mContext, Details.class);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
                Log.d(TAG, "onClick: Buttonclicked");
            }
        });

    }

    @Override
    public int getItemCount() {
        return mItemsList.size();
    }

    public class ItemsViewHolder extends RecyclerView.ViewHolder {
        public TextView title, price, expandedTitle, summary;
        public ImageView article_thumbnail;
        CheckBox autoReorder;
        private boolean isViewExpanded = false;

        public ItemsViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            price = (TextView) view.findViewById(R.id.price);
            article_thumbnail = (ImageView) view.findViewById(R.id.item_thumbnail);
            autoReorder = (CheckBox) view.findViewById(R.id.check_box);

        }
    }
}
