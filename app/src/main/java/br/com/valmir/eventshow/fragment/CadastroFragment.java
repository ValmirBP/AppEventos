package br.com.valmir.eventshow.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.valmir.eventshow.R;

// Inicio da classe

public class CadastroFragment extends Fragment { // classe herda do fragment

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       //todo enetender e comnetar

        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_num_boleto, container, false);
    }
}
