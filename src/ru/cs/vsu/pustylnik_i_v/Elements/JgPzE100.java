package ru.cs.vsu.pustylnik_i_v.Elements;

import java.awt.*;

public class JgPzE100 {
    private Polygon tower;
    private Polygon gunBase;
    private Polygon body;
    private Polygon behindWheels;
    private final Wheel[] wheels = new Wheel[10];
    private int x, y;
    private final Color base = new Color(87, 87, 87);
    private final Color wheelColor = new Color(61, 61, 61);
    private final Color wheelDarkColor = new Color(47, 47, 47);

    public JgPzE100(int x, int y) {
        this.x = x;
        this.y = y;
        wheels[0] = new Wheel(x + 35, y + 177, 5, 17, 11, wheelDarkColor);
        wheels[1] = new Wheel(x + 110, y + 177, 5, 23, 11, wheelDarkColor);
        wheels[2] = new Wheel(x + 190, y + 177, 5, 23, 11, wheelDarkColor);
        wheels[3] = new Wheel(x + 270, y + 177, 5, 23, 11, wheelDarkColor);
        wheels[4] = new Wheel(x + 350, y + 177, 5, 23, 11, wheelDarkColor);
        wheels[5] = new Wheel(x + 385, y + 160, 7, 17, 11, wheelDarkColor);
        wheels[6] = new Wheel(x + 70, y + 180, 10, 25, 11, wheelColor);
        wheels[7] = new Wheel(x + 150, y + 180, 10, 25, 11, wheelColor);
        wheels[8] = new Wheel(x + 230, y + 180, 10, 25, 11, wheelColor);
        wheels[9] = new Wheel(x + 310, y + 180, 10, 25, 11, wheelColor);
        tower = new Polygon(new int[]{x + 20, x, x + 280, x + 190}, new int[]{y, y + 100, y + 100, y}, 4);
        gunBase = new Polygon(new int[]{x + 190, x + 280, x + 290, x + 290}, new int[]{y, y + 100, y + 57, y + 43}, 4);
        body = new Polygon(new int[]{x, x + 20, x + 370, x + 400, x + 350}, new int[]{y + 100, y + 160, y + 160, y + 135, y + 100}, 5);
        behindWheels = new Polygon(new int[]{x + 20, x + 10, x + 40, x + 350, x + 410, x + 380}, new int[]{y + 160, y + 180, y + 205, y + 205, y + 160, y + 140}, 6);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void draw(Graphics2D g) {
        g.setColor(base);
        g.fillPolygon(behindWheels);
        g.setColor(Color.BLACK);
        g.drawPolygon(behindWheels);
        for (Wheel w : wheels) {
            if (w != null) {
                w.draw(g);
            }
        }

        g.setColor(base);
        g.fillPolygon(tower);
        g.fillPolygon(gunBase);
        g.fillPolygon(body);
        g.fillRect(x + 290, y + 43, 220, 14); // ствол
        g.fillRect(x + 510, y + 40, 40, 20); // дуло
        g.fillRect(x + 60, y - 10, 40, 10); // мини-пушка
        g.fillRect(x + 100, y - 6, 30, 4); // мини-ствол

        g.setColor(Color.BLACK);
        g.drawRect(x + 290, y + 43, 220, 14); // ствол
        g.drawRect(x + 510, y + 40, 40, 20); // дуло
        g.drawRect(x + 60, y - 10, 40, 10); // мини-пушка
        g.drawRect(x + 100, y - 6, 30, 4); // мини-ствол
        g.drawPolygon(body);
        g.drawPolygon(tower);
        g.drawPolygon(gunBase);
        g.drawLine(x + 110, y + 160, x + 110, y + 100);
        g.drawLine(x + 250, y + 160, x + 250, y + 100);
        g.setColor(new Color(51, 50, 50));
        g.fillOval(x + 20, y + 110, 7, 7);
        g.fillOval(x + 90, y + 110, 7, 7);
        g.fillOval(x + 130, y + 110, 7, 7);
        g.fillOval(x + 230, y + 110, 7, 7);
        g.fillOval(x + 270, y + 110, 7, 7);
        g.fillOval(x + 340, y + 110, 7, 7);

        g.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        g.setColor(Color.BLACK);
        g.drawString("Zerstörungskraft", x + 50, y + 50);
    }

    public void updateCoordinates() {
        tower = new Polygon(
                new int[]{x + 20, x, x + 280, x + 190},
                new int[]{y, y + 100, y + 100, y},
                4
        );

        gunBase = new Polygon(
                new int[]{x + 190, x + 280, x + 290, x + 290},
                new int[]{y, y + 100, y + 57, y + 43},
                4
        );

        body = new Polygon(
                new int[]{x, x + 20, x + 370, x + 400, x + 350},
                new int[]{y + 100, y + 160, y + 160, y + 135, y + 100},
                5
        );

        behindWheels = new Polygon(
                new int[]{x + 20, x + 10, x + 40, x + 350, x + 410, x + 380},
                new int[]{y + 160, y + 180, y + 205, y + 205, y + 160, y + 140},
                6
        );
        wheels[0].setY(y + 177);
        wheels[1].setY(y + 177);
        wheels[2].setY(y + 177);
        wheels[3].setY(y + 177);
        wheels[4].setY(y + 177);
        wheels[5].setY(y + 160);
        wheels[6].setY(y + 180);
        wheels[7].setY(y + 180);
        wheels[8].setY(y + 180);
        wheels[9].setY(y + 180);
    }


    public void rotateWheels(int angle) {
        for (Wheel w : wheels) {
            w.rotate(angle);
        }
    }

    public void moveWithSineWave(int step) {
        double frequency = 0.02;
        double amplitude = 20.0;

        double newY = 350 + amplitude * Math.sin(frequency * step);

        if (newY >= 330 && newY <= 370) {
            y = (int) newY;
        }
        updateCoordinates();
    }


    public static class Wheel {
        private final int x;
        private int y;
        private final int r;
        private final int R;
        private final int n;
        private int rotation;
        private final Color c;

        public Wheel(int x, int y, int r, int R, int n, Color c) {
            this.x = x;
            this.y = y;
            this.r = r;
            this.R = R;
            this.n = n;
            this.c = c;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void rotate(int angle) {
            this.rotation = angle;
        }

        private void draw(Graphics2D g) {
            g.setColor(c);
            g.fillOval(x - R, y - R, R + R, R + R);
            g.setColor(Color.BLACK);
            g.drawOval(x - r, y - r, r + r, r + r);
            g.drawOval(x - R, y - R, R + R, R + R);
            double da = 2 * Math.PI / n;
            for (int i = 0; i < n; i++) {
                double a = da * i + Math.toRadians(rotation);
                double x1 = x + r * Math.cos(a);
                double y1 = y + r * Math.sin(a);
                double x2 = x + R * Math.cos(a);
                double y2 = y + R * Math.sin(a);
                g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
            }
        }
    }
}