package com.example.w2;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {
    private ArrayList<Article> articlesToAdapt;

    public ArticleAdapter(Context context, ArrayList<Article> articleList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.articleList = articleList;
    }

    public void setData(ArrayList<Article> articlesToAdapt){
        this.articlesToAdapt = articlesToAdapt;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView HeadlineTextView;
        public TextView summaryTextView;
        public ImageView shareImageView;
        public ImageView itemImageView;
        //public OnNoteListener mOnNoteListener;

        public ViewHolder (View v){ //OnNoteListener onNoteListener) {
            super(v);
            view = v;
            HeadlineTextView = v.findViewById(R.id.newsTitle);
            summaryTextView = v.findViewById(R.id.details);
            shareImageView = v.findViewById(R.id.shareButton);
            itemImageView = v.findViewById(R.id.imageView);
            //mOnNoteListener = onNoteListener;
        }

    }

    @Override
    public ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        //creates a view from the layout file (ViewGroup like ConstraintLayout that
        //contains more Views inside it - this view represents our entire one item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article, parent, false);
        //this creates an instance of our custom ViewHolder with the view we got from
        //inflating the layout
        ViewHolder userViewHolder = new ViewHolder(view);

        return userViewHolder;
    }


    /*@Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        private ArrayList<article> articleList = new ArrayList<>();

        Article article = articleList.get(position);
        article.setHeadline(article.getHeadline());
        article.setContent(article.getContent());

    } */

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Compare what we have in this method, to what we used to have in MainActivity

        // 'position' is the index of the ViewHolder currently being bound (note VIEWHOLDER). So
        // if position is 0, then we are binding the first ViewHolder in the list. This means the
        // corresponding data object will be at index 0 of our data ArrayList.
        final Article articleAtPosition = articlesToAdapt.get(position);

        holder.HeadlineTextView.setText(articleAtPosition.getHeadline());
        holder.summaryTextView.setText(articleAtPosition.getSummary());


        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();

                Intent intent = new Intent(context, DetailedActivity.class);
                intent.putExtra("ArticleID", articleAtPosition.getArticleID());
                context.startActivity(intent);
            }
        });

        holder.shareImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(Intent.ACTION_SEND);

                intent.putExtra(Intent.EXTRA_TEXT, articleAtPosition.getHeadline());
                intent.setType("text/plain");
                context.startActivity(intent);
            }
        });

        holder.itemImageView.setImageResource(articleAtPosition.getImageDrawableId());
    }

    //returning the size of dataset (but must be invoked by layout manager)
    @Override
    public int getItemCount() {
        return articlesToAdapt.size();
    }

}

