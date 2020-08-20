package com.codepath.nytimes.ui.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codepath.nytimes.R;
import com.codepath.nytimes.models.Article;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Recycler view of articles from search result
 */
public class MyArticleResultRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<Article> articleList = new ArrayList<>();
    public static final int VIEW_TYPE_LOADING = 0;
    public static final int VIEW_TYPE_ARTICLE = 1;
    public static final int VIEW_TYPE_FIRST_PAGE_ARTICLE = 2;


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ARTICLE) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.fragment_article_result, parent, false);
            return new ArticleViewHolder(view);
        } else if (viewType == VIEW_TYPE_FIRST_PAGE_ARTICLE) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.fragment_article_result_first_page, parent, false);
            return new FirstPageArticleViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.article_progress, parent, false);
            return new LoadingViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof FirstPageArticleViewHolder) {
            // do something
            FirstPageArticleViewHolder articleViewHolder = (FirstPageArticleViewHolder) holder;
            articleViewHolder.firstPageHeader.setText(holder.itemView.getContext().getString(R.string.first_page, articleList.get(position).sectionName));
        }
        if (holder instanceof ArticleViewHolder) {
            Article article = articleList.get(position);
            ArticleViewHolder articleViewHolder = (ArticleViewHolder) holder;
            articleViewHolder.headlineView.setText(article.headline.main);
            articleViewHolder.snippetView.setText(article.snippet);
            try {
                SimpleDateFormat utcDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+SSS", Locale.getDefault());
                Date date = utcDateFormat.parse(article.publishDate);
                SimpleDateFormat newDateFormat = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
                articleViewHolder.dateView.setText(newDateFormat.format(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position >= articleList.size()) {
            return VIEW_TYPE_LOADING;
        } else if ("1".equals(articleList.get(position).printPage)) {
            return VIEW_TYPE_FIRST_PAGE_ARTICLE;
        } else {
            return VIEW_TYPE_ARTICLE;
        }
    }

    @Override
    public int getItemCount() {
        return (articleList.size() == 0) ? 0 : articleList.size() + 1;
    }

    void setNewArticles(List<Article> articles) {
        articleList.clear();
        articleList.addAll(articles);
    }

    void addArticles(List<Article> articles) {
        articleList.addAll(articles);
    }

    static class LoadingViewHolder extends RecyclerView.ViewHolder {

        LoadingViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    static class ArticleViewHolder extends RecyclerView.ViewHolder {
        final TextView headlineView;
        final TextView snippetView;
        final TextView dateView;

        ArticleViewHolder(View view) {
            super(view);
            dateView = view.findViewById(R.id.article_pub_date);
            headlineView = view.findViewById(R.id.article_headline);
            snippetView = view.findViewById(R.id.article_snippet);
        }
    }

    static class FirstPageArticleViewHolder extends ArticleViewHolder {
        final TextView firstPageHeader;

        FirstPageArticleViewHolder(View view) {
            super(view);
            firstPageHeader = view.findViewById(R.id.first_page_header);
        }
    }
}
