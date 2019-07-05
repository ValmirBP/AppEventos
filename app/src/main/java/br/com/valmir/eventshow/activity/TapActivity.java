package br.com.valmir.eventshow.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

import br.com.valmir.eventshow.R;
import br.com.valmir.eventshow.fragment.EventosFragment;
import br.com.valmir.eventshow.fragment.HistCompraFragment;
import br.com.valmir.eventshow.fragment.MapaFragment;

//Início da classe ononde herda de AppCompactActivity e implenta o menu de Navegação

public class TapActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView navigationView; // >>> Navegação nomeada
    private FirebaseAuth fireAut; // >>> Autenticação do fire base

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tap); //>>> conhecimento do layout de tab

// Identificando em classe R as variaveis

        navigationView = findViewById(R.id.nav_view);
        navigationView.setOnNavigationItemSelectedListener(this);

        fireAut = FirebaseAuth.getInstance(); // >> método do Firebase

        displayEventsFragment(); // >>> fragmentos local onde é reservado para os fregments
    }

// Reconhecimento do menu e passagem de cada fragmento criado

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) { // >>> Aquisição do id de cada fragmento criado

            case R.id.navigation_eventos: { // >>> tela de eventos
                displayEventsFragment();
                break;
            }

            // >>> tela de mapa

            case R.id.navigation_mapa: {
                getSupportActionBar().setTitle("Mapa");
                Fragment mapaFragment = MapaFragment.newInstance();
                openFragment(mapaFragment);
                break;
            }

            // >>> tela de históco de compras

            case R.id.navigation_historico: {
                getSupportActionBar().setTitle("Histórico");
                Fragment histCompraFragment = HistCompraFragment.newInstance();
                openFragment(histCompraFragment);
                break;
            }

            // >>> logout

            case R.id.navigation_sair: {
                Intent it = new Intent(TapActivity.this, LoginActivity.class);
                startActivity(it);
                logout();
                break;
            }
        }
        return true;
    }

// método de logout do Firebase

    private void logout() {
        fireAut.signOut();
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }

//todo consertar esse codiigo entender e comentar

    private void displayEventsFragment() {
        getSupportActionBar().setTitle("Eventos");
        Fragment eventosFragment = EventosFragment.newInstance();
        openFragment(eventosFragment);
    }

// método de abertura do fragmento

    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

// abertura do fragmento do mapa

    public static MapaFragment newInstance() {
        return new MapaFragment();
    }
}

