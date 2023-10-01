package ru.cs.vsu.pustylnik_i_v.Elements;

import java.awt.*;

public class Grass {
    private int x;
    private final int y;
    private final int angle;
    private Color c;

    public Grass(int x, int y, int angle, Color c) {
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.c = c;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void draw(Graphics2D g) {
        g.setColor(c);
        g.drawArc(x,y, 30, 100, angle, angle + 30);
    }
}
