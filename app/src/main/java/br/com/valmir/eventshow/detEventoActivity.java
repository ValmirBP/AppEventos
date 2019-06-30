package br.com.valmir.eventshow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class detEventoActivity extends AppCompatActivity {

    Button btnMaisIng, btnMenosIng, btnGerBol;

    TextView txtNumIngresso;

    private int contagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_det_evento);

        btnMaisIng = findViewById(R.id.btnMaisIng);
        btnMenosIng = findViewById(R.id.btnMenosIng);
        btnGerBol = findViewById(R.id.btnGerBol);
        txtNumIngresso = findViewById(R.id.txtNumIngresso);

        btnMaisIng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contagem++;
                txtNumIngresso.setText("Contagem:" + contagem);

            }
        });
        btnMenosIng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contagem --;
                txtNumIngresso.setText("Contagem:" + contagem);
            }
        });
        btnGerBol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent telaBoleto =
                        new Intent(detEventoActivity.this, Num_BoletoActivity.class);
                startActivity(telaBoleto);
            }

        });
    }
}
