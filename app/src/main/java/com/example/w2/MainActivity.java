package com.example.w2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity{
   /* no longer needed because RecyclerView:
    private ImageView bookmark1;
    private ImageView bookmark2;
    boolean button1State = false;
    boolean button2State = false;
    private RecyclerView recyclerView;
    private ArticleAdapter ArticleAdapter;
    private RecyclerView.LayoutManager layoutManager;
    */


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = new ArticleFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){
                Fragment selectedFragment = null;
                switch(item.getItemId()){
                    case R.id.navigation_articles:
                        selectedFragment = ArticleFragment.newInstance();
                        break;
                    /*case R.id.navigation_books:
                        selectedFragment = BooksFragment.newInstance(); //MAKE LATER
                        break; */
                    case R.id.navigation_profile:
                        selectedFragment = ProfileFragment.newInstance();
                        break;
                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, selectedFragment);
                transaction.commit();
                return true;
            }
        });
        //starting the app on our default page = articles
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, ArticleFragment.newInstance());
        transaction.commit();


        /*

        public void displayProfileFragment(){

            ProfileFragment profileFragment = ProfileFragment.newInstance();
            //Add the Fragment Manager and start a transaction
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            //note: fragment operations are wrapped into a transaction (similar to a
            //bank transaction so that all operations finish before the transaction is
            //committed for the final result

            //Add the profile fragment
            fragmentTransaction.add(R.id.container, profileFragment).addToBackStack(null).commit();
            //or could use:
        //  fragmentTransaction.replace(R.id.profileFrag_container, profileFragment);
            //any display changes i.e. button.setText(R.string._); make here
            //set boolean flag to indicate the fragment is open
            //isFragmentDisplayed = true; //this is for a button onClickListener

        } */


        /* now longer needed because custom Adapter -> onBindViewHolder
        ConstraintLayout article1 = findViewById(R.id.first_article);
        article1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), DetailedActivity.class);
                intent.putExtra("articleID", 1);
                startActivity(intent);
            }
        });

        ConstraintLayout article2 = findViewById(R.id.article2);
        article2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), DetailedActivity.class);
                intent.putExtra("articleID", 2);
                startActivity(intent);
            }
        });

        bookmark1 = article1.findViewById(R.id.saveButton);
        bookmark2 = article2.findViewById(R.id.saveButton);

        bookmark1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Click Registered", Toast.LENGTH_SHORT).show();
                if(!button1State){
                    bookmark1.setImageResource(R.drawable.bookmark);
                } else {
                    bookmark1.setImageResource(R.drawable.bookmark);
                }
                button1State = !button1State;
            }

        });

        bookmark2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Click Registered", Toast.LENGTH_SHORT).show();
                if(!button2State){
                    bookmark2.setImageResource(R.drawable.bookmark);
                } else {
                    bookmark2.setImageResource(R.drawable.bookmark);
                }
                button2State = !button2State;
            }
        });

        ImageView shareButton1 = article1.findViewById(R.id.shareButton);
        shareButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain"); //implicit intent vs explicit intent (otherwise No Activity found to handle Intent)
                startActivity(intent);
            }
        });
    */

    }


}
