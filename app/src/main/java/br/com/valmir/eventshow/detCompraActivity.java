package br.com.valmir.eventshow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;

//Inicio da classe

public class detCompraActivity extends AppCompatActivity {

    Button btnCodEntrada;
    TextView txtCod;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_det_compra);

        btnCodEntrada = findViewById(R.id.btnCodEntrada);
        txtCod = findViewById(R.id.txtCod);

// Acão de clique que seta o código de entrada

        btnCodEntrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtCod.setText("123-456");
            }

        });
    }
}