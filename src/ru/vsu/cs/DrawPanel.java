package ru.vsu.cs;

import ru.vsu.cs.Utils.DrawUtils;
import ru.vsu.cs.line_drawers.BriesenhamLineDrawer;
import ru.vsu.cs.line_drawers.DDALineDrawer;
import ru.vsu.cs.line_drawers.GraphicsLineDrawer;
import ru.vsu.cs.line_drawers.WooLineDrawer;
import ru.vsu.cs.pixel_drawers.GraphicsPixelDrawer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel implements MouseMotionListener {

    private Point position = new Point(0,0);

    public DrawPanel() {
        this.addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics bi_g = bi.createGraphics();
        LineDrawer ld = new WooLineDrawer(new GraphicsPixelDrawer(bi_g));
        bi_g.fillRect(0,0,getWidth(),getHeight());
        bi_g.setColor(Color.BLACK);
        drawAll(ld);
        g.drawImage(bi,0,0,null);
        bi_g.dispose();
    }

    public void drawAll(LineDrawer ld){
        DrawUtils.drawSnowFlake(ld,400,400,50,32);
        ld.drawLine(getWidth()/2, getHeight()/2, position.x, position.y);
    }

    @Override
    public void mouseDragged(MouseEvent e) { //с нажатой кнопкой

    }

    @Override
    public void mouseMoved(MouseEvent e) { //Без нажатой
        position = new Point(e.getX(), e.getY());
        repaint();
    }
}
