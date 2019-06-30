package br.com.valmir.eventshow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Hist_CompraActivity extends AppCompatActivity {

    Button btnCodEntrada;
    TextView txtDataCompra, txtNomeComprador, txtQntdIng, txtCod;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_hist_compra);

        btnCodEntrada = findViewById(R.id.btnCodEntrada);
        txtDataCompra = findViewById(R.id.txtDataCompra);
        txtNomeComprador = findViewById(R.id.txtNomeComprador);
        txtQntdIng = findViewById(R.id.txtQntdIng);
        txtCod = findViewById(R.id.txtCod);

        btnCodEntrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtCod.setText("123-456");
            }

        });
    }

}
