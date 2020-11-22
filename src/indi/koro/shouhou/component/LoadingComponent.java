package indi.koro.shouhou.component;

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

public class LoadingComponent extends EngineComponent {
    protected TweenSystem rotate;
    protected TweenActuator actuator;
    protected BufferedImage image;

    public LoadingComponent() {
        setSize(50, 50);
        rotate = TweenTool.SimpleTween(this, 10f, TweenImplements.ROTATE, 360).addTweenListener(new TweenListener() {
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
        actuator = TweenTool.SimpleActuator(rotate);
        actuator.setLoop(true);
        if (ImageBase.get("loading-0") == null) {
            ImageLoader.loadJSONImage(Data.getRes("/file/res/loading/map.json"));
        }
        image = Tool.reImageSize(ImageBase.get("loading-0"), 50, 50);
    }

    public void start() {
        setVisible(true);
        actuator.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, 0, 0, null);
    }

    public void stop() {
        actuator.setLoop(false);
    }

}
