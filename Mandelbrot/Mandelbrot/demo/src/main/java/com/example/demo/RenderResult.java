package com.example.demo;

import javafx.scene.paint.Color;

public class RenderResult {
    // La clase RenderResult representa los resultados del cálculo del Conjunto de Mandelbrot.
    private Color[][] colors; // Matriz de colores representando los píxeles del Conjunto de Mandelbrot

    public RenderResult(int width, int height) {
        colors = new Color[width][height];
    }

    public Color getColor(int x, int y) {
        return colors[x][y];
    }

    public void setColor(int x, int y, Color color) {
        colors[x][y] = color;
    }
}