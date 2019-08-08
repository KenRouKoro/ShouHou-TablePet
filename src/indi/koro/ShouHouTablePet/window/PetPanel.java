/**
 *<p>文件名:PetPanel.java</p>
 * @author 16415
 *创建时间：2019年8月8日 下午2:37:41
 */
package indi.koro.ShouHouTablePet.window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import indi.koro.ShouHouTablePet.data.Data;
import indi.koro.ShouHouTablePet.music.MusicPlayer;
import indi.koro.ShouHouTablePet.system.Pet;

/**
 *<p>项目名称：ShouHouTablePet</p>
 *<p>类名称:PetPanel</p>
 * 作者： 16415
 * 版本：1.0
 *创建时间：2019年8月8日下午2:37:41
 *类描述:
 */
public class PetPanel extends JPanel {
    /**
     * 
     */
    TimerTask task;
    Timer timer = new Timer(true);
    Image nowImage=null;
    boolean isTuo=false;
    static Point origin = new Point();
    MusicPlayer musicPlayer=new MusicPlayer();
    
    
    public PetPanel() {
	// TODO 自动生成的构造函数存根
    this.setLayout(null);
    this.setVisible(true);
    this.setOpaque(false);
    this.setBounds(0, 0, Data.initialW, Data.initialH);
  
    task = new TimerTask() {
	    @Override
	    public void run() {// TODO 1S后执行，没间隔1S 重复做的事情
		Image image;
		image=( Data.pet.getSkinHashMap().get(Data.pet.getSkin())).getScaledInstance(Data.initialW, Data.initialH, Image.SCALE_SMOOTH);
		nowImage=image;
	    }
	};
	timer.schedule(task, 500, 500);
	this.addMouseListener(new MouseListener() {
	    // 按下（mousePressed 不是点击，而是鼠标被按下没有抬起）
	    public void mousePressed(MouseEvent e) {
	        // 当鼠标按下的时候获得窗口当前的位置
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
		// TODO 自动生成的方法存根
		if((e.getY()<=Data.initialH*0.5)&(e.getY()>=Data.initialH*0.4)) {
		    if(musicPlayer.getMusicMediaPlayer()!=null) musicPlayer.stop();
		    musicPlayer.setURI(Data.pet.getFile()+"/cue/特殊触摸 未改造.wav");
		    musicPlayer.play();
		}else {
		    if(musicPlayer.getMusicMediaPlayer()!=null)musicPlayer.stop();
		    musicPlayer.setURI(Data.pet.getFile()+"/cue/普通触摸 未改造.wav");
		    musicPlayer.play();
		}
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
        Graphics2D g2d=(Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
	g2d.drawImage(nowImage, 0, 0,this.getWidth(), this.getHeight(), null);
    }
}
