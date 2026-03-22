package com.example.hellotoast;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int compteur = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvCounter = findViewById(R.id.tv_counter);
        Button   btnToast  = findViewById(R.id.btn_toast);
        Button   btnIncr   = findViewById(R.id.btn_increment);

        // Bouton 1 — Boutton du message message
        btnToast.setOnClickListener(v ->
                Toast.makeText(this, "Hello dear friend", Toast.LENGTH_SHORT).show()
        );

        // Bouton 2 — incrémenter le compteur
        btnIncr.setOnClickListener(v -> {
            compteur++;
            tvCounter.setText(String.valueOf(compteur));
        });
    }
}