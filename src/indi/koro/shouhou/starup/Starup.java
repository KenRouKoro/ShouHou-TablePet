package indi.koro.shouhou.starup;

import indi.koro.shouhou.frame.MainWindow;
import indi.koro.shouhou.frame.WindowPanel;
import indi.koro.shouhou.scene.LoadScene;
import indi.korostudio.ksge.data.Data;
import indi.korostudio.ksge.system.cmd.CMD;
import indi.korostudio.ksge.system.main.GameStartup;

import javax.swing.*;

public class Starup extends GameStartup {
    @Override
    public void load() {
        Data.mainFrame = frame = new MainWindow();
        Data.scenePanel = new WindowPanel();
        runThread = new Thread(new Runnable() {
            @Override
            public void run() {
                start();
            }
        });
        Data.sceneMap.put("load", new LoadScene());
        firstLoad();
        runThread.start();
    }

    @Override
    protected void start() {
        super.start();
        Data.mainFrame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        CMD.run("show load");
    }
}
