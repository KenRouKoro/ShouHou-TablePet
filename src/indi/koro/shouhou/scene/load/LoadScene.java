package indi.koro.shouhou.scene.load;


import indi.koro.shouhou.component.LoadingComponent;
import indi.korostudio.ksge.data.Data;
import indi.korostudio.ksge.panel.Scene;
import indi.korostudio.ksge.system.image.ImageBase;
import indi.korostudio.ksge.tool.Tool;
import indi.korostudio.ksge.tool.TweenTool;
import indi.korostudio.ksge.tween.TweenActuator;
import indi.korostudio.ksge.tween.TweenImplements;
import indi.korostudio.ksge.tween.TweenListener;
import indi.korostudio.ksge.tween.TweenSystem;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class LoadScene extends Scene {
    protected TweenSystem in, out, lastout;
    protected TweenActuator inout;
    protected int nowImage = 1;
    protected Random r = new Random();
    protected Font font;
    protected BufferedImage strImage;
    protected Image image;
    protected LoadScene loadScene = this;

    @Override
    public void setVisible(boolean aFlag) {
        super.setVisible(aFlag);
        if (!aFlag) {
            if (inout.isRunning()) {
                inout.stop();
            }
        }
    }

    @Override
    public void in() {
        setAlpha(0f);
        in = TweenTool.SimpleTween(this, 4f, TweenImplements.ALPHA, 1f);
        out = TweenTool.SimpleTween(this, 4f, TweenImplements.ALPHA, 0f);
        lastout = TweenTool.SimpleTween(this, 4f, TweenImplements.ALPHA, 0f);
        inout = TweenTool.SimpleActuator(in, out);
        inout.setLoop(true);
        reImage();
        Data.scenePanel.add(this);
        this.setVisible(true);
        lastout.addTweenListener(new TweenListener() {
            @Override
            public void start() {

            }

            @Override
            public void finish() {
                setVisible(false);
                setAlpha(1f);
                Data.scenePanel.remove(loadScene);
                loadScene.doNextScene();
            }

            @Override
            public void pause() {

            }

            @Override
            public void stop() {

            }
        });
        inout.start();
    }

    @Override
    public void out() {
        inout.stop();
        lastout.start();
    }

    public void load() {
        this.setLayout(null);
        this.setBackground(Color.white);
        this.setSize(Data.mainDimension);
        this.setAlpha(0f);
        font = new Font("Times New Roman", Font.BOLD, 40);
        strImage = Tool.stringImage(Color.GRAY, font, "loading......");
        LoadingComponent loadingComponent = new LoadingComponent();
        loadingComponent.start();
        add(loadingComponent);

        System.out.print(this);
    }

    public void reImage() {
        image = ImageBase.get("load-0").getScaledInstance(150, 150, Image.SCALE_SMOOTH);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        ((Graphics2D) g).drawString("test", 100, 100);
        g2d.drawImage(image, getWidth() - 350, getHeight() - 150, 150, 150, null);
        g2d.setFont(font);
        g2d.drawImage(strImage, getWidth() - 200, getHeight() - 50, null);
    }
}
