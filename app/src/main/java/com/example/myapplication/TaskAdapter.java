package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private ArrayList<Tarea> listaTareas;
    private Runnable onStatusChangeListener;

    public TaskAdapter(ArrayList<Tarea> listaTareas, Runnable onStatusChangeListener) {
        this.listaTareas = listaTareas;
        this.onStatusChangeListener = onStatusChangeListener;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Tarea tarea = listaTareas.get(position);
        holder.tvTaskName.setText(tarea.getTituloTarea());

        // Evitar triggers accidentales al reciclar vistas
        holder.cbTaskDone.setOnCheckedChangeListener(null);
        holder.cbTaskDone.setChecked(tarea.isEstaCompletada());

        holder.cbTaskDone.setOnCheckedChangeListener((buttonView, isChecked) -> {
            tarea.setEstaCompletada(isChecked);
            if (onStatusChangeListener != null) {
                onStatusChangeListener.run();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaTareas != null ? listaTareas.size() : 0;
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView tvTaskName;
        CheckBox cbTaskDone;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTaskName = itemView.findViewById(R.id.tvTaskName);
            cbTaskDone = itemView.findViewById(R.id.cbTaskDone);
        }
    }
}
