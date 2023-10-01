package ru.cs.vsu.pustylnik_i_v.Elements;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Clouds {
    private int x;
    private int y;
    private ArrayList<Cloud> cloudList;

    public Clouds(int x, int y) {
        this.x = x;
        this.y = y;
        cloudList = new ArrayList<>();
    }

    private void updateCloudPositions() {
        for (int i = 0; i < cloudList.size(); i++) {
            cloudList.get(i).x = x + i * 400;
        }
    }

    public void shiftLeft(int step) {
        x -= step;
        updateCloudPositions();
    }

    public void draw(Graphics2D g) {
        int lastCloudX = x;
        if (!cloudList.isEmpty()) {
            lastCloudX = cloudList.get(cloudList.size() - 1).getX();
        }
        if (lastCloudX < 1000) {
            Random random = new Random();
            int width = random.nextInt(250) + 90;
            int height = random.nextInt(50) + 40;
            int yOffset = random.nextInt(50) + 10;
            cloudList.add(new Cloud(lastCloudX + 400, y + yOffset, width, height));

        }
        if (x < -350) {
            cloudList.remove(0);
            x += 400;
        }
        g.setColor(new Color(232, 232, 232));
        for (Cloud cloud : cloudList) {
            g.fillOval(cloud.getX(), cloud.getY(), cloud.getWidth(), cloud.getHeight());
        }
    }

    static class Cloud {
        private int x;
        private int y;
        private final int width;
        private final int height;

        public Cloud(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }
    }
}
