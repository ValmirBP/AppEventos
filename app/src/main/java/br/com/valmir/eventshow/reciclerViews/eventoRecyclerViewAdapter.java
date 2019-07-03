package br.com.valmir.eventshow.reciclerViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

import br.com.valmir.eventshow.model.Evento;
import br.com.valmir.eventshow.R;

public class eventoRecyclerViewAdapter extends RecyclerView.Adapter<eventoRecyclerViewHolder> {
    private List<Evento> evento;
    protected Context context;
    public eventoRecyclerViewAdapter(Context context, List<Evento> evento) {
        this.evento = evento;
        this.context = context;
    }
    @Override
    public eventoRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        eventoRecyclerViewHolder viewHolder = null;
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_eventos, parent, false);
        viewHolder = new eventoRecyclerViewHolder(layoutView, evento);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(eventoRecyclerViewHolder holder, int position) {
        holder.nome.setText(evento.get(position).getNome());
    }
    @Override
    public int getItemCount() {
        return this.evento.size();
    }
}
