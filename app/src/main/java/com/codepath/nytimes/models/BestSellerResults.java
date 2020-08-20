package com.codepath.nytimes.models;

import com.codepath.nytimes.models.BestSellerBook;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BestSellerResults {

    @SerializedName("list_name")
    public String listName;

    @SerializedName("books")
    public List<BestSellerBook> books;
}
