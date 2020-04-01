/**
 * <p>文件名:PetPanel.java</p>
 *
 * @author 16415
 * 创建时间：2019年8月8日 下午2:37:41
 */
package indi.koro.ShouHouTablePet.window;

import indi.koro.ShouHouTablePet.data.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * <p>项目名称：ShouHouTablePet</p>
 * <p>类名称:PetPanel</p>
 * 作者： 16415
 * 版本：1.0
 * 创建时间：2019年8月8日下午2:37:41
 * 类描述:
 */
public class PetPanel extends JPanel {
    /**
     *
     */
    Image nowImage = null;
    boolean isTuo = false;
    static Point origin = new Point();


    public void reImage() {
        nowImage = Data.pets.get(Data.nowPet).getNowImege();
        repaint();
    }

    public PetPanel() {
        // TODO 自动生成的构造函数存根
        this.setLayout(null);
        this.setVisible(true);
        this.setOpaque(false);
        this.setBounds(0, 0, Data.initialW, Data.initialH - 40);
        this.addMouseListener(new MouseListener() {
            public void mousePressed(MouseEvent e) {
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
                float X, Y;
                X = e.getX() / Data.petPanel.getWidth();
                Y = e.getY() / Data.petPanel.getHeight();
                Data.petSystem.触摸(X, Y);
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
        this.addMouseMotionListener(new MouseMotionListener() {
            // 拖动（mouseDragged 指的不是鼠标在窗口中移动，而是用鼠标拖动）
            public void mouseDragged(MouseEvent e) {
                if (!isTuo)
                    return;
                // 当鼠标拖动时获取窗口当前位置
                java.awt.Point p = Data.mainJWindow.getLocation();
                // 设置窗口的位置
                // 窗口当前的位置 + 鼠标当前在窗口的位置 - 鼠标按下的时候在窗口的位置
                Data.mainJWindow.setLocation(p.x + e.getX() - origin.x, p.y + e.getY() - origin.y);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                // TODO 自动生成的方法存根

            }
        });
    }

    @Override
    public void paint(Graphics g) {
        // TODO 自动生成的方法存根
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(nowImage, 20, 20, this.getWidth() - 20, this.getHeight() - 20, null);
    }
}
