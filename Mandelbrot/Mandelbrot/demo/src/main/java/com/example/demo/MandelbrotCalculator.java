package com.example.demo;

import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MandelbrotCalculator {
    //La clase MandelbrotCalculator se encarga de calcular los colores de los píxeles del Conjunto de Mandelbrot.
    private final ExecutorService executor;

    public MandelbrotCalculator(int workerCount) {
        executor = Executors.newFixedThreadPool(workerCount);
    }

    public List<Future<List<Color>>> calculateMandelbrotAsync(int width, int height, int workerCount) {
        List<Future<List<Color>>> futures = new ArrayList<>();

        int chunkSize = height / workerCount;

        for (int i = 0; i < workerCount; i++) {
            int startY = i * chunkSize;
            int endY = (i == workerCount - 1) ? height : startY + chunkSize;

            Callable<List<Color>> worker = () -> calculateMandelbrotChunk(width, height, startY, endY);
            futures.add(executor.submit(worker));
        }

        return futures;
    }

    private List<Color> calculateMandelbrotChunk(int width, int height, int startY, int endY) {
        List<Color> colors = new ArrayList<>();
        double dx = (3.0 / width);
        double dy = (2.0 / height);

        for (int y = startY; y < endY; y++) {
            for (int x = 0; x < width; x++) {
                double zx = 0;
                double zy = 0;
                double cx = -2.0 + x * dx;
                double cy = -1.0 + y * dy;
                int iteration = 0;

                while (zx * zx + zy * zy < 4.0 && iteration < 1000) {
                    double newZx = zx * zx - zy * zy + cx;
                    double newZy = 2.0 * zx * zy + cy;
                    zx = newZx;
                    zy = newZy;
                    iteration++;
                }

                colors.add(Color.color(iteration / 1000.0, 0, 0));
            }
        }

        return colors;
    }
}

