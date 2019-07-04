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
import br.com.valmir.eventshow.model.Evento;
import br.com.valmir.eventshow.R;
import br.com.valmir.eventshow.reciclerViews.eventoRecyclerViewAdapter;

// Inicio da classe

    public class EventosFragment extends Fragment {

        private static final String TAG = EventosFragment.class.getSimpleName(); // todo entender este codigo
        private RecyclerView recyclerView;                                      // >>> Declaração do recycle view
        private LinearLayoutManager linearLayoutManager;                        // >>> Declaração do do gerenciado do linear layout
        private eventoRecyclerViewAdapter recyclerViewAdapter;                  // >>> Declaração do adaptador o recycler View
        private DatabaseReference databaseReference;                            // >>> Decração da refencia do BQD do Firebase ( RealTime)
        private List<Evento> listaEventos;                                      // >>> Declaração da lista

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setHasOptionsMenu(true);

            View RootView = inflater.inflate(R.layout.fragment_eventos, container, false); // >>> fragmento eventos

            listaEventos = new ArrayList<Evento>(); //>>> criação da laista de eventos
            databaseReference = FirebaseDatabase.getInstance().getReference();

            recyclerView = (RecyclerView)  RootView.findViewById(R.id.listEvento);
            linearLayoutManager = new LinearLayoutManager(this.getActivity());
            recyclerView.setLayoutManager(linearLayoutManager);

// Recebimento do banco de dados em Json

            databaseReference.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    Eventos(dataSnapshot);
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    Eventos(dataSnapshot);
                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                    Eventos(dataSnapshot);
                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    Eventos(dataSnapshot);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }

            });

            return RootView;

        }

// Método que recebe os dados em JSON do Firebase

        private void Eventos(DataSnapshot dataSnapshot) {

            for (DataSnapshot ds : dataSnapshot.getChildren()){
                Evento e=new Evento();
                e.setBoleto(ds.getValue(Evento.class).getBoleto());
                e.setCodigo(ds.getValue(Evento.class).getCodigo());
                e.setData(ds.getValue(Evento.class).getData());
                e.setEndereco(ds.getValue(Evento.class).getEndereco());
                e.setNome(ds.getValue(Evento.class).getNome());
                e.setSobre(ds.getValue(Evento.class).getSobre());
                listaEventos.add(e);
            }

 // adapta a tela com o tamanho

            recyclerViewAdapter = new eventoRecyclerViewAdapter(getActivity(), listaEventos);
            recyclerView.setAdapter(recyclerViewAdapter);
        }

        public static EventosFragment newInstance() {
            return new EventosFragment();
        }

    }