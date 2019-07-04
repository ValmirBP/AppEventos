package br.com.valmir.eventshow.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import br.com.valmir.eventshow.R;

public class CadastroActivity extends AppCompatActivity {

//Nomeando variáveis

    EditText editEmailCad, editSenhaCad;
    Button btnCadastro;
    FirebaseAuth firebaseAut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_cadastro);

// Identificando em classe R as variaveis

        editEmailCad = findViewById(R.id.editEmailCad);
        editSenhaCad = findViewById(R.id.editSenhaCad);
        btnCadastro = findViewById(R.id.btnCadastrarCad);

        firebaseAut = FirebaseAuth.getInstance();  //>>> Método do Firebase

//Ação de clique de botão onde verifica a senha e -mail estão no padrão do firebase

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = editEmailCad.getText().toString();  //>>> transformação das variaveis em strings
                String senha = editSenhaCad.getText().toString();  //>>>  transformação das variaveis em strings

                if (!TextUtils.isEmpty(email)) { // >>>Checa se senha e e-mail estão preenchidos prara gerer a msmg toast
                    if (TextUtils.isEmpty(senha)) {
                        Toast.makeText(getApplicationContext(), "Favor complete os campos solicitados.", Toast.LENGTH_SHORT).show();
                    }

                    if (senha.length() < 6) { // >>> Checa o tamanho da senha de acordo coma as regras do Firebase
                        Toast.makeText(getApplicationContext(), "A senha deve ter no mínimo 6 caracteres", Toast.LENGTH_SHORT).show();
                    }

// Atenticação do Firebase que cria o usuário

                    firebaseAut.createUserWithEmailAndPassword(email, senha)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                                        finish();
                                    } else {
                                        Toast.makeText(getApplicationContext(), "Erro de autenticação", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                } else {
                    Toast.makeText(getApplicationContext(), "Favor complete os campos solicitados.", Toast.LENGTH_SHORT).show();
                    return;

                }
            }
        });

    }
}