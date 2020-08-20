package com.codepath.nytimes.models;

import com.google.gson.annotations.SerializedName;

class Multimedia {
    @SerializedName("subtype")
    String subtype;

    @SerializedName("url")
    String url;
}
