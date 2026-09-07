package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddTaskActivity extends AppCompatActivity {

    private EditText etTaskName;
    private Spinner spCategory;
    private CheckBox cbUrgent;
    private RatingBar rbPriority;
    private Button btnSaveTask;
    private Button btnBackToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_task);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Vincular componentes
        etTaskName = findViewById(R.id.etTaskName);
        spCategory = findViewById(R.id.spCategory);
        cbUrgent = findViewById(R.id.cbUrgent);
        rbPriority = findViewById(R.id.rbPriority);
        btnSaveTask = findViewById(R.id.btnSaveTask);
        btnBackToHome = findViewById(R.id.btnBackToHome);

        // Cargar datos en el Spinner de categorías
        String[] categorias = {"Estudio", "Trabajo", "Personal", "Otro"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, categorias);
        spCategory.setAdapter(adapter);

        btnSaveTask.setOnClickListener(v -> guardarTarea());

        // Botón volver al Menú Principal
        btnBackToHome.setOnClickListener(v -> finish());
    }

    private void guardarTarea() {
        String tituloTarea = etTaskName.getText().toString().trim();
        String categoriaTarea = spCategory.getSelectedItem() != null ? spCategory.getSelectedItem().toString() : "General";
        boolean esUrgente = cbUrgent.isChecked();
        int prioridadTarea = (int) rbPriority.getRating();

        // Validar con if / else
        if (tituloTarea.isEmpty()) {
            Toast.makeText(this, "Por favor escribe el nombre de la tarea", Toast.LENGTH_SHORT).show();
            return;
        }

        // Crear nueva tarea con setters
        Tarea nuevaTarea = new Tarea();
        nuevaTarea.setTituloTarea(tituloTarea);
        nuevaTarea.setCategoriaTarea(categoriaTarea);
        nuevaTarea.setEsUrgente(esUrgente);
        nuevaTarea.setPrioridadTarea(prioridadTarea);
        nuevaTarea.setEstaCompletada(false);

        // Agregar al ArrayList global
        Datos.listaTareas.add(nuevaTarea);

        Toast.makeText(this, "¡Tarea guardada con éxito!", Toast.LENGTH_SHORT).show();
        finish();
    }
}
