package br.com.valmir.eventshow.reciclerViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.valmir.eventshow.R;
import br.com.valmir.eventshow.model.Evento;

// Iníco da classe

    public class histCompRecyclerViewAdapter extends RecyclerView.Adapter<eventoRecyclerViewHolder> {

        private List<Evento> eventoComp; // >>> Declaração de lista
        protected Context context; // >>> todo entender para comentar

        public histCompRecyclerViewAdapter(Context context, List<Evento> evento) {

            this.eventoComp = evento; // >>> Criação da lista de eventos
            this.context = context; // >>> todo entender e comentar
        }

// >>> todo entender e comentar

        @Override
        public eventoRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            eventoRecyclerViewHolder viewHolder = null;

            View layoutView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.content_eventos, parent, false);

            viewHolder = new eventoRecyclerViewHolder(layoutView, eventoComp);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(eventoRecyclerViewHolder holder, int position) {
            holder.nome.setText(eventoComp.get(position).getNome());

        }

// Verifica o tamanho no JSON

        @Override
        public int getItemCount() {
            return this.eventoComp.size();
        }
    }