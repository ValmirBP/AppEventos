package br.com.valmir.eventshow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.com.valmir.eventshow.model.Evento;

//Inicio da classe

public class detEventoActivity extends AppCompatActivity {

    Button btnGerBol;
    private TextView txtInfoEvento;
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

// Ação de botão que gera meu número de boleto para pagamento

            @Override
            public void onClick(View v) {

                txtComprarIngresso = findViewById(R.id.txtComparIgresso);
                txtComprarIngresso.setText("23792.01102.90019.534842.20005.184401.779490 0 00012496456182");
                String codItem = getIntent().getStringExtra("codItem");
                Toast.makeText(getApplicationContext(),
                        "Copiado para a área de transferência", Toast.LENGTH_SHORT).show();

// Escreve dadso no BQD

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("evento/" + codItem + "/boleto");

                myRef.setValue("23792.01102.90019.534842.20005.184401.779490 0 00012496456182");

            }

        });

// todo entender

        Evento evento = (Evento) getIntent().getSerializableExtra("evento");

        txtInfoEvento = findViewById(R.id.txtInfoEvento);
        txtInfoEvento.setText(evento.getSobre());

        imgEvento = findViewById(R.id.imgEvento);
        //  imgEvento.setImageResource(evento.getNomeImagem);

        txtNomeEvento = findViewById(R.id.txtNomeEvento);
        txtNomeEvento.setText(evento.getNome());

        txtDataEvento = findViewById(R.id.txtDataEvento);
        txtDataEvento.setText(evento.getData());

    }
}
