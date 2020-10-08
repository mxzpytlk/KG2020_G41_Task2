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
        int x = x1;
        int y = y1;
        int Dx = x2 - x1;
        int Dy = y2 - y1;
        int e = 2 * Dy - Dx;
        float d;
        for (int i = 1; i <= Dx; i++) {
            d = -1F * e / (Dy + Dx) / 1.15F;
            if (e >= 0) {
                pd.setPixel(x, y, new Color((int) (1F / 2 - d)));
                pd.setPixel(x, y + 1, new Color((int) (1F / 2 + d)));
                y++;
                e += -2 * Dx + 2 * Dy;
            } else {
                pd.setPixel(x, y, new Color((int) (1F / 2 + d)));
                pd.setPixel(x, y-1, new Color((int) (1F / 2 - d)));
                e += 2 * Dy;
            }
            x++;
        }
    }
}
