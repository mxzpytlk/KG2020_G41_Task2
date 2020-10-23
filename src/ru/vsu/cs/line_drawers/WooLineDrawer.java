package ru.vsu.cs.line_drawers;

import ru.vsu.cs.LineDrawer;
import ru.vsu.cs.PixelDrawer;

import java.awt.*;


public class WooLineDrawer implements LineDrawer {
    private final PixelDrawer pd;

    public WooLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        boolean steep = Math.abs(y1 - y2) > Math.abs(x1 - x2);
        if (steep) {
            int val = x1;
            x1 = y1;
            y1 = val;
            val = x2;
            x2 = y2;
            y2 = val;
        }

        if (x1 > x2) {
            int val = x1;
            x1 = x2;
            x2 = val;
            val = y1;
            y1 = y2;
            y2 = val;
        }

        double dx = x2 - x1;
        double dy = y2 - y1;

        double gradient = dy / dx;
        double y = y1 + gradient;
        for (int x = x1 + 1; x < x2; ++x) {
            int intY = (int) y;
            if (steep) {
                pd.setPixel(intY + 1, x, new Color(0, 0, 0, (float)  (y - intY)));
                pd.setPixel(intY,  x, new Color(0, 0, 0, (float)  (1 - (y - intY))));
            } else {
                pd.setPixel(x, intY + 1, new Color(0, 0, 0, (float) (y - intY)));
                pd.setPixel(x, intY, new Color(0, 0, 0, (float)  (1 - (y - intY))));
            }
            y += gradient;
        }
    }
}
