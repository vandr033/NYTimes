package com.codepath.nytimes.networking;

public interface CallbackResponse<T> {
    void onSuccess(T model);

    void onFailure(Throwable error);
}
