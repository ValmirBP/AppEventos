package br.com.valmir.eventshow;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.valmir.eventshow.activity.TapActivity;

public class CadastroActivity extends AppCompatActivity {

    EditText editNomeCad, editEmailCad, editSenhaCad;

    Button btnCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_cadastro);

        editNomeCad = findViewById(R.id.editNomeCad);
        editEmailCad = findViewById(R.id.editEmailCad);
        editSenhaCad = findViewById(R.id.editSenhaCad);
        btnCadastro = findViewById(R.id.btnCadastrarCad);

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proximaTela();
            }
        });
    }

    private void proximaTela() {

        Intent intent = new Intent(this, TapActivity.class);
        startActivity(intent);
    }
}