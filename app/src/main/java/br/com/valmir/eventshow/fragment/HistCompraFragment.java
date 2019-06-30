package br.com.valmir.eventshow.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.valmir.eventshow.Det_CompraActivity;
import br.com.valmir.eventshow.R;

public class HistCompraFragment extends Fragment {

    List<String> eventosComp;
    ArrayAdapter<String> adaptdor2;
    ListView lvEventosComp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /* Inflate the layout for this fragment */
        setHasOptionsMenu(true);

        View HistCompraView = inflater.inflate(R.layout.fragment_hist_compra, container, false);

        lvEventosComp = (ListView) HistCompraView.findViewById(R.id.listHistCompras);



        eventosComp = new ArrayList<String>();

        eventosComp.add("IX Seminário nacional do Centro de memória UNICAMP");

        adaptdor2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, eventosComp);

        lvEventosComp.setAdapter(adaptdor2);
        lvEventosComp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        evento1();
                        break;

                }
            }

        });

        return HistCompraView;
    }

    public static HistCompraFragment newInstance() {
        return new HistCompraFragment();
    }

    private void evento1() {
        Intent it = new Intent(getActivity(), Det_CompraActivity.class);
        startActivity(it);
    }

    private void evento2() {
        Intent it = new Intent(getActivity(), Det_CompraActivity.class);
        startActivity(it);
    }

    private void evento3() {
        Intent it = new Intent(getActivity(), Det_CompraActivity.class);
        startActivity(it);
    }

    private void evento4() {
        Intent it = new Intent(getActivity(), Det_CompraActivity.class);
        startActivity(it);
    }
}
