package br.com.valmir.eventshow.activity;


import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.com.valmir.eventshow.R;

public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

//Nomeando as variáveis

    Button btnLogin, btnCadastro, login_button;
    SignInButton btnGoogle;
    EditText editEmail, editSenha;

// utilização da documentação do Google/Facebook/para configuração e implenetação

    private FirebaseAuth fireAut;                            // >>> Autenticação em Firebase
    private GoogleSignInClient mGoogleSignInClient;          // >>> Entrar com google
    private static final int RC_SIGN_IN = 9001;              // >>> Codigo de entrada para google
    private static final int RC_SIGN_IN_FACEBOOK = 64206;    // >>> Código de entrada para facebook
    private static final String TAG = "Login Activity";      // >>> Tag para log em logCat
    private CallbackManager mCallbackManager;                // >>> Gerenciador do facebook

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_login);
        printHashKey(this);

// Identificando em classe R as variaveis

        editEmail = findViewById(R.id.editE_mail);
        editSenha = findViewById(R.id.editSenha);
        btnLogin = findViewById(R.id.btnLogin);
        btnCadastro = findViewById(R.id.btnCadastrar);
        login_button = findViewById(R.id.login_button);
        btnGoogle = findViewById(R.id.btnGoogle);

        fireAut = FirebaseAuth.getInstance();               // >>> Método do Firebase

// Ação de botão que que gera a escolha da conta google e depois de autenticado vai para a lista de eventos

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entrarGoogle();

            }
        });

// Ação do botão que entra para a lista de eventos

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entrar();
            }
        });

// Ação do botão que entra para oa lista de eventos

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                telaCadastro();
            }
        });

// Opções login do google

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

//Entrada com conta do google

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


// Gerenciador de login do Facebook

        mCallbackManager = CallbackManager.Factory.create();
        LoginButton loginButton = findViewById(R.id.login_button);
        loginButton.setReadPermissions("email", "public_profile");
        loginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {

// Ação do facebook que gera uma janela de login em caso de sucesso em caso de cancelamento e erro obtem-se um log na ide (Logcat)

            @Override
            public void onSuccess(LoginResult loginResult) {

                Log.d(TAG, "facebook:onSuccess:" + loginResult);
                handleFacebookAccessToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                Log.d(TAG, "facebook:onCancel");
            }

            @Override
            public void onError(FacebookException error) {
                Log.d(TAG, "facebook:onError", error);

            }
        });

    }

// Método encontrado na internet que gera a chave necessária para inserir em Facebook Dev
// Esta hash é usada para inserir na autenticação do firebase com o Facebook

    public void printHashKey(Context pContext) {
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String hashKey = new String(Base64.encode(md.digest(), 0));
                Log.i(TAG, "printHashKey() Hash Key: " + hashKey);
            }
        } catch (NoSuchAlgorithmException e) {
            Log.e(TAG, "printHashKey()", e);
        } catch (Exception e) {
            Log.e(TAG, "printHashKey()", e);
        }
    }

// Autenticação de email no firebase

    @Override
    public void onStart() {
        super.onStart();

        FirebaseUser currentUser = fireAut.getCurrentUser();

    }

// Método que gera a escolha da conta do google e autentica o login

    private void entrarGoogle() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

// Método que passa para a tela de cadastro

    private void telaCadastro() {
        Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
        startActivity(intent);
    }

// Método que passa para a tela de eventos

    private void telaEventos() {
        Intent intent = new Intent(LoginActivity.this, TapActivity.class);
        startActivity(intent);
    }

// Método que confere no firebase senha e e-mail e realiza o login.

    private void entrar() {
        String email = editEmail.getText().toString();
        String senha = editSenha.getText().toString();

        fireAut.signInWithEmailAndPassword(email, senha)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = fireAut.getCurrentUser();
                            telaEventos();
                        } else {
                            Toast.makeText(LoginActivity.this, "E-mail ou senha inválidos ",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }

    // Atentucação do facebook

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                authWithGoogle(account);
            } catch (ApiException e) {
            }
        }
        if (requestCode == RC_SIGN_IN_FACEBOOK) {
            super.onActivityResult(requestCode, resultCode, data);
            mCallbackManager.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void handleFacebookAccessToken(AccessToken token) {

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        fireAut.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            startActivity(new Intent(getApplicationContext(), TapActivity.class));
                            finish();

                        } else {
                            Toast.makeText(getApplicationContext(), "Falha de  autenticação.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    //Autenticação do google

    private void authWithGoogle(GoogleSignInAccount account) {
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        fireAut.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {

                    startActivity(new Intent(getApplicationContext(), TapActivity.class));
                    finish();

                } else {
                    Toast.makeText(getApplicationContext(), "Falha de  autenticação.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}