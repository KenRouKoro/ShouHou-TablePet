package indi.koro.ShouHouTablePet.shouhou;

import indi.koro.ShouHouTablePet.data.Data;
import indi.koro.ShouHouTablePet.music.MusicPlayer;
import indi.koro.ShouHouTablePet.system.Pet;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Shouhou extends Pet {
    Random r = new Random(114154);

    public Shouhou() {
        skin = "祥凤-未改造";
        skins = new String[]{"祥凤-未改造", "祥凤-改造", "祥凤-夜巡的魔女"};
        musicPlayer = new MusicPlayer();
    }

    @Override
    public void setSkin(String skin) {
        this.skin = skin;
        reImage();
    }

    @Override
    public void reImage() {
        nowImege = images.get(skin).getScaledInstance(Data.initialW, Data.initialH - 40, Image.SCALE_SMOOTH);
    }

    @Override
    public void load() {
        try {
            BufferedImage 未改造 = ImageIO.read(Shouhou.class.getResource("/file/image/祥凤.png"));
            BufferedImage 改造 = ImageIO.read(Shouhou.class.getResource("/file/image/祥凤-改.png"));
            BufferedImage 夜巡的魔女 = ImageIO.read(Shouhou.class.getResource("/file/image/祥凤-夜巡的魔女.png"));
            images.put("祥凤-未改造", 未改造);
            images.put("祥凤-改造", 改造);
            images.put("祥凤-夜巡的魔女", 夜巡的魔女);
        } catch (IOException e) {
            e.printStackTrace();
        }
        reImage();
    }

    @Override
    public void touch(double x, double y) {

    }

    @Override
    public String 登录() {
        return String.valueOf(Pet.class.getResource("/file/cue/登录.wav"));
    }

    @Override
    public String 信息() {
        return String.valueOf(Pet.class.getResource("/file/cue/邮件提醒 未改造.wav"));
    }

    @Override
    public String 待机() {
        int i = r.nextInt(3);
        System.out.println(i);
        switch (i) {
            case 0:
                if (skin.equals(skins[0])) return String.valueOf(Pet.class.getResource("/file/cue/主界面1 未改造.wav"));
                else if (skin.equals(skins[2])) return String.valueOf(Pet.class.getResource("/file/cue/主界面1 改造.wav"));
                else return String.valueOf(Pet.class.getResource("/file/cue/主界面1 夜巡的魔女.wav"));
            case 1:
                if (skin.equals(skins[0])) return String.valueOf(Pet.class.getResource("/file/cue/主界面2 未改造.wav"));
                else if (skin.equals(skins[2])) return String.valueOf(Pet.class.getResource("/file/cue/主界面2 改造.wav"));
                else return String.valueOf(Pet.class.getResource("/file/cue/主界面2 夜巡的魔女.wav"));
            case 2:
                if (skin.equals(skins[0])) return String.valueOf(Pet.class.getResource("/file/cue/主界面3 未改造.wav"));
                else if (skin.equals(skins[2])) return String.valueOf(Pet.class.getResource("/file/cue/主界面3 改造.wav"));
                else return String.valueOf(Pet.class.getResource("/file/cue/主界面3 夜巡的魔女.wav"));
        }

        return null;
    }
}
