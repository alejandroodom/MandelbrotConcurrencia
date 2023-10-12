package com.example.demo;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class InfoPanel extends VBox {
    // La clase InfoPanel mostrará información sobre el Conjunto de Mandelbrot
    private Label iterationsLabel; // Número de iteraciones para el punto seleccionado
    private Label coordinatesLabel; // Coordenadas del punto seleccionado

    public InfoPanel() {
        iterationsLabel = new Label("Iteraciones: 0");
        coordinatesLabel = new Label("Coordenadas: (0, 0)");

        HBox iterationsBox = new HBox(new Label("Iteraciones: "), iterationsLabel);
        HBox coordinatesBox = new HBox(new Label("Coordenadas: "), coordinatesLabel);

        iterationsBox.setAlignment(Pos.CENTER_LEFT);
        coordinatesBox.setAlignment(Pos.CENTER_LEFT);

        getChildren().addAll(iterationsBox, coordinatesBox);
    }

    public void setIterations(int iterations) {
        iterationsLabel.setText("Iteraciones: " + iterations);
    }

    public void setCoordinates(double x, double y) {
        coordinatesLabel.setText("Coordenadas: (" + x + ", " + y + ")");
    }
}


