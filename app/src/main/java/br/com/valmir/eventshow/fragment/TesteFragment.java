package br.com.valmir.eventshow.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.valmir.eventshow.R;

public class TesteFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_teste, container, false);
    }
    public static TesteFragment newInstance() {
        return new TesteFragment();
    }

}
