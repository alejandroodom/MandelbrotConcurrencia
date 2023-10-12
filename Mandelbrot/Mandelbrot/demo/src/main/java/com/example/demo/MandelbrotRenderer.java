package com.example.demo;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MandelbrotRenderer extends Canvas {
    // La clase MandelbrotRenderer se encarga de renderizar los colores en una imagen que se mostrará en la interfaz de usuario.
    private RenderResult renderResult; // Los resultados del cálculo del Conjunto de Mandelbrot

    public MandelbrotRenderer(int width, int height) {
        super(width, height);
        renderResult = new RenderResult(width, height);
    }

    public void setRenderResult(RenderResult result) {
        this.renderResult = result;
        render();
    }

    public void render() {
        GraphicsContext gc = getGraphicsContext2D();
        int width = (int) getWidth();
        int height = (int) getHeight();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color color = renderResult.getColor(x, y);
                gc.setFill(color);
                gc.fillRect(x, y, 1, 1);
            }
        }
    }
}