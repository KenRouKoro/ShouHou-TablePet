/**
 * <p>文件名:Data.java</p>
 *
 * @author 16415
 * 创建时间：2019年7月30日 下午2:20:52
 */
package indi.koro.ShouHouTablePet.data;

import indi.koro.ShouHouTablePet.plugin.Mod;
import indi.koro.ShouHouTablePet.system.ModLoader;
import indi.koro.ShouHouTablePet.system.Pet;
import indi.koro.ShouHouTablePet.system.PetSystem;
import indi.koro.ShouHouTablePet.window.MainWindow;
import indi.koro.ShouHouTablePet.window.MessagePanel;
import indi.koro.ShouHouTablePet.window.PetPanel;
import indi.koro.ShouHouTablePet.window.ToolPanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * <p>项目名称：ShouHouTablePet</p>
 * <p>类名称:Data</p>
 * 作者： 16415
 * 版本：1.0
 * 创建时间：2019年7月30日下午2:20:52
 * 类描述:
 */
public class Data {
    static public JWindow mainJWindow;
    static public MainWindow mainWindow;
    static public MessagePanel messagePanel;
    static public final int initialW = 400, initialH = 440, initialToolW = 120;
    static public PetPanel petPanel;
    static public PetSystem petSystem;
    static public HashMap<String, Pet> pets = new HashMap<>();
    static public int fps = 60;
    static public ToolPanel toolPanel;
    static public String nowPet = "祥凤";
    static public ArrayList<Mod> mods = new ArrayList<>();
    static public ModLoader modLoader;
}
