package indi.koro.shouhou.component;

import aurelienribon.tweenengine.equations.Linear;
import indi.korostudio.ksge.data.Data;
import indi.korostudio.ksge.panel.component.EngineComponent;
import indi.korostudio.ksge.system.image.ImageBase;
import indi.korostudio.ksge.system.image.ImageLoader;
import indi.korostudio.ksge.tool.Tool;
import indi.korostudio.ksge.tool.TweenTool;
import indi.korostudio.ksge.tween.TweenActuator;
import indi.korostudio.ksge.tween.TweenImplements;
import indi.korostudio.ksge.tween.TweenListener;
import indi.korostudio.ksge.tween.TweenSystem;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class LoadingComponent extends EngineComponent {
    protected TweenSystem rotateTween;
    protected TweenActuator actuator;
    protected static ArrayList<BufferedImage> images = null;

    public LoadingComponent() {
        setSize(100, 100);
        rotateTween = TweenTool.SimpleTween(this, 2f, TweenImplements.ROTATE, 360).addTweenListener(new TweenListener() {
            @Override
            public void start() {

            }

            @Override
            public void finish() {
                setRotate(0);
            }

            @Override
            public void pause() {

            }

            @Override
            public void stop() {

            }
        });
        rotateTween.setTweenMode(Linear.INOUT);
        actuator = TweenTool.SimpleActuator(rotateTween);
        actuator.setLoop(true);
        if (ImageBase.get("loading-0") == null) {
            ImageLoader.loadJSONImage(Data.getRes("/file/res/loading/map.json"));
        }
        if (images == null) {
            images = new ArrayList<>();
            for (BufferedImage image : Tool.get360Image(ImageBase.get("loading-0"))) {
                images.add(Tool.reImageSize(image, getWidth(), getHeight()));
            }
            System.gc();
        }
    }

    public void start() {
        setVisible(true);
        actuator.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(images.get(rotate), 0, 0, null);
    }

    public void stop() {
        actuator.setLoop(false);
    }

}
