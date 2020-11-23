package indi.koro.shouhou.scene.main;

import aurelienribon.tweenengine.equations.Linear;
import indi.koro.shouhou.component.LoadingComponent;
import indi.korostudio.ksge.data.Data;
import indi.korostudio.ksge.panel.Scene;
import indi.korostudio.ksge.panel.component.ImagePanel;
import indi.korostudio.ksge.system.image.ImageBase;
import indi.korostudio.ksge.tool.Tool;
import indi.korostudio.ksge.tool.TweenTool;
import indi.korostudio.ksge.tween.TweenActuator;
import indi.korostudio.ksge.tween.TweenImplements;
import indi.korostudio.ksge.tween.TweenSystem;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MainScene extends Scene {
    protected TweenSystem in, out, up, down;
    protected TweenActuator updown;
    protected ImagePanel pet;
    protected LoadingComponent load;
    protected boolean isTuo = false;
    protected static Point origin = new Point();

    @Override
    public String getSceneName() {
        return "main";
    }

    @Override
    public void load() {
        //ImageBase.put(Tool.loadImage(new File("/file/image/祥凤.png")),"祥凤");
        setSize(Data.mainDimension);
        Data.addLast("/file/image/祥凤/map.json");
        pet = new ImagePanel();
        pet.setBounds((int) (getWidth() * 0.05), (int) (getHeight() * 0.05), (int) (getWidth() * 0.9), (int) (getHeight() * 0.9));
        add(pet);
        up = TweenTool.SimpleTween(pet, 5f, TweenImplements.Y, 0);
        up.setTweenMode(Linear.INOUT);
        down = TweenTool.SimpleTween(pet, 5f, TweenImplements.Y, getHeight() - pet.getHeight());
        down.setTweenMode(Linear.INOUT);
        updown = TweenTool.SimpleActuator(up, down);
        updown.setLoop(true);

        pet.addMouseListener(new MouseListener() {
            // 按下（mousePressed 不是点击，而是鼠标被按下没有抬起）
            public void mousePressed(MouseEvent e) {
                // 当鼠标按下的时候获得窗口当前的位置
                origin.x = e.getX();
                origin.y = e.getY();
                isTuo = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isTuo = false;
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO 自动生成的方法存根
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO 自动生成的方法存根

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO 自动生成的方法存根

            }
        });
        pet.addMouseMotionListener(new MouseMotionListener() {
            // 拖动（mouseDragged 指的不是鼠标在窗口中移动，而是用鼠标拖动）
            public void mouseDragged(MouseEvent e) {
                // 当鼠标拖动时获取窗口当前位置
                java.awt.Point p = Data.mainFrame.getLocation();
                // 设置窗口的位置
                // 窗口当前的位置 + 鼠标当前在窗口的位置 - 鼠标按下的时候在窗口的位置
                Data.mainFrame.setLocation(p.x + e.getX() - origin.x, p.y + e.getY() - origin.y);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                // TODO 自动生成的方法存根

            }
        });
    }

    @Override
    public void in() {
        setAlpha(0);
        pet.setImage(Tool.reImageSize(ImageBase.get("shouhou-2"), (int) (getWidth() * 0.9), (int) (getHeight() * 0.9)));
        setVisible(true);
        in = TweenTool.SimpleTween(this, 2f, TweenImplements.ALPHA, 1f);
        in.start();
        updown.start();
        showLoading();
    }

    @Override
    public void out() {
        this.setVisible(false);
        doNextScene();
    }

    protected void showLoading() {
        load = new LoadingComponent();
        load.setLocation((getWidth() - load.getWidth()) / 2, (getHeight() - load.getHeight()) / 2);
        add(load);
        pet.setVisible(false);
        load.setVisible(true);
        load.start();
    }

    protected void changeImage(String pet) {
        showLoading();
        this.pet.setVisible(false);
        this.pet.setImage(Tool.reImageSize(ImageBase.get(pet), (int) (getWidth() * 0.9), (int) (getHeight() * 0.9)));
        load.stop();
        load.setVisible(false);
        this.pet.setVisible(true);
    }
}
