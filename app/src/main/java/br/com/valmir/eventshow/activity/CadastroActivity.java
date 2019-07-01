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

    EditText editEmailCad, editSenhaCad;
    Button btnCadastro;
    FirebaseAuth firebaseAut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_cadastro);

        editEmailCad = findViewById(R.id.editEmailCad);
        editSenhaCad = findViewById(R.id.editSenhaCad);
        btnCadastro = findViewById(R.id.btnCadastrarCad);

        firebaseAut = FirebaseAuth.getInstance();

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editEmailCad.getText().toString();
                String senha = editSenhaCad.getText().toString();

                if (!TextUtils.isEmpty(email)) {
                    if (TextUtils.isEmpty(senha)) {
                        Toast.makeText(getApplicationContext(), "Favor complete os campos solicitados.", Toast.LENGTH_SHORT).show();
                    }

                    if (senha.length() < 6) {
                        Toast.makeText(getApplicationContext(), "A senha deve ter no mínimo 6 caracteres", Toast.LENGTH_SHORT).show();
                    }

                    firebaseAut.createUserWithEmailAndPassword(email, senha)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                                        finish();
                                    } else {
                                        Toast.makeText(getApplicationContext(), "E-mail ou senha incorretos", Toast.LENGTH_SHORT).show();
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