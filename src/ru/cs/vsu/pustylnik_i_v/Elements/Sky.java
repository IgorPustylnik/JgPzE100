package ru.cs.vsu.pustylnik_i_v.Elements;

import java.awt.*;

public class Sky {
    private final int x;
    private final int y;
    private final int width;
    private final int height;

    public Sky(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics2D g) {
        Color startColor = new Color(78, 153, 180);
        Color endColor = Color.WHITE;
        GradientPaint gradient = new GradientPaint(0, 0, startColor, 0, 800, endColor);

        g.setPaint(gradient);
        g.fillRect(x, y, width, height);
    }
}
