package com.example.demo;

import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class WorkerCountSpinner extends VBox {
    //La clase WorkerCountSpinner permitirá seleccionar el número de procesos para el cálculo concurrente del Conjunto de Mandelbrot
    private Spinner<Integer> spinner;
    private Label label;

    public WorkerCountSpinner(MandelbrotPane mandelbrotPane) {
        label = new Label("Número de Trabajadores:");
        spinner = new Spinner<>(1, 16, 4); // Rango de 1 a 16, valor inicial 4

        // Manejar cambios en el valor del Spinner
        spinner.valueProperty().addListener((observable, oldValue, newValue) -> {
            int newWorkerCount = newValue;
            // Actualiza el número de trabajadores en MandelbrotPane
            mandelbrotPane.setWorkerCount(newWorkerCount);
        });

        getChildren().addAll(label, spinner);
    }
}
