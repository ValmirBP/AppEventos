package br.com.valmir.eventshow.reciclerViews;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import java.util.List;

import br.com.valmir.eventshow.fragment.EventosFragment;
import br.com.valmir.eventshow.model.Evento;
import br.com.valmir.eventshow.R;

public class eventoRecyclerViewHolder extends RecyclerView.ViewHolder{
    Activity eventos;
    private static final String TAG = eventoRecyclerViewHolder.class.getSimpleName();
    public ImageView markIcon;
    public TextView nome;
    public ImageView deleteIcon;
    private List<Evento> evento;
    public eventoRecyclerViewHolder(final View itemView, final List<Evento> evento) {
        super(itemView);
        this.evento = evento;
        nome = (TextView)itemView.findViewById(R.id.txtNomeEvento);
        nome.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent =new Intent(eventos, EventosFragment.class);
                intent.putExtra("texto",nome.getText().toString());
                eventos.startActivity(intent);



                Toast.makeText(v.getContext(), "Delete icon has been clicked", Toast.LENGTH_LONG).show();

            }
        });
    }
}
