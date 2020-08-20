package com.codepath.nytimes.models;

import com.google.gson.annotations.SerializedName;

public class ArticleHeadline {
    @SerializedName("main")
    public String main;

    @SerializedName("print_headline")
    public String printHeadline;
}
