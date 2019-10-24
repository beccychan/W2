package com.example.w2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

public class ArticleFragment extends Fragment {

    //private OnFragmentInteractionListener mListener;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Results> results;

    public ArticleFragment() {
        // Required empty public constructor
    }

    public static ArticleFragment newInstance() {
        ArticleFragment fragment = new ArticleFragment();
        //Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.articles_fragment, container, false);


        recyclerView = view.findViewById(R.id.rView);
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        ArticleAdapter articleAdapter = new ArticleAdapter();

        //we write our setData method to be like a setter, so we
        //give our ArrayList from FakeDatabase to the Adapter

        articleAdapter.setData(FakeDatabase.getAllArticles());
        recyclerView.setAdapter(articleAdapter);

        //convert array to arrayList
        Gson gson = new Gson();
        String json = FakeAPI.getMostViewedStoriesJsonString();
        //FakeAPI_data data = gson.fromJson(json, FakeAPI_data.class);
        Type resultsJson = new TypeToken<ArrayList<Results>>(){}.getType();
        results = gson.fromJson(json, resultsJson);
        Arrays.asList(results);


        return view;
        }


    }
