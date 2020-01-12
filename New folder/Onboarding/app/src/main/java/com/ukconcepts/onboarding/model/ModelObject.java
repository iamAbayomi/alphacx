package com.ukconcepts.onboarding.model;

import com.ukconcepts.onboarding.R;


public enum ModelObject {
    FirstWalkthroughFragment(R.layout.fragment_first_walkthrough),
    SecondWalkthroughFragment(R.layout.fragment_second_walkthrough),
    ThirdWalkthroughFragment(R.layout.fragment_third_walkthrough),
    FourthWalkthroughFragment(R.layout.fragment_fourth_walkthrough),
    FifthWalkthroughFragment(R.layout.fragment_fifth_walkthrough);


    private int mLayoutResId;

    ModelObject(int layoutResID){
        mLayoutResId = layoutResID;
    }

    public int getmLayoutResId() {
        return mLayoutResId;
    }
}
