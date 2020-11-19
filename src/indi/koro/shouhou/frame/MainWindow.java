package indi.koro.shouhou.frame;

import indi.korostudio.ksge.frame.MainFrame;

import java.awt.*;

public class MainWindow extends MainFrame {
    public MainWindow() {

    }

    @Override
    protected void load() {
        toJWindow(true);
        super.load();
        setBackground(new Color(255, 255, 255, 0));
    }

    protected void toJWindow(boolean window) {
        setVisible(false);
        setUndecorated(window);
        //else getRootPane().setWindowDecorationStyle();
    }
}
