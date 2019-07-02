package br.com.valmir.eventshow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class detEventoActivity extends AppCompatActivity {

    Button btnGerBol;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_det_evento);
        btnGerBol = findViewById(R.id.btnGerBol);

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
