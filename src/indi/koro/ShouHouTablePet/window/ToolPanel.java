/**
 *<p>文件名:ToolPanel.java</p>
 * @author 16415
 *创建时间：2019年8月8日 下午8:41:33
 */
package indi.koro.ShouHouTablePet.window;

import java.awt.Color;

import javax.swing.JPanel;

import indi.koro.ShouHouTablePet.data.Data;

/**
 *<p>项目名称：ShouHouTablePet</p>
 *<p>类名称:ToolPanel</p>
 * 作者： 16415
 * 版本：1.0
 *创建时间：2019年8月8日下午8:41:33
 *类描述:
 */
public class ToolPanel extends JPanel {
    /**
     * 
     */
    public ToolPanel() {
	// TODO 自动生成的构造函数存根
	this.setBounds(Data.initialW, 0, Data.initialToolW, Data.initialH);
	this.setBackground(new Color(0, 0, 0, 0.2f));
    }
}
