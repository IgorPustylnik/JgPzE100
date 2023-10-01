package ru.cs.vsu.pustylnik_i_v;

import ru.cs.vsu.pustylnik_i_v.Elements.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class DrawingPanel extends JFrame implements ActionListener {

    private final int PICTURE_WIDTH = 1200;
    private final int PICTURE_HEIGHT = 700;
    private final int TIMER_DELAY = 10;
    private final Timer timer = new Timer(TIMER_DELAY, this);
    private int ticksFromStart = 0;
    private final Sky sky = new Sky(0, 0, PICTURE_WIDTH,  PICTURE_HEIGHT / 2);
    private final Clouds clouds = new Clouds(100, 100);
    private final Field field = new Field(0, PICTURE_HEIGHT - 10, new Color(38, 148, 29));
    private final JgPzE100 jg = new JgPzE100(300, 350);
    private final Tanks tankList = new Tanks(30, 400);

    public DrawingPanel() {
        setTitle("Jg.Pz. E 100");
        setSize(PICTURE_WIDTH, PICTURE_HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        timer.start();
    }

    @Override
    public void paint(Graphics gr) {
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();

        field.draw(g);
        field.shiftLeft(2);
        sky.draw(g);
        clouds.draw(g);
        clouds.shiftLeft(1);
        tankList.draw(g);
        tankList.shiftLeft(2);
        jg.draw(g);
        jg.moveWithSineWave(ticksFromStart);
        jg.rotateWheels((int) (ticksFromStart * 1.5));
        gr.drawImage(bi, 0, 0, null);
        g.dispose();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            repaint();
            ++ticksFromStart;
        }
    }
}