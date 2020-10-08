package ru.vsu.cs.line_drawers;

import ru.vsu.cs.LineDrawer;

import java.awt.*;

public class GraphicsLineDrawer implements LineDrawer {
    Graphics g;

    public GraphicsLineDrawer(Graphics g) {
        this.g = g;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        g.drawLine(x1, y1, x2, y2);
    }
}
