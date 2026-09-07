package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeActivity extends AppCompatActivity {

    private TextView tvHomeTitle;
    private ProgressBar pbTaskProgress;
    private TextView tvTotalCount;
    private TextView tvPendingCount;
    private TextView tvDoneCount;
    private RecyclerView rvTasks;
    private Button btnGoToAddTaskMenu;
    private Button btnLogout;
    private FloatingActionButton fabAddTask;
    private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Vincular componentes
        tvHomeTitle = findViewById(R.id.tvHomeTitle);
        pbTaskProgress = findViewById(R.id.pbTaskProgress);
        tvTotalCount = findViewById(R.id.tvTotalCount);
        tvPendingCount = findViewById(R.id.tvPendingCount);
        tvDoneCount = findViewById(R.id.tvDoneCount);
        rvTasks = findViewById(R.id.rvTasks);
        btnGoToAddTaskMenu = findViewById(R.id.btnGoToAddTaskMenu);
        btnLogout = findViewById(R.id.btnLogout);
        fabAddTask = findViewById(R.id.fabAddTask);

        if (Datos.usuarioLogueado != null) {
            tvHomeTitle.setText("Hola, " + Datos.usuarioLogueado.getNombreCompleto());
        }

        // Configurar RecyclerView
        rvTasks.setLayoutManager(new LinearLayoutManager(this));
        taskAdapter = new TaskAdapter(Datos.listaTareas, () -> actualizarEstadisticas());
        rvTasks.setAdapter(taskAdapter);

        // Botón de menú para ir a ingresar tarea
        btnGoToAddTaskMenu.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, AddTaskActivity.class);
            startActivity(intent);
        });

        // Botón flotante para ingresar tarea
        fabAddTask.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, AddTaskActivity.class);
            startActivity(intent);
        });

        // Botón para cerrar sesión y volver a inicio
        btnLogout.setOnClickListener(v -> {
            Datos.usuarioLogueado = null;
            Toast.makeText(HomeActivity.this, "Sesión cerrada correctamente", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        actualizarEstadisticas();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Actualizar datos y RecyclerView al regresar de agregar una tarea
        if (taskAdapter != null) {
            taskAdapter.notifyDataSetChanged();
        }
        actualizarEstadisticas();
    }

    private void actualizarEstadisticas() {
        int totalTareas = Datos.listaTareas.size();
        int tareasRealizadas = 0;
        int tareasPendientes = 0;

        // Bucle for e if/else para contar estadisticas
        for (Tarea tarea : Datos.listaTareas) {
            if (tarea.isEstaCompletada()) {
                tareasRealizadas++;
            } else {
                tareasPendientes++;
            }
        }

        tvTotalCount.setText(String.valueOf(totalTareas));
        tvPendingCount.setText(String.valueOf(tareasPendientes));
        tvDoneCount.setText(String.valueOf(tareasRealizadas));

        // Calcular porcentaje de progreso
        int porcentaje = (totalTareas > 0) ? (tareasRealizadas * 100 / totalTareas) : 0;
        pbTaskProgress.setProgress(porcentaje);
    }
}
