package br.com.valmir.eventshow.reciclerViews;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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

import br.com.valmir.eventshow.detEventoActivity;
import br.com.valmir.eventshow.fragment.EventosFragment;
import br.com.valmir.eventshow.model.Evento;
import br.com.valmir.eventshow.R;

public class eventoRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private static final String TAG = eventoRecyclerViewHolder.class.getSimpleName();
    public ImageView markIcon;
    public TextView nome;
    public ImageView deleteIcon;
    private List<Evento> eventos;
    public eventoRecyclerViewHolder(final View itemView, final List<Evento> eventos) {
        super(itemView);
        this.eventos = eventos;
        nome = (TextView)itemView.findViewById(R.id.txtNomeEvento);
        nome.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Delete icon has been clicked", Toast.LENGTH_LONG).show();

            }
        });


        nome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(itemView.getContext() , detEventoActivity.class);
                intent.putExtra("evento", eventos.get(getAdapterPosition()));
                itemView.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public void onClick(View v) {

        Toast.makeText(itemView.getContext(),"The Item Clicked is: "+getPosition(),Toast.LENGTH_SHORT).show();
    }
}
