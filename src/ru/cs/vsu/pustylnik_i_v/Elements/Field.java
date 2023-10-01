package ru.cs.vsu.pustylnik_i_v.Elements;

import java.awt.*;
import java.util.Random;

public class Field {
    private final int[][][] randomXYoffset;
    private final Grass[][] trava;
    private final int x;
    private final int y;
    private final Color c;

    public Field(int x, int y, Color c) {
        this.x = x;
        this.y = y;
        this.c = c;
        Random r = new Random();
        randomXYoffset = new int[380 / 6][1020 / 5][2];
        for (int i = 0; i < randomXYoffset.length; i++) {
            for (int j = 0; j < randomXYoffset[0].length; j++) {
                randomXYoffset[i][j][0] = r.nextInt(5) - 2;
                randomXYoffset[i][j][1] = r.nextInt(5) - 2;
            }
        }
        trava = new Grass[380 / 6][1020 / 5];
        for (int i = 0; i < trava.length; i++) {
            for (int j = 0; j < trava[i].length; j++) {
                trava[i][j] = new Grass(-50 + x + j * 6 + randomXYoffset[i][j][0], y + i * 5 + randomXYoffset[i][j][1], randomXYoffset[i][j][0] * 10, new Color(10, 148 + randomXYoffset[i][j][0] * 10, 10));
            }
        }
    }

    public void shiftLeft(int step) {
        for (Grass[] grassRow : trava) {
            for (Grass grass : grassRow) {
                grass.setX(grass.getX() - step);
                if (grass.getX() < -25) {
                    grass.setX(1200 + x + grass.getX());
                }
            }
        }
    }

    public void draw(Graphics2D g) {
        g.setColor(c);
        g.fillRect(0, 350, 1200, 350);
        for (int yi = 0; yi < trava.length; yi++) {
            for (int xi = 0; xi < trava[yi].length; xi++) {
                g.setColor(new Color(10, 148 + randomXYoffset[yi][xi][0] * 10, 10));
                Grass travinka = trava[yi][xi];
                travinka.draw(g);
            }
        }
    }
}
