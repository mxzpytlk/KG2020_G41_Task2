package ru.vsu.cs;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public MainWindow() throws HeadlessException {
        DrawPanel dp = new DrawPanel();
        this.add(dp);
    }

    public static void main(String[] args) {
        MainWindow mw = new MainWindow();

        int width = 800;
        int height = 600;

        mw.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mw.setSize(width, height);
        mw.setVisible(true);
    }
}
