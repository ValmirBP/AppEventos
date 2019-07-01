package br.com.valmir.eventshow.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import br.com.valmir.eventshow.LoginActivity2;
import br.com.valmir.eventshow.R;
import br.com.valmir.eventshow.fragment.EventosFragment;
import br.com.valmir.eventshow.fragment.HistCompraFragment;
import br.com.valmir.eventshow.fragment.MapaFragment;

public class TapActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private TextView mTextMessage;

    private BottomNavigationView navigationView;
    private FirebaseAuth fireAut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tap);

        navigationView = findViewById(R.id.nav_view);
        navigationView.setOnNavigationItemSelectedListener(this);

        fireAut = FirebaseAuth.getInstance();

        displayEventsFragment();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_eventos: {
                displayEventsFragment();
                break;
            }
            case R.id.navigation_mapa: {
                getSupportActionBar().setTitle("Mapa");
                Fragment mapaFragment = MapaFragment.newInstance();
                openFragment(mapaFragment);
                break;
            }
            case R.id.navigation_historico: {
                getSupportActionBar().setTitle("Histórico");
                Fragment histCompraFragment = HistCompraFragment.newInstance();
                openFragment(histCompraFragment);
                break;
            }
            case R.id.navigation_sair: {
                Intent it = new Intent(TapActivity.this, LoginActivity.class);
                startActivity(it);
                logout();
                break;

            }
        }
        return true;
    }

    private void logout() {
        fireAut.signOut();
        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        finish();
    }

    private void displayEventsFragment() {
        getSupportActionBar().setTitle("Eventos");
        Fragment eventosFragment = EventosFragment.newInstance();
        openFragment(eventosFragment);
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
