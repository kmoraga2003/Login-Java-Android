package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnGoToRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Vincular componentes
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnGoToRegister = findViewById(R.id.btnGoToRegister);

        // Evento botón Iniciar Sesión
        btnLogin.setOnClickListener(v -> iniciarSesion());

        // Evento botón Ir a Registro
        btnGoToRegister.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    private void iniciarSesion() {
        String correoEmail = etEmail.getText().toString().trim();
        String claveAcceso = etPassword.getText().toString().trim();

        if (correoEmail.isEmpty() || claveAcceso.isEmpty()) {
            Toast.makeText(this, "Ingresa tu correo y contraseña", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean usuarioEncontrado = false;

        // Recorrer el ArrayList de usuarios
        for (Usuario usuario : Datos.listaUsuarios) {
            if (usuario.getCorreoEmail().equalsIgnoreCase(correoEmail) && usuario.getClaveAcceso().equals(claveAcceso)) {
                usuarioEncontrado = true;
                Datos.usuarioLogueado = usuario;
                break;
            }
        }

        if (usuarioEncontrado) {
            Toast.makeText(this, "¡Bienvenido " + Datos.usuarioLogueado.getNombreCompleto() + "!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }
    }
}