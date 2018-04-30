package com.example.giada.colonnine_elettriche;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.content.ClipData;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.util.ArrayList;
import  java.util.Arrays;
import android.widget.AutoCompleteTextView;
import android.widget.AdapterView.OnItemClickListener;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
public class MainActivity extends AppCompatActivity {
  /* private MultiAutoCompleteTextView Indirizzogenerico;
    private RadioButton Ricaricasta;
    private RadioButton Ricaricaveloc;
    private ListView Supporto;
*/
private Button btn2;
private Button Go;

    // Costanti
    private final static String EXTRA_COLONNINE = "colonnine";
    private final static String TAG = "AppColonnine";
    // Widget
    private ListView listaColonnine;
    // Adapter
    private ColonninaAdapter adapter;
    // Autenticazione Firebase
    private FirebaseAuth mAuth;
    private RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  getResources().getStringArray(R.array.supporti);
        // Autenticazione Firebase
        mAuth = FirebaseAuth.getInstance();
        // Comportamento differenziato
        FirebaseUser user = mAuth.getCurrentUser();
        //if (user == null) {
            // Utente non autenticato, voglio impedire l'accesso
           // Intent intent = new Intent(this, login.class);
           // startActivity(intent);
      //  } else {
            // Utente autenticato.
            // Nessuna operazione richiesta
       // }




        //Inizializzo Radio Group

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.clearCheck();

        //Attach CheckedChangeListener to radio group
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if(null!=rb && checkedId > -1){
                    Toast.makeText(MainActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();
                }

            }
        });
        //bottone che collega il main activity con l'activity dettagli colonnina
        Button btn2=(Button)findViewById(R.id.Button);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // definisco l'intenzione
                Intent elenco = new Intent(MainActivity.this, dettagli_colonnina.class);
                // passo all'attivazione dell'activity dettagli_colonnine.java
                startActivity(elenco);
            }
        });
        //bottone che collega il main activity con l'activity elenco colonnine
        Button btnGo=(Button) findViewById(R.id.Button);
        btnGo.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                 //definisco l'intenzione
               Intent intent = new Intent(MainActivity.this, elenco_colonnine.class);
                 //passo all'attivazione dell'activity elenco_colonnina.java
                startActivity(intent);
            }
        });

}




// Colonnina c = new Colonnina();
        //c.setIndirizzogenerico("viale Europa");
       // c.setGestore("Enel");
    // c.setSupporto(TipoSupporto.values());
}

