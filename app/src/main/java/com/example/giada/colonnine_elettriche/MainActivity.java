package com.example.giada.colonnine_elettriche;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
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
import android.graphics.Color;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
public class MainActivity extends AppCompatActivity {

    // Costanti
    private final static String EXTRA_COLONNINE = "colonnine";
    private final static String TAG = "AppColonnine";
    private ImageButton btn2;
    private Button Go;
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

        //Questa parte di codice serve per l'AutoComplete che inserendo una sola lettera nella casella, ci suggerisce i nomi
        //delle città nelle quali si vuole rifornire l'auto
        String [] città = {"Caserta", "Napoli","Capua","Marcianise","Aversa","Afragola"};
        // Creazione dell'istanza di ArrayAdapter contenente l'elenco dei nomi di citta
        ArrayAdapter <String> adapter = new ArrayAdapter <String>(this, android.R.layout.select_dialog_item, città);
        // Ottenere l'istanza di AutoCompleteTextView
        AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.AutoCompleteTextView);
        actv.setThreshold (1); // inizierà a funzionare dal primo carattere
        actv.setAdapter (adapter); // impostazione dei dati dell'adattatore in AutoCompleteTextView




        // definisco un array di stringhe
       String[] supporti = new String[] { "combo","chademo50","type2","type22kw","scame" };
        // definisco un ArrayList
        final ArrayList <String> lista = new ArrayList<String>();
        for (int i = 0; i < supporti.length; ++i) {
            lista.add(supporti[i]);
        }
        // recupero la lista dal layout
        final ListView mylist = (ListView) findViewById(R.id.listviewSupporti);
        // creo e istruisco l'adattatore
        final ArrayAdapter <String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        // inietto i dati
        mylist.setAdapter(adapter1);



        //Inizializzo Radio Group
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.clearCheck();
        //Attach CheckedChangeListener to radio group
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);

                //if(null!=rb && checkedId > -1){
                    //Toast.makeText(MainActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();
               // }

            }
        });

        //bottone che collega il main activity con il login
       ImageButton btn2=(ImageButton) findViewById(R.id.imageButton);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // definisco l'intenzione
                Intent nuova = new Intent(MainActivity.this, login.class);
                // passo all'attivazione dell'activity login.java
                startActivity(nuova);

            }
        });

        //bottone che collega il main activity con l'activity elenco colonnine
        Button btnGo=(Button) findViewById(R.id.Button);
        btnGo.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                 //definisco l'intenzione
               Intent elenco = new Intent(MainActivity.this, elenco_colonnine.class);
                 //passo all'attivazione dell'activity elenco_colonnina.java
                startActivity(elenco);
            }
        });

}




// Colonnina c = new Colonnina();
        //c.setIndirizzogenerico("viale Europa");
       // c.setGestore("Enel");
    // c.setSupporto(TipoSupporto.values());
}

