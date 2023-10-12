package com.example.demo;

import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class MandelbrotPane extends WritableImage {
    //La clase MandelbrotPane se encarga de renderizar los colores en una imagen que se mostrará en la interfaz de usuario.
    private int width;
    private int height;

    public MandelbrotPane(int width, int height, int workerCount) {
        super(width, height);
        this.width = width;
        this.height = height;

        MandelbrotCalculator calculator = new MandelbrotCalculator(workerCount);
        List<Future<List<Color>>> futures = calculator.calculateMandelbrotAsync(width, height, workerCount);

        for (Future<List<Color>> future : futures) {
            try {
                List<Color> colors = future.get();
                renderColors(colors);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    private void renderColors(List<Color> colors) {
        int x = 0;
        int y = 0;
        for (Color color : colors) {
            this.getPixelWriter().setColor(x, y, color);
            x++;
            if (x >= width) {
                x = 0;
                y++;
            }
        }
    }

    public void setWorkerCount(int newWorkerCount) {
    }
}

