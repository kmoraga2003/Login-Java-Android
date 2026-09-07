package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WelcomeActivity extends AppCompatActivity {

    private TextView tvWelcomeMsg;
    private Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcome);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvWelcomeMsg = findViewById(R.id.tvWelcomeMsg);
        btnContinue = findViewById(R.id.btnContinue);

        if (Datos.usuarioLogueado != null) {
            String mensaje = "¡Bienvenido/a " + Datos.usuarioLogueado.getNombreCompleto() + "!";
            tvWelcomeMsg.setText(mensaje);
        }

        btnContinue.setOnClickListener(v -> {
            Intent intent = new Intent(WelcomeActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
