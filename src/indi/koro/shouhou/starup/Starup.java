package indi.koro.shouhou.starup;

import indi.koro.shouhou.component.LoadingComponent;
import indi.koro.shouhou.frame.MainWindow;
import indi.koro.shouhou.frame.WindowPanel;
import indi.koro.shouhou.pet.PetSystem;
import indi.koro.shouhou.starup.load.LoadScene;
import indi.korostudio.ksge.data.Data;
import indi.korostudio.ksge.panel.Scene;
import indi.korostudio.ksge.system.cmd.CMD;
import indi.korostudio.ksge.system.main.GameStartup;
import indi.korostudio.ksge.tool.Tool;

import javax.swing.*;
import java.util.ArrayList;

public class Starup extends GameStartup {
    protected PetSystem petSystem;
    @Override
    public void load() {
        Data.mainFrame = frame = new MainWindow();
        Data.scenePanel = new WindowPanel();
        Data.firstLoadImageFile.add("/file/res/load/map.json");
        runThread = new Thread(new Runnable() {
            @Override
            public void run() {
                start();
            }
        });
        Data.add(new LoadScene());
        Data.sceneMap.get("load").load();
        petSystem = PetSystem.getPetSystem();
        firstLoad();
        runThread.start();
    }

    public PetSystem getPetSystem() {
        return petSystem;
    }

    @Override
    protected void start() {
        super.start();
        Data.mainFrame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        Data.mainFrame.setAlwaysOnTop(true);
        CMD.run("show load");
        new Thread(new Runnable() {
            @Override
            public void run() {
                afterLoad();
            }
        }).start();
    }

    @Override
    protected void afterLoad() {
        newCom();
        ArrayList<String> classes = Tool.getClassName("indi.koro.shouhou.scene");
        for (String str : classes) {
            try {
                int i;
                if ((i = str.indexOf(".bin.")) != -1) {
                    str = str.substring(i + 5);
                }
                Class clz = Class.forName(str);
                Object obj = clz.newInstance();
                Data.add((Scene) obj);
                ((Scene) obj).load();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {

            }
        }
        super.afterLoad();
        System.out.println("LOADTHREAD:Done!");
        CMD.run("show main");
    }

    protected void newCom() {
        new LoadingComponent();
    }
}
