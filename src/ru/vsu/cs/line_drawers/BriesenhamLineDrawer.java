package ru.vsu.cs.line_drawers;

import ru.vsu.cs.LineDrawer;
import ru.vsu.cs.PixelDrawer;

import java.awt.*;

public class BriesenhamLineDrawer implements LineDrawer {
    PixelDrawer pd;

    public BriesenhamLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    private int sign (int x) {
        return Integer.compare(x, 0);
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        int pdx, pdy, es, el, err;

        int x = x1;
        int y = y1;
        pd.setPixel(x, y, Color.BLACK);

        int dx = x2 - x1;
        int dy = y2 - y1;
        int incx = sign(dx);
        int incy = sign(dy);
        dx = Math.abs(dx);
        dy = Math.abs(dy);

        if (dx > dy) {
            pdx = incx;
            pdy = 0;
            es = dy;
            el = dx;
        }
        else {
            pdx = 0;
            pdy = incy;
            es = dx;
            el = dy;
        }

        err = el/2;
        for (int i = 0; i < el; i++) {
            err -= es;
            if (err < 0) {
                err += el;
                x += incx;//сдвинуть прямую (сместить вверх или вниз, если цикл проходит по иксам)
                y += incy;//или сместить влево-вправо, если цикл проходит по y
            }
            else {
                x += pdx;
                y += pdy;
            }
            pd.setPixel(x, y, Color.BLACK);
        }
    }
}
