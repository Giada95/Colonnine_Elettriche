package com.example.giada.colonnine_elettriche;

/**
 * Created by Giada on 24/04/2018.
 */

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class login extends AppCompatActivity {

    // Costanti
    private final static String TAG = "Login";

    // Widget
    private EditText mUsername;
    private EditText mPassw;
    private ImageButton btnLogin;

    // Firebase
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Imposto gli attributi relativi ai widget
        mUsername = (EditText)findViewById(R.id.editUsername);
        mPassw = (EditText)findViewById(R.id.editPassw);

        // Impostazione Firebase
        mAuth = FirebaseAuth.getInstance();

        // Imposto il listener per il pulsante
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mUsername.getText().toString();
                String password = mPassw.getText().toString();
                if (email.isEmpty())
                    mUsername.setError(getString(R.string.obbligatorio));
                else if (password.isEmpty())
                    mPassw.setError(getString(R.string.obbligatorio));
                else
                    effettuaLogin(email, password);
            }
        });
    }

    /**
     * Funzione che prova ed effettuare il login
     * @param email indirizzo di email
     * @param password password
     */
    private void effettuaLogin(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "Task completato: successo = " + task.isSuccessful());
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(login.this, nuova_colonnina.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(login.this, R.string.errore_login, Toast.LENGTH_SHORT).show();
                        }
                    }
                });


        btnLogin = (ImageButton)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //definisco l'intenzione
            Intent intent2 = new Intent(login.this, nuova_colonnina.class);
            //passo all'attivazione dell'activity nuova_colonnina.java
            startActivity(intent2);
        }
    });
}
}
