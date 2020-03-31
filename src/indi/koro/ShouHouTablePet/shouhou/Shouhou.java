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
    public String 触摸(double x, double y) {
        Data.messagePanel.paintMessage("虽然吾不在乎，但是最好别对其他人也这样！");
        return String.valueOf(Pet.class.getResource("/file/cue/普通触摸 未改造.wav"));
    }

    @Override
    public String 登录() {
        Data.messagePanel.paintMessage("吾会守护指挥官的，这是吾毕生的职责！");
        return String.valueOf(Pet.class.getResource("/file/cue/登录.wav"));
    }

    @Override
    public String 信息() {
        Data.messagePanel.paintMessage("指挥官，信~在你的头上~");
        return String.valueOf(Pet.class.getResource("/file/cue/邮件提醒 未改造.wav"));
    }

    @Override
    public String 待机() {
        int i = r.nextInt(3);
        System.out.println(i);
        switch (i) {
            case 0:
                if (skin.equals(skins[0])) {
                    Data.messagePanel.paintMessage("呀，指挥官，今天也是干劲十足的一天呢，吾已经准备好把那些蠢货痛扁一顿了～");
                    return String.valueOf(Pet.class.getResource("/file/cue/主界面1 未改造.wav"));
                } else if (skin.equals(skins[1])) {
                    Data.messagePanel.paintMessage("指挥官，给吾一个证明自己实力的机会吧！");
                    return String.valueOf(Pet.class.getResource("/file/cue/主界面1 改造.wav"));
                } else {
                    Data.messagePanel.paintMessage("Trick or treat!");
                    return String.valueOf(Pet.class.getResource("/file/cue/主界面1 夜巡的魔女.wav"));
                }
            case 1:
                if (skin.equals(skins[0])) {
                    Data.messagePanel.paintMessage("我、吾平时都很受姐姐们的照顾……说实话真想快点成为能独当一面的人啊");
                    return String.valueOf(Pet.class.getResource("/file/cue/主界面2 未改造.wav"));
                } else if (skin.equals(skins[1])) {
                    Data.messagePanel.paintMessage("明明吾已经是大人了，为什么大家还把吾当成妹妹啊！");
                    return String.valueOf(Pet.class.getResource("/file/cue/主界面2 改造.wav"));
                } else {
                    Data.messagePanel.paintMessage("嘿嘿，吾果然是个美人胚子~");
                    return String.valueOf(Pet.class.getResource("/file/cue/主界面2 夜巡的魔女.wav"));
                }
            case 2:
                if (skin.equals(skins[0])) {
                    Data.messagePanel.paintMessage("指挥官，今天天气这么好不要闷不做声啦！来，一~起~玩~嘛~");
                    return String.valueOf(Pet.class.getResource("/file/cue/主界面3 未改造.wav"));
                } else if (skin.equals(skins[1])) {
                    Data.messagePanel.paintMessage("大、大人也是需要游戏的！所以，指挥官，一~起~玩~嘛~");
                    return String.valueOf(Pet.class.getResource("/file/cue/主界面3 改造.wav"));
                } else {
                    Data.messagePanel.paintMessage("那些发狂的南瓜————到底是谁的恶作剧啊啊啊————！");
                    return String.valueOf(Pet.class.getResource("/file/cue/主界面3 夜巡的魔女.wav"));
                }
        }

        return null;
    }
}
