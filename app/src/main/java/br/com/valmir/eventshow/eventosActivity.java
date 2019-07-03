//package br.com.valmir.eventshow;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class EventosActivity extends AppCompatActivity {
//
//
//    List<String> eventos;
//    ArrayAdapter<String> adaptdor;
//    ListView lvEventos;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_tap);
//        lvEventos = (ListView) findViewById(R.id.listEventos);
//
//        eventos = new ArrayList<String>();
//
//        eventos.add("IX Seminário nacional do Centro de memória UNICAMP");
//        eventos.add("am_be_do Instituto de Artes UNICAMP");
//        eventos.add("Liderança Avançada");
//        eventos.add("Kotlin Everywhere");
//
//        adaptdor = new ArrayAdapter<String>(EventosActivity.this, android.R.layout.simple_list_item_1, eventos);
//        lvEventos.setAdapter(adaptdor);
//        lvEventos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                switch (position) {
//                    case 0:
//                        evento1();
//                        break;
//                    case 1:
//                        evento2();
//                        break;
//                    case 2:
//                        evento3();
//                        break;
//                    case 3:
//                        evento4();
//                        break;
//
//                }
//            }
//
//        });
//    }
//
//
//    private void evento1() {
//        Intent it = new Intent(EventosActivity.this, detEventoActivity.class);
//        startActivity(it);
//    }
//
//    private void evento2() {
//        Intent it = new Intent(EventosActivity.this, detEventoActivity.class);
//        startActivity(it);
//    }
//
//    private void evento3() {
//        Intent it = new Intent(EventosActivity.this, detEventoActivity.class);
//        startActivity(it);
//    }
//
//    private void evento4() {
//        Intent it = new Intent(EventosActivity.this, detEventoActivity.class);
//        startActivity(it);
//    }
//}
