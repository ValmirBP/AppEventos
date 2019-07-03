package br.com.valmir.eventshow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import br.com.valmir.eventshow.reciclerViews.eventoRecyclerViewAdapter;

public class detCompraActivity extends AppCompatActivity {

    Button btnCodEntrada;
    TextView txtCod;


    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private eventoRecyclerViewAdapter recyclerViewAdapter;
    private EditText addTaskBox;
    /**
     *
     */
    private DatabaseReference databaseReference;
    //private List<Task> allTask;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_det_compra);

        btnCodEntrada = findViewById(R.id.btnCodEntrada);
        txtCod = findViewById(R.id.txtCod);

        btnCodEntrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtCod.setText("123-456");
            }

        });
    }
}