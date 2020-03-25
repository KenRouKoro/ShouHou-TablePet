/**
 * <p>文件名:MainWindow.java</p>
 *
 * @author 16415
 * 创建时间：2019年7月30日 下午2:18:27
 */
package indi.koro.ShouHouTablePet.window;

import indi.koro.ShouHouTablePet.data.Data;

import javax.swing.*;
import java.awt.*;

/**
 * <p>项目名称：ShouHouTablePet</p>
 * <p>类名称:MainWindow</p>
 * 作者： 16415
 * 版本：1.0
 * 创建时间：2019年7月30日下午2:18:27
 * 类描述:
 */
public class MainWindow extends JPanel {
    JWindow mainJWindow;
    protected boolean isShow = false;

    /**
     *
     */
    public MainWindow() {
        // TODO 自动生成的构造函数存根
        mainJWindow = new JWindow();
        mainJWindow.setLayout(null);
        Data.mainJWindow = mainJWindow;
        this.setBounds(0, 0, Data.initialW + Data.initialToolW, Data.initialH);
        this.setLayout(null);
        mainJWindow.setSize(Data.initialW + Data.initialToolW, Data.initialH);
        mainJWindow.add(this);
        this.setOpaque(false);
        mainJWindow.setBackground(new Color(0, 0, 0, 0));


    }

    public void show() {
        mainJWindow.setVisible(true);
        isShow = true;
    }

    public void hide() {
        mainJWindow.setVisible(false);
        isShow = false;
    }

    public void setOnTop(boolean b) {
        mainJWindow.setAlwaysOnTop(b);
    }
}
