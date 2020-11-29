package indi.koro.shouhou.component;

import indi.korostudio.ksge.data.Data;
import indi.korostudio.ksge.panel.component.EngineComponent;
import indi.korostudio.ksge.tool.Tool;
import indi.korostudio.ksge.tool.TweenTool;
import indi.korostudio.ksge.tween.TweenImplements;
import indi.korostudio.ksge.tween.TweenListener;
import indi.korostudio.ksge.tween.TweenSystem;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TextPanel extends EngineComponent {
    protected TweenSystem in, out;
    protected BufferedImage textImage = null;
    protected Font font = new Font("黑体", Font.BOLD, 20);

    public TextPanel() {
        this.setAlpha(0f);
        this.setVisible(false);
        in = TweenTool.SimpleTween(this, 2f, TweenImplements.ALPHA, 1f);
        out = TweenTool.SimpleTween(this, 2f, TweenImplements.ALPHA, 0f);
        out.addTweenListener(new TweenListener() {
            @Override
            public void start() {

            }

            @Override
            public void finish() {
                setVisible(false);
            }

            @Override
            public void pause() {

            }

            @Override
            public void stop() {

            }
        });
        this.setSize((int) (Data.w * 0.8), (int) (Data.h * 0.2));
        this.setLocation(0, (int) (Data.h * 0.6));
        setBackground(new Color(50, 50, 50, 150));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString("test", 0, 0);
        g.drawImage(textImage, (int) (getWidth() * 0.025), (int) (getHeight() * 0.1), null);
    }

    public void showThis(String showText) {
        textImage = Tool.stringImage(Color.white, font, showText);
        setVisible(true);
        if (!out.isRunning()) in.start();
    }

    public void end() {
        out.start();
    }
}
