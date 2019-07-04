package br.com.valmir.eventshow.reciclerViews;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.valmir.eventshow.R;
import br.com.valmir.eventshow.detEventoActivity;
import br.com.valmir.eventshow.model.Evento;

// Inicio da Classe

public class eventoRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

// todo enetender e conentar

    private static final String TAG = eventoRecyclerViewHolder.class.getSimpleName();

    public TextView nome;
    private List<Evento> eventos;

    public eventoRecyclerViewHolder(final View itemView, final List<Evento> eventos) {

        super(itemView);
        this.eventos = eventos;

        nome = (TextView) itemView.findViewById(R.id.txtNomeEvento);
        nome.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });

// Acão de clicar em algum item d lista que leva para a tela de eventos

        nome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(itemView.getContext(), detEventoActivity.class);
                intent.putExtra("evento", eventos.get(getAdapterPosition()));
                intent.putExtra("codItem", getAdapterPosition());
                itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
