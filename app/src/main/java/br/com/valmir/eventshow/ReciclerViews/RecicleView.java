package br.com.valmir.eventshow.ReciclerViews;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import bolts.Task;
import br.com.valmir.eventshow.EventosActivity;
import br.com.valmir.eventshow.R;

public class RecicleView extends AppCompatActivity {
    private static final String TAG = RecicleView.class.getSimpleName();
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerViewAdapter recyclerViewAdapter;
    private DatabaseReference databaseReference;
    private List<EventosActivity> eventosComp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eventosComp = new ArrayList<EventosActivity>();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        recyclerView = (RecyclerView) findViewById(R.id.task_list);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

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
    }
    private void EventosComp(DataSnapshot dataSnapshot){

        for (DataSnapshot singleSnapshot : dataSnapshot.getChildren()){
            String taskTitle = singleSnapshot.getValue(String.class);
            eventosComp.add(new Task(taskTitle));
            recyclerViewAdapter = new RecyclerViewAdapter(RecicleView.this, eventosComp);
            recyclerView.setAdapter(recyclerViewAdapter);
    }
}
