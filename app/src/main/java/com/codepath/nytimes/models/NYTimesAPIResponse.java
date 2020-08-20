package com.codepath.nytimes.models;

import com.codepath.nytimes.models.BestSellerResults;
import com.google.gson.annotations.SerializedName;

public class NYTimesAPIResponse {

    @SerializedName("status")
    public String status;

    @SerializedName("results")
    public BestSellerResults results;
}
