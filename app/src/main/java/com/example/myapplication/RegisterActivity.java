package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    private EditText etRegName;
    private EditText etRegRut;
    private EditText etRegPhone;
    private EditText etRegEmail;
    private EditText etRegPassword;
    private RadioGroup rgUserType;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Vincular componentes del layout
        etRegName = findViewById(R.id.etRegName);
        etRegRut = findViewById(R.id.etRegRut);
        etRegPhone = findViewById(R.id.etRegPhone);
        etRegEmail = findViewById(R.id.etRegEmail);
        etRegPassword = findViewById(R.id.etRegPassword);
        rgUserType = findViewById(R.id.rgUserType);
        btnRegister = findViewById(R.id.btnRegister);

        // Evento click en registrarse
        btnRegister.setOnClickListener(v -> registrarUsuario());
    }

    private void registrarUsuario() {
        // Obtenemos los valores ingresados en camelCase
        String nombreCompleto = etRegName.getText().toString().trim();
        String rutUsuario = etRegRut.getText().toString().trim();
        String numeroTelefono = etRegPhone.getText().toString().trim();
        String correoEmail = etRegEmail.getText().toString().trim();
        String claveAcceso = etRegPassword.getText().toString().trim();

        // Obtener tipo de usuario desde RadioGroup
        int selectedId = rgUserType.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedId);
        String tipoUsuario = (radioButton != null) ? radioButton.getText().toString() : "Estándar";

        // Validar vacíos
        if (nombreCompleto.isEmpty() || rutUsuario.isEmpty() || numeroTelefono.isEmpty() || correoEmail.isEmpty() || claveAcceso.isEmpty()) {
            Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // 1. Validar Nombre y Apellido
        if (!Validador.esNombreValido(nombreCompleto)) {
            Toast.makeText(this, "Debe ingresar Nombre y Apellido (separados por espacio)", Toast.LENGTH_LONG).show();
            return;
        }

        // 2. Validar RUT con guion
        if (!Validador.esRutValido(rutUsuario)) {
            Toast.makeText(this, "El RUT debe contener guion (-) Ej: 12345678-9", Toast.LENGTH_LONG).show();
            return;
        }

        // 3. Validar Teléfono +56 9
        if (!Validador.esTelefonoValido(numeroTelefono)) {
            Toast.makeText(this, "El teléfono debe iniciar con +56 9 y contener 8 números más", Toast.LENGTH_LONG).show();
            return;
        }

        // 4. Validar Correo
        if (!Validador.esCorreoValido(correoEmail)) {
            Toast.makeText(this, "El correo debe incluir @ y un dominio (.com o .cl)", Toast.LENGTH_LONG).show();
            return;
        }

        // 5. Validar Clave Segura
        if (!Validador.esClaveValida(claveAcceso)) {
            Toast.makeText(this, "La contraseña requiere mín 5 caracteres, 1 mayúscula, 1 número y 1 carácter especial", Toast.LENGTH_LONG).show();
            return;
        }

        // Comprobar duplicados en la lista de usuarios
        for (Usuario u : Datos.listaUsuarios) {
            if (u.getCorreoEmail().equalsIgnoreCase(correoEmail)) {
                Toast.makeText(this, "El correo ya se encuentra registrado", Toast.LENGTH_SHORT).show();
                return;
            }
            if (u.getRutUsuario().equalsIgnoreCase(rutUsuario)) {
                Toast.makeText(this, "El RUT ya se encuentra registrado", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        // Crear nuevo usuario usando setters
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombreCompleto(nombreCompleto);
        nuevoUsuario.setRutUsuario(rutUsuario);
        nuevoUsuario.setNumeroTelefono(numeroTelefono);
        nuevoUsuario.setCorreoEmail(correoEmail);
        nuevoUsuario.setClaveAcceso(claveAcceso);
        nuevoUsuario.setTipoUsuario(tipoUsuario);

        // Guardar en la lista en memoria
        Datos.listaUsuarios.add(nuevoUsuario);

        Toast.makeText(this, "¡Registro exitoso! Ya puedes iniciar sesión", Toast.LENGTH_LONG).show();
        finish();
    }
}
