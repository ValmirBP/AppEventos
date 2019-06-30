package br.com.valmir.eventshow.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


import br.com.valmir.eventshow.EventosActivity;
import br.com.valmir.eventshow.R;
import br.com.valmir.eventshow.detEventoActivity;

public class EventosFragment extends Fragment {

    List<String> eventos;
    ArrayAdapter<String> adaptdor;
    ListView lvEventos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        /* Inflate the layout for this fragment */
        setHasOptionsMenu(true);

        View RootView = inflater.inflate(R.layout.fragment_eventos, container, false);

        lvEventos = (ListView)RootView.findViewById(R.id.listEventos);


        eventos = new ArrayList<String>();

        eventos.add("IX Seminário nacional do Centro de memória UNICAMP");
        eventos.add("am_be_do Instituto de Artes UNICAMP");
        eventos.add("Liderança Avançada");
        eventos.add("Kotlin Everywhere");

        adaptdor = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, eventos);
        lvEventos.setAdapter(adaptdor);
        lvEventos.setDividerHeight(0);
        lvEventos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        evento1();
                        break;
                    case 1:
                        evento2();
                        break;
                    case 2:
                        evento3();
                        break;
                    case 3:
                        evento4();
                        break;

                }
            }

        });


        return RootView;
    }

    private void evento1() {
        Intent it = new Intent(getActivity(), detEventoActivity.class);
        startActivity(it);
    }

    private void evento2() {
        Intent it = new Intent(getActivity(), detEventoActivity.class);
        startActivity(it);
    }

    private void evento3() {
        Intent it = new Intent(getActivity(), detEventoActivity.class);
        startActivity(it);
    }

    private void evento4() {
        Intent it = new Intent(getActivity(), detEventoActivity.class);
        startActivity(it);
    }

    public static EventosFragment newInstance() {
        return new EventosFragment();
    }

}