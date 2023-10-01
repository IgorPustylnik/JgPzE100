package ru.cs.vsu.pustylnik_i_v.Elements;

import java.awt.*;
import java.util.ArrayList;

public class Tanks {
    private int x;
    private final int y;
    private ArrayList<Tank> tankList;

    public Tanks(int x, int y) {
        this.x = x;
        this.y = y;
        tankList = new ArrayList<>();
    }

    public void shiftLeft(int step) {
        x -= step;
        updateTankPositions();
    }

    public void draw(Graphics2D g) {
        if (tankList.size() < 8) {
            int lastTankX = tankList.isEmpty() ? x : tankList.get(tankList.size() - 1).getX();
            if (lastTankX < 1030) {
                tankList.add(new Tank(lastTankX + 200, y));
            }
        }
        if (x < -140) {
            tankList.remove(0);
            x += 200;
        }
        for (Tank t: tankList) {
            t.draw(g);
        }
    }

    private void updateTankPositions() {
        for (int i = 0; i < tankList.size(); i++) {
            tankList.get(i).setX(x + i * 200);
        }
    }
}
