package ru.vsu.cs.line_drawers;

import ru.vsu.cs.LineDrawer;
import ru.vsu.cs.PixelDrawer;

import java.awt.*;

public class DDALineDrawer implements LineDrawer {
    private PixelDrawer pd;

    public DDALineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;

        if (Math.abs(dx) > Math.abs(dy)){
            if(x1 > x2){
                int tmp = x1; x1 = x2; x2 = tmp;
                tmp = y1; y1 = y2; y2 = tmp;
            }

            double k = dy / dx;

            for (int j = x1; j <= x2; j++) {
                double i = k * (j-x1) + y1;
                pd.setPixel(j, (int)i, Color.RED);
            }



        } else{
            if(y1 > y2){
                int tmp = x1; x1 = x2; x2 = tmp;
                tmp = y1; y1 = y2; y2 = tmp;
            }

            double k = dx / dy;

            for (int i = y1; i <= y2; i++) {
                double j = k * (i-y1) + x1;
                pd.setPixel((int)j, i, Color.GREEN);
            }

        }

    }
}
