package br.com.valmir.eventshow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import br.com.valmir.eventshow.model.Evento;

public class detEventoActivity extends AppCompatActivity {

    Button btnGerBol;
    private TextView txtDetEvento;
    private ImageView imgEvento;
    private TextView txtNomeEvento;
    private TextView txtDataEvento;
    private TextView txtComprarIngresso;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_det_evento);
        btnGerBol = findViewById(R.id.btnGerBol);

        btnGerBol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random random = new Random();
                int randomNum = random.nextInt((5000 - 1500) + 1) + 1500;

                txtComprarIngresso = findViewById(R.id.txtComparIgresso);
                txtComprarIngresso.setText("23792011029001953484220005184401779490000012496");

            }

        });

        Evento evento = (Evento) getIntent().getSerializableExtra("evento");

        txtDetEvento = findViewById(R.id.txtDetEvento);
        txtDetEvento.setText(evento.getSobre());

        imgEvento = findViewById(R.id.imgEvento);
        //  imgEvento.setImageResource(evento.getNomeImagem);

        txtNomeEvento = findViewById(R.id.txtNomeEvento);
        txtNomeEvento.setText(evento.getNome());

        txtDataEvento = findViewById(R.id.txtDataEvento);
        txtDataEvento.setText(evento.getData());

    }
}
