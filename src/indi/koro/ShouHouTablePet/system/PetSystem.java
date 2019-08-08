/**
 *<p>文件名:PetSystem.java</p>
 * @author 16415
 *创建时间：2019年7月30日 下午2:21:50
 */
package indi.koro.ShouHouTablePet.system;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

import javax.swing.SwingUtilities;

import indi.koro.ShouHouTablePet.data.Data;
import indi.koro.ShouHouTablePet.main.Main;
import indi.koro.ShouHouTablePet.window.MainWindow;
import indi.koro.ShouHouTablePet.window.PetPanel;
import indi.koro.ShouHouTablePet.window.ToolPanel;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *<p>项目名称：ShouHouTablePet</p>
 *<p>类名称:PetSystem</p>
 * 作者： 16415
 * 版本：1.0
 *创建时间：2019年7月30日下午2:21:50
 *类描述:
 */
public class PetSystem {
    /**
     * 
     */
    MainWindow mainWindow;
    PetPanel petPanel;
    Pet pet;
    TimerTask task;
    Timer timer = new Timer(true);
    ToolPanel toolPanel;
    public PetSystem() {
	// TODO 自动生成的构造函数存根
    }
    public void start() {
	mainWindow.show();
	timer.schedule(task, 31,31);
	
    }
    public void load() {
	mainWindow =new MainWindow();
	Data.mainWindow=mainWindow;
	pet=new Pet("data/shouhou");
	Data.pet=pet;
	petPanel=new PetPanel();
	Data.petPanel=petPanel;
	mainWindow.add(petPanel);
	toolPanel=new ToolPanel();
	Data.toolPanel=toolPanel;
	mainWindow.add(toolPanel);
	
	task = new TimerTask() {
	    @Override
	    public void run() {// TODO 
		Data.mainJWindow.repaint();
	    }
	};
	this.setOnTop(true);
	
    }
    public void setOnTop(boolean b) {
	mainWindow.setOnTop(b);
    }
    public void reSize() {
	Data.mainJWindow.setSize(Data.initialW+Data.initialToolW, Data.initialH);
	Data.mainWindow.setSize(Data.initialW+Data.initialToolW, Data.initialH);
	Data.petPanel.setSize(Data.initialW,Data.initialH);
	Data.toolPanel.setBounds(Data.initialW, 0, Data.initialToolW, Data.initialH);
    }
	
}
