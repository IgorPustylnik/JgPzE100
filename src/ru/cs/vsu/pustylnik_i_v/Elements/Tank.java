package ru.cs.vsu.pustylnik_i_v.Elements;

import java.awt.*;
import java.awt.geom.Path2D;
import java.util.Random;

public class Tank {
    private final int towerType;
    private final int gunType;
    private final int bodyType;
    private int x;
    private final int y;
    private final Color color;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
        Random r = new Random();
        towerType = r.nextInt(2);
        gunType = r.nextInt(2);
        bodyType = r.nextInt(2);
        color = new Color(88, 80 + r.nextInt(20), 70 + r.nextInt(30));
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void draw(Graphics2D g) {
        g.setColor(color);

        g.fillRect(x, y - 50, 20, 50);
        g.fillRect(x + 20, y - 50, 100, 30);
        g.fillRect(x + 120, y - 50, 20, 50);
        if (bodyType == 1) {
            g.fillRect(x - 5, y - 70, 150, 20);
            g.setColor(Color.BLACK);
            g.drawRect(x - 5, y - 70, 150, 20);
        } else {
            Path2D p = new Path2D.Double();
            p.moveTo(x + 5, y - 50);
            p.curveTo(x + 5, y - 50, x - 5, y - 50, x - 5, y - 60);
            p.curveTo(x - 5, y - 60, x - 5, y - 70, x + 5, y - 70);
            p.lineTo(x + 135, y - 70);
            p.curveTo(x + 135, y - 70, x + 145, y - 70, x + 145, y - 60);
            p.curveTo(x + 145, y - 60, x + 145, y - 50, x + 135, y - 50);
            p.closePath();
            g.fill(p);
            g.setColor(Color.BLACK);
            g.draw(p);
        }
        g.setColor(color);
        g.fillRect(x + 10, y - 90, 120, 20);

        g.setColor(Color.BLACK);
        g.drawRect(x + 20, y - 50, 100, 30);
        g.drawRect(x + 10, y - 90, 120, 20);
        for (int i = 0; i < 10; i++) { // гусли левые
            g.drawRect(x, y - 50 + i * 5, 20, 5);
        }
        for (int i = 0; i < 10; i++) { // гусли правые
            g.drawRect(x + 120, y - 50 + i * 5, 20, 5);
        }


        if (towerType == 1) { // прямоугольная башня
            g.setColor(color);
            g.fillRect(x + 20, y - 120, 100, 30); // башня
            g.setColor(Color.BLACK);
            g.drawRect(x + 20, y - 120, 100, 30);
            g.drawRect(x + 30, y - 115, 80, 20);
        } else { // округлая башня
            g.setColor(color);
            Path2D p = new Path2D.Double();
            p.moveTo(x + 20, y - 90);
            p.curveTo(x + 20, y - 90, x + 20, y - 120, x + 40, y - 120);
            p.lineTo(x + 100, y - 120);
            p.curveTo(x + 100, y - 120, x + 120, y - 120, x + 120, y - 90);
            p.closePath();
            g.fill(p);
            g.setColor(Color.BLACK);
            g.drawRect(x + 35, y - 115, 70, 20);
            g.draw(p);
        }
        if (gunType == 1) { // пушка вверх
            g.setColor(color);
            g.fillRect(x + 65, y - 155, 10, 55); // пушка
            g.fillOval(x + 65, y - 160, 10, 10);
            g.setColor(Color.BLACK);
            g.drawRect(x + 65, y - 155, 10, 55);
            g.drawOval(x + 65, y - 160, 10, 10);
        } else { // пушка прямо
            g.setColor(Color.BLACK);
            g.drawOval(x + 65, y - 110, 10, 10);
            g.fillOval(x + 68, y - 106, 4, 4);
        }
    }
}
