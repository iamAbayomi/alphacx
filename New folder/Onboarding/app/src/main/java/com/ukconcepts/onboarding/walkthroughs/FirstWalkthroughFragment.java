package com.ukconcepts.onboarding.walkthroughs;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ukconcepts.onboarding.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstWalkthroughFragment extends Fragment {


    public FirstWalkthroughFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first_walkthrough, container, false);
    }

}
