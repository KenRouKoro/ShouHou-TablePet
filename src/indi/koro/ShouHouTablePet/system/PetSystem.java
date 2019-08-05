/**
 *<p>文件名:PetSystem.java</p>
 * @author 16415
 *创建时间：2019年7月30日 下午2:21:50
 */
package indi.koro.ShouHouTablePet.system;

import java.io.File;
import java.util.concurrent.CountDownLatch;

import javax.swing.SwingUtilities;

import indi.koro.ShouHouTablePet.data.Data;
import indi.koro.ShouHouTablePet.main.Main;
import indi.koro.ShouHouTablePet.window.MainWindow;
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
    public PetSystem() {
	// TODO 自动生成的构造函数存根
    }
    public void start() {
	mainWindow.show();
	
	
    }
    public void load() {
	mainWindow =new MainWindow();
	Data.mainWindow=mainWindow;
    }
    public void setOnTop(boolean b) {
	mainWindow.setOnTop(b);
    }
	
}
