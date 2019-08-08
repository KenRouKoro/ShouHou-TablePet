/**
 *<p>文件名:Data.java</p>
 * @author 16415
 *创建时间：2019年7月30日 下午2:20:52
 */
package indi.koro.ShouHouTablePet.data;

import java.awt.image.BufferedImage;
import java.util.HashMap;

import javax.swing.JWindow;

import indi.koro.ShouHouTablePet.system.Pet;
import indi.koro.ShouHouTablePet.system.PetSystem;
import indi.koro.ShouHouTablePet.window.MainWindow;
import indi.koro.ShouHouTablePet.window.PetPanel;
import indi.koro.ShouHouTablePet.window.ToolPanel;

/**
 *<p>项目名称：ShouHouTablePet</p>
 *<p>类名称:Data</p>
 * 作者： 16415
 * 版本：1.0
 *创建时间：2019年7月30日下午2:20:52
 *类描述:
 */
public class Data {
    static public JWindow mainJWindow;
    static public MainWindow mainWindow;
    static public final int initialW=300,initialH=300,initialToolW=100;
    static public HashMap<String, BufferedImage> imageMap=new HashMap<>();
    static public PetPanel petPanel;
    static public PetSystem petSystem;
    static public Pet pet;
    static public int fps=60;
    static public ToolPanel toolPanel;
}
