package br.com.valmir.eventshow.reciclerViews;

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

import br.com.valmir.eventshow.R;
import br.com.valmir.eventshow.detCompraActivity;
import br.com.valmir.eventshow.detEventoActivity;
import br.com.valmir.eventshow.model.Evento;

// Inicio da classe

public class histCompRecyclerViewHolder extends RecyclerView.ViewHolder {

// todo entender para comentar

    private static final String TAG = br.com.valmir.eventshow.reciclerViews.histCompRecyclerViewHolder.class.getSimpleName();

    public TextView nome;


    public histCompRecyclerViewHolder(final View itemView, final List<Evento> eventos) {

        super(itemView);

        nome = (TextView) itemView.findViewById(R.id.txtNomeEvento);

// Acão de clicar em algum item d lista que leva para a tela de eventos

        nome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(itemView.getContext(), detCompraActivity.class);
                intent.putExtra("evento", eventos.get(getAdapterPosition()));
                int index = getAdapterPosition();
                intent.putExtra("codItem", index);
                itemView.getContext().startActivity(intent);
            }
        });

    }
}