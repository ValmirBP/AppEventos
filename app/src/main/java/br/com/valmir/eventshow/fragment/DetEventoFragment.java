package br.com.valmir.eventshow.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.valmir.eventshow.R;

// Início da classe

public class DetEventoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

// Recebe as informações do fragmento

        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_det_evento, container, false);

    }
}