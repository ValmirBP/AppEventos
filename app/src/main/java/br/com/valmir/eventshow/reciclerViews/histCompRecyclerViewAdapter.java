package br.com.valmir.eventshow.reciclerViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.valmir.eventshow.R;
import br.com.valmir.eventshow.model.Evento;

    public class histCompRecyclerViewAdapter extends RecyclerView.Adapter<eventoRecyclerViewHolder> {
        private List<Evento> eventoComp;
        protected Context context;
        public histCompRecyclerViewAdapter(Context context, List<Evento> evento) {
            this.eventoComp = evento;
            this.context = context;
        }
        @Override
        public eventoRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            eventoRecyclerViewHolder viewHolder = null;
            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_eventos, parent, false);
            viewHolder = new eventoRecyclerViewHolder(layoutView, eventoComp);
            return viewHolder;
        }
        @Override
        public void onBindViewHolder(eventoRecyclerViewHolder holder, int position) {
            holder.nome.setText(eventoComp.get(position).getNome());

        }
        @Override
        public int getItemCount() {
            return this.eventoComp.size();
        }
    }

