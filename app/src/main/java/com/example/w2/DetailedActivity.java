package com.example.w2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        Intent intent = getIntent(); //gives us the intent that took us to where we are now (carrying putExtra)
        int articleID = intent.getIntExtra("articleID", 0);
        Article article = FakeDatabase.getArticleById((articleID));

        TextView headlineTextView = findViewById(R.id.detailHeadline);
        TextView authorTextView = findViewById(R.id.detailAuthor);
        TextView contentTextView = findViewById(R.id.detailContent);
        ImageView imageView = findViewById(R.id.detailImage);

        headlineTextView.setText(article.getHeadline());
        authorTextView.setText(article.getAuthor());
        contentTextView.setText(article.getContent());
        imageView.setImageResource(article.getImageDrawableId());

        //System.out.println("You are now reading article " + articleID);

    }
}
