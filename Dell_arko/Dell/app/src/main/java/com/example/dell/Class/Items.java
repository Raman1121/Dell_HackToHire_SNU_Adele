package com.example.dell.Class;

public class Items {

    private String mItemName;
    private String mPrice;
    private String mItemSummary;
    private int mItemThumbnail;
    private String mExpandedTitle;
    private String mRating;

    public Items(String mItemName, String mItemSummary, String mPrice, String mRating, int mItemThumbnail) {
        this.mItemName = mItemName;
        this.mExpandedTitle = mItemName;
        this.mItemSummary = mItemSummary;
        this.mItemThumbnail = mItemThumbnail;
        this.mPrice = mPrice;
        this.mRating = mRating;
    }

    public String getmRating() {
        return mRating;
    }

    public String getmPrice() {
        return mPrice;
    }

    public String getmExpandedTitle() {
        return mExpandedTitle;
    }

    public String getmItemName() {
        return mItemName;
    }

    public String getmItemSummary() {
        return mItemSummary;
    }

    public int getmItemThumbnail() {
        return mItemThumbnail;
    }
}
