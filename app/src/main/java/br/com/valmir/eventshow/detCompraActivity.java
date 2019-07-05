package br.com.valmir.eventshow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.TextView;

import br.com.valmir.eventshow.model.Evento;

//Inicio da classe

public class detCompraActivity extends AppCompatActivity {

    ImageView imgEvento;
    TextView txtNomeEvento;
    TextView txtDataEvento;
    TextView txtInfoEvento;
    TextView txtCod;

    private Integer images[] = {R.drawable.evento_1, R.drawable.evento_2, R.drawable.evento_3, R.drawable.evento_4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_det_compra);


        imgEvento = findViewById(R.id.imgEvento);
        txtNomeEvento = findViewById(R.id.txtNomeEvento);
        txtDataEvento = findViewById(R.id.txtDataEvento);
        txtInfoEvento = findViewById(R.id.txtInfoEvento);
        txtCod = findViewById(R.id.txtCod);


// Acão de clique que seta o código de entrada

        Evento evento = (Evento) getIntent().getSerializableExtra("evento");

        imgEvento.setImageResource(images[evento.getImg()]);
        txtNomeEvento.setText(evento.getNome());
        txtDataEvento.setText(evento.getData());
        txtInfoEvento.setText(evento.getSobre());
        txtCod.setText("123-456");


    }
}













