package com.example.w2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    //private OnFragmentInteractionListener mListener;

    public ProfileFragment(){
        //empty public constructor
    }
    //instantiating our fragment in the Main Activity
    public static ProfileFragment newInstance(){
        return new ProfileFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //we inflate the layout for the profile fragment
        View view = inflater.inflate(R.layout.profile_fragment, container, false);

        return view;
    }

//    public void onButtonPressed(String string) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(string);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(String string);
//    }

    //maybe add a rating system for the articles + display top rated?
    /* // Set the rating bar onCheckedChanged listener.
        final RatingBar ratingBar =
                rootView.findViewById(R.id.ratingBar);

        ratingBar.setOnRatingBarChangeListener
                (new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar,
                                                float rating, boolean fromUser) {
                        // Get rating and show Toast with rating.
                        String myRating = (getString(R.string.my_rating) +
                                String.valueOf(ratingBar.getRating()));
                        Toast.makeText(getContext(), myRating,
                                Toast.LENGTH_SHORT).show();
                    }
                });

        return rootView;

     XML file:
     <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal">

            <TextView
                android:id="@+id/fragment_header2"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:padding="@dimen/small_padding"
                android:text="@string/question_the_song"
                android:textAppearance="@style/Base.TextAppearance.AppCompat.Medium"/>

            <RatingBar
                android:id="@+id/ratingBar"
                style="@android:style/Widget.DeviceDefault.RatingBar.Small"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:numStars="6"
                android:isIndicator="false"
                android:padding="@dimen/padding_standard"
                android:rating="3.5"
                android:stepSize="0.5"/>
        </LinearLayout>
     */
}
