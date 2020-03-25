/**
 * <p>文件名:Pet.java</p>
 *
 * @author 16415
 * 创建时间：2019年7月30日 下午9:17:41
 */
package indi.koro.ShouHouTablePet.system;

import indi.koro.ShouHouTablePet.music.MusicPlayer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;


/**
 * <p>项目名称：ShouHouTablePet</p>
 * <p>类名称:Pet</p>
 * 作者： 16415
 * 版本：1.0
 * 创建时间：2019年7月30日下午9:17:41
 * 类描述:
 */
public abstract class Pet {
    protected HashMap<String, BufferedImage> images = new HashMap<>();
    protected Image nowImege = null;
    protected String skin = "";
    protected MusicPlayer musicPlayer;

    public abstract void setSkin(String skin);

    public abstract void reImage();

    public abstract void load();

    public abstract void touch(double x, double y);

    public abstract String 登录();

    public abstract String 信息();

    public abstract String 待机();

    protected String skins[];

    public Image getNowImege() {
        return nowImege;
    }

    public HashMap<String, BufferedImage> getImages() {
        return images;
    }

    public String getSkin() {
        return skin;
    }

    public String[] getSkins() {
        return skins;
    }
}
