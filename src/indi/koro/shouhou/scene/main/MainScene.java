package indi.koro.shouhou.scene.main;

import aurelienribon.tweenengine.equations.Sine;
import indi.koro.shouhou.component.LoadingComponent;
import indi.koro.shouhou.pet.Pet;
import indi.koro.shouhou.pet.PetSystem;
import indi.koro.shouhou.starup.Starup;
import indi.korostudio.ksge.data.Data;
import indi.korostudio.ksge.panel.Scene;
import indi.korostudio.ksge.panel.component.ImagePanel;
import indi.korostudio.ksge.system.image.ImageBase;
import indi.korostudio.ksge.system.image.ImageLoader;
import indi.korostudio.ksge.tool.Tool;
import indi.korostudio.ksge.tool.TweenTool;
import indi.korostudio.ksge.tween.TweenActuator;
import indi.korostudio.ksge.tween.TweenImplements;
import indi.korostudio.ksge.tween.TweenListener;
import indi.korostudio.ksge.tween.TweenSystem;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MainScene extends Scene {
    protected TweenSystem in, out, up, down;
    protected TweenActuator updown, jump;
    protected ImagePanel petPanel;
    protected LoadingComponent load;
    protected boolean isTuo = false;
    protected static Point origin = new Point();
    protected Pet pet;
    protected PetSystem petSystem;

    @Override
    public String getSceneName() {
        return "main";
    }

    public void touch(MouseEvent event) {
        petSystem.touch(1 - event.getX() / petPanel.getWidth(), 1 - event.getY() / petPanel.getWidth());
        jump();
    }

    @Override
    public void load() {
        //ImageBase.put(Tool.loadImage(new File("/file/image/祥凤.png")),"祥凤");
        setAlpha(0);
        setSize(Data.mainDimension);
        Data.addLast("/file/image/祥凤/map.json");
        petPanel = new ImagePanel();
        petPanel.setBounds((int) (getWidth() * 0.05), (int) (getHeight() * 0.05), (int) (getWidth() * 0.9), (int) (getHeight() * 0.9));
        add(petPanel);
        petSystem = ((Starup) Data.gameStartup).getPetSystem();
        setUpDown();

        petPanel.addMouseListener(new MouseListener() {
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
                touch(e);
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
        petPanel.addMouseMotionListener(new MouseMotionListener() {
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

    protected void setUpDown() {
        up = TweenTool.SimpleTween(petPanel, 5f, TweenImplements.Y, 0);
        up.setTweenMode(Sine.INOUT);
        down = TweenTool.SimpleTween(petPanel, 5f, TweenImplements.Y, getHeight() - petPanel.getHeight());
        down.setTweenMode(Sine.INOUT);
        updown = TweenTool.SimpleActuator(up, down);
        updown.setLoop(true);
    }

    public void jump() {
        jump = TweenTool.SimpleActuator(TweenTool.SimpleTween(petPanel, 1f, TweenImplements.Y, 0), TweenTool.SimpleTween(petPanel, 1f, TweenImplements.Y, getHeight() - petPanel.getHeight()));
        jump.addTweenListener(new TweenListener() {
            @Override
            public void start() {

            }

            @Override
            public void finish() {
                updown.start();
            }

            @Override
            public void pause() {

            }

            @Override
            public void stop() {

            }
        });
        updown.stop();
        setUpDown();
        jump.start();
    }

    @Override
    public void in() {
        setAlpha(0);
        petPanel.setImage(Tool.reImageSize(ImageBase.get("shouhou-2"), (int) (getWidth() * 0.9), (int) (getHeight() * 0.9)));
        setVisible(true);
        in = TweenTool.SimpleTween(this, 2f, TweenImplements.ALPHA, 1f);
        in.start();
        updown.start();
    }

    @Override
    public void out() {
        this.setVisible(false);
        doNextScene();
    }

    public void showLoading() {
        load = new LoadingComponent();
        load.setLocation((getWidth() - load.getWidth()) / 2, (getHeight() - load.getHeight()) / 2);
        add(load);
        petPanel.setVisible(false);
        load.setVisible(true);
        load.start();
    }

    public void changePet(Pet pet) {
        showLoading();
        ImageLoader.removeJSONImage(Data.getRes(pet.getJSONFileString()));
        this.pet = pet;
        ImageLoader.loadJSONImage(Data.getRes(pet.getJSONFileString()));
        changeImage(pet.getSkinFileMame().get(0));

    }

    protected void changeImage(String petImage) {
        showLoading();
        this.petPanel.setVisible(false);
        this.petPanel.setImage(Tool.reImageSize(ImageBase.get(petImage), (int) (getWidth() * 0.9), (int) (getHeight() * 0.9)));
        if (load.isStart()) load.stop();
        load.setVisible(false);
        this.petPanel.setVisible(true);
    }
}
