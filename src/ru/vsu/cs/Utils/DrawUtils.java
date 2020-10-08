package ru.vsu.cs.Utils;

import ru.vsu.cs.LineDrawer;

public class DrawUtils {
    public static void drawSnowFlake(LineDrawer ld, int x, int y, int r, int raysCount){
        double deg = 2*Math.PI / raysCount;
        for (int i = 0; i < raysCount; i++) {
            double dx = r * Math.cos(deg * i);
            double dy = r * Math.sin(deg * i);
            ld.drawLine(x,y,x + (int)dx,y + (int)dy);
        }
    }


}
