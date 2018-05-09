package com.example.giada.colonnine_elettriche;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class elenco_colonnine extends AppCompatActivity {

    String Supporto = "type2";
    int NColon = 01;
    String Citta = "Napoli";
    String[] Provincia = {"Caserta", "Napoli"};
    //final ArrayList<String> lista = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elenco_colonnine);
        // Prendo i parametri che ho ottenuto dalla main
        // Mi collego a Firebase ed effettuo la query
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("colonnine").child(String.valueOf(Provincia)).child(String.valueOf(Citta)).child(String.valueOf(NColon));

        // reference.child("Saluti").setValue("Ciao ciao");
        reference.addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(DataSnapshot dataSnapshot) {
                Colonnina value = dataSnapshot.getValue(Colonnina.class);
            }
            //invece di string deve avere la classe colonnina con tutti i valori
              /*  final ListView mylist = (ListView) findViewById(R.id.listviewSupporti);
                // creo e istruisco l'adattatore
                //simple_list_item_1 E' un valore già presente all'interno di Android e rappresenta la singola riga di un classico ListView.
                final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
                // inietto i dati
                mylist.setAdapter(adapter2);
*/


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //DatabaseReference reference = database.getReference("colonnine").child("Caserta").child("Capua");
        //reference.addListenerForSingleValueEvent(new ValueEventListener() {



    }
}
