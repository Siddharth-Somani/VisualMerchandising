package com.tophawks.vm.visualmerchandising.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tophawks.vm.visualmerchandising.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SalesLeadsFragment extends Fragment {


    public SalesLeadsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_sales_leads, container, false);
    }

}
