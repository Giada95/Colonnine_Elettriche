package com.example.giada.colonnine_elettriche;

/**
 * Created by Giada on 24/04/2018.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;


public class dettagli_colonnina extends AppCompatActivity {

    // Costanti
    private final static String EXTRA_COLONNINA = "colonnina";

    // Widget
    private TextView mIndirizzogenerico;
    private TextView mGestore;
    private TextView mSupporto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dettagli_colonnina);

        // Imposto gli id widget
      /* mIndirizzogenerico= (TextView) findViewById(R.id.textIndirizzogenerico);
        mGestore = (TextView)findViewById(R.id.textGestore);
        mSupporto= (TextView)findViewById(R.id.textSupporto);

        // Ottengo i dati passati ed eventualmente visualizzo lo studente
        Intent intent = getIntent();
        Colonnina colonnina = (Colonnina)intent.getSerializableExtra(EXTRA_COLONNINA);

        if (colonnina!= null) {
            mIndirizzogenerico.setText(colonnina.getIndirizzogenerico());
            mGestore.setText(colonnina.getGestore());
            mSupporto.setText(colonnina.getNomiSupporti());

        }*/
    }
}



