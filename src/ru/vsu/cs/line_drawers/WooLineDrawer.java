package ru.vsu.cs.line_drawers;

import ru.vsu.cs.LineDrawer;
import ru.vsu.cs.PixelDrawer;

import java.awt.*;

public class WooLineDrawer implements LineDrawer {
    private PixelDrawer pd;

    public WooLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        if (x2 < x1) {
            x1 += x2;
            x2 = x1 - x2;
            x1 -= x2;
            y1 += y2;
            y2 = y1 - y2;
            y1 -= y2;
        }
        int dx = x2 - x1;
        int dy = y2 - y1;

        if (dx == 0 || dy == 0) {
            new BriesenhamLineDrawer(pd).drawLine(x1, y1, x2, y2);
            return;
        }

        float gradient;
        pd.setPixel(x1, y1, Color.BLACK);

        if (dx > dy) {
            gradient = (float) dy / dx;
            float intery = y1 + gradient;
            for (int x = x1; x < x2; ++x) {
                pd.setPixel(x, (int) intery,
                        new Color(0, 0, 0, (int) (255 - fractionalPart(intery) * 255)));

                pd.setPixel(x, (int)intery + 1,
                        new Color(0, 0, 0, (int) (fractionalPart(intery) * 255)));

                intery += gradient;
            }
        } else {
            gradient = (float) dx / dy;
            float interx = x1 + gradient;
            for (int y = y1; y < y2; ++y) {
                pd.setPixel((int) interx, y,
                        new Color(0, 0, 0, (int) (255 - fractionalPart(interx) * 255)));

                pd.setPixel((int) interx + 1, y,
                        new Color(0, 0, 0, (int) (fractionalPart(interx) * 255)));
                interx += gradient;
            }
        }

        pd.setPixel(x2, y2, Color.BLACK);
    }

    private float fractionalPart(float x) {
        return x - (int)x;
    }
}
