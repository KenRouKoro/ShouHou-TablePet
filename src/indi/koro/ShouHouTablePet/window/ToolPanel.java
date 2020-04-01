/**
 * <p>文件名:ToolPanel.java</p>
 *
 * @author 16415
 * 创建时间：2019年8月8日 下午8:41:33
 */
package indi.koro.ShouHouTablePet.window;

import indi.koro.ShouHouTablePet.data.Data;
import indi.koro.ShouHouTablePet.system.Pet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * <p>项目名称：ShouHouTablePet</p>
 * <p>类名称:ToolPanel</p>
 * 作者： 16415
 * 版本：1.0
 * 创建时间：2019年8月8日下午8:41:33
 * 类描述:
 */
public class ToolPanel extends JPanel {
    /**
     *
     */
    JComboBox skinComboBox;
    JLabel skinJLabel;
    JComboBox petComboBox;
    JLabel petJLabel;
    Box box;
    Font font;

    public ToolPanel() {
        // TODO 自动生成的构造函数存根
        this.setBounds(Data.initialW, 0, Data.initialToolW, Data.initialH);
        this.setBackground(new Color(0, 0, 0, 0.2f));
        box = Box.createVerticalBox();
        this.add(box);
        font = new Font("黑体", Font.BOLD, 12);
        skinComboBox = new JComboBox(Data.pets.get(Data.nowPet).getSkins());
        //skinComboBox.setFont(font);
        skinComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Data.petSystem.changeSkin((String) skinComboBox.getSelectedItem());
            }
        });
        skinJLabel = new JLabel("切换皮肤");
        skinJLabel.setSize(100, 20);
        skinJLabel.setFont(font);
        skinJLabel.setForeground(Color.white);
        skinJLabel.setHorizontalAlignment(JLabel.LEFT);

        petJLabel = new JLabel("切换模型");
        petJLabel.setSize(100, 20);
        petJLabel.setFont(font);
        petJLabel.setForeground(Color.white);
        petJLabel.setHorizontalAlignment(JLabel.LEFT);

        ArrayList<String> petNames = new ArrayList<>();
        for (Pet pet : Data.pets.values()) {
            petNames.add(pet.getName());
        }
        petComboBox = new JComboBox(petNames.toArray());
        petComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Data.petSystem.changePet((String) petComboBox.getSelectedItem());
            }
        });

        box.add(skinJLabel);
        box.add(skinComboBox);
        box.add(petJLabel);
        box.add(petComboBox);
        JButton jButton = new JButton("退出");
        jButton.setSize(100, 20);
        jButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        box.add(jButton);
    }

    public void rePet() {
        skinComboBox.removeAllItems();
        skinComboBox.addItem(Data.pets.get(Data.nowPet).getSkins());
    }
}
