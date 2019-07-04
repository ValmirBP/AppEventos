package br.com.valmir.eventshow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class eventosActivity extends AppCompatActivity {

    List<String> eventos;
    ArrayAdapter<String> adaptdor;
    ListView lvEventos;

    //Criação de lista fixa

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tap);

        eventos = new ArrayList<String>();

        eventos.add("IX Seminário nacional do Centro de memória UNICAMP");
        eventos.add("am_be_do Instituto de Artes UNICAMP");
        eventos.add("Liderança Avançada");
        eventos.add("Kotlin Everywhere");

    }
}