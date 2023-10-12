package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Conjunto de Mandelbrot");

        int width = 800;
        int height = 600;
        int workerCount = 4; // Número de trabajadores (procesos) para el cálculo concurrente

        MandelbrotPane mandelbrotPane = new MandelbrotPane(width, height, workerCount);
        WorkerCountSpinner workerCountSpinner = new WorkerCountSpinner(mandelbrotPane);

        BorderPane root = new BorderPane();
        root.setBottom(workerCountSpinner);

        Scene scene = new Scene(root, width, height);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}