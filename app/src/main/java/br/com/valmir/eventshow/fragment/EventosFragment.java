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


    public class EventosFragment extends Fragment {

//    List<String> eventos;
//    ArrayAdapter<String> adaptdor;
//    ListView lvEventos;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//
//        /* Inflate the layout for this fragment */
//        setHasOptionsMenu(true);
//
//        View RootView = inflater.inflate(R.layout.fragment_eventos, container, false);
//
//        lvEventos = (ListView)RootView.findViewById(R.id.listEventos);
//
//
//        eventos = new ArrayList<String>();
//
//        eventos.add("IX Seminário nacional do Centro de memória UNICAMP");
//        eventos.add("am_be_do Instituto de Artes UNICAMP");
//        eventos.add("Liderança Avançada");
//        eventos.add("Kotlin Everywhere");
//
//        adaptdor = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, eventos);
//        lvEventos.setAdapter(adaptdor);
//        lvEventos.setDividerHeight(0);
//        lvEventos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                switch (position) {
//                    case 0:
//                        evento1();
//                        break;
//                    case 1:
//                        evento2();
//                        break;
//                    case 2:
//                        evento3();
//                        break;
//                    case 3:
//                        evento4();
//                        break;
//
//                }
//            }
//
//        });
//
//
//        return RootView;
//    }
//
//    private void evento1() {
//        Intent it = new Intent(getActivity(), detEventoActivity.class);
//        startActivity(it);
//    }
//
//    private void evento2() {
//        Intent it = new Intent(getActivity(), detEventoActivity.class);
//        startActivity(it);
//    }
//
//    private void evento3() {
//        Intent it = new Intent(getActivity(), detEventoActivity.class);
//        startActivity(it);
//    }
//
//    private void evento4() {
//        Intent it = new Intent(getActivity(), detEventoActivity.class);
//        startActivity(it);
//    }
//
//    public static EventosFragment newInstance() {
//        return new EventosFragment();
//    }


        private static final String TAG = EventosFragment.class.getSimpleName();
        private RecyclerView recyclerView;
        private LinearLayoutManager linearLayoutManager;
        private eventoRecyclerViewAdapter recyclerViewAdapter;
        private DatabaseReference databaseReference;
        private List<Evento> listaEventos;
       // private ListAdapter mListadapter;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);


            setHasOptionsMenu(true);

            View RootView = inflater.inflate(R.layout.fragment_eventos, container, false);

            listaEventos = new ArrayList<Evento>();
            databaseReference = FirebaseDatabase.getInstance().getReference();

            recyclerView = (RecyclerView)  RootView.findViewById(R.id.listEvento);
            linearLayoutManager = new LinearLayoutManager(this.getActivity());
            recyclerView.setLayoutManager(linearLayoutManager);

//        mListadapter = new RecyclerViewAdapter(listaEventos);
//        recyclerView.setAdapter(mListadapter);


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

            recyclerViewAdapter = new eventoRecyclerViewAdapter(getActivity(), listaEventos);
            recyclerView.setAdapter(recyclerViewAdapter);
        }

        public static EventosFragment newInstance() {
            return new EventosFragment();
        }

    }