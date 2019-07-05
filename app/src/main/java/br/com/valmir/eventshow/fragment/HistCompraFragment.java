package br.com.valmir.eventshow.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.valmir.eventshow.R;
import br.com.valmir.eventshow.model.Evento;
import br.com.valmir.eventshow.reciclerViews.histCompRecyclerViewAdapter;


public class HistCompraFragment extends Fragment {

    private static final String TAG = HistCompraFragment.class.getSimpleName();
    private RecyclerView recyclerView;                          // >>> Declaração do recycle view
    private LinearLayoutManager linearLayoutManager;            // >>> Declaração do do gerenciado do linear layout
    private histCompRecyclerViewAdapter recyclerViewAdapter;    // >>> Declaração do adaptador o recycler View
    private DatabaseReference databaseReference;                // >>> Decração da refencia do BQD do Firebase ( RealTime)
    private List<Evento> listaEventosComp;                      // >>> Declaração da lista

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);

        View RootView = inflater.inflate(R.layout.fragment_hist_compra, container, false); // >>> fragmento de compras

        listaEventosComp = new ArrayList<Evento>(); // >>> Criação de lista
        databaseReference = FirebaseDatabase.getInstance().getReference();

        recyclerView = (RecyclerView) RootView.findViewById(R.id.listHistComp);
        linearLayoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

// Recebimento do banco de dados em JSON

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                EventosComp(dataSnapshot);

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                EventosComp(dataSnapshot);

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                EventosComp(dataSnapshot);
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                EventosComp(dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return RootView;

    }

// Importação dos dados em JOSON

    private void EventosComp(DataSnapshot dataSnapshot) {

        listaEventosComp = new ArrayList<Evento>();

        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            Evento e = new Evento();
            e.setBoleto(ds.getValue(Evento.class).getBoleto());
            e.setCodigo(ds.getValue(Evento.class).getCodigo());
            e.setData(ds.getValue(Evento.class).getData());
            e.setEndereco(ds.getValue(Evento.class).getEndereco());
            e.setNome(ds.getValue(Evento.class).getNome());
            e.setSobre(ds.getValue(Evento.class).getSobre());
            e.setImg(ds.getValue(Evento.class).getImg());

// Checa se existe um código de barras escrito em no Banco de dados, e se estiver acrecenta em compras

            if (!e.getBoleto().isEmpty()) {
                listaEventosComp.add(e);
            }
        }

// Aadapta a tela com o tamanho

        recyclerViewAdapter = new histCompRecyclerViewAdapter(getActivity(), listaEventosComp);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    public static HistCompraFragment newInstance() {
        return new HistCompraFragment();
    }
}