/**
 * <p>文件名:PetSystem.java</p>
 *
 * @author 16415
 * 创建时间：2019年7月30日 下午2:21:50
 */
package indi.koro.ShouHouTablePet.system;

import indi.koro.ShouHouTablePet.animation.Float;
import indi.koro.ShouHouTablePet.animation.Move;
import indi.koro.ShouHouTablePet.data.Data;
import indi.koro.ShouHouTablePet.listener.AnimationListener;
import indi.koro.ShouHouTablePet.music.MusicPlayer;
import indi.koro.ShouHouTablePet.plugin.Mod;
import indi.koro.ShouHouTablePet.shouhou.Shouhou;
import indi.koro.ShouHouTablePet.window.MainWindow;
import indi.koro.ShouHouTablePet.window.MessagePanel;
import indi.koro.ShouHouTablePet.window.PetPanel;
import indi.koro.ShouHouTablePet.window.ToolPanel;

import java.util.Timer;
import java.util.TimerTask;

/**
 * <p>项目名称：ShouHouTablePet</p>
 * <p>类名称:PetSystem</p>
 * 作者： 16415
 * 版本：1.0
 * 创建时间：2019年7月30日下午2:21:50
 * 类描述:
 */
public class PetSystem {
    /**
     *
     */
    MainWindow mainWindow;
    PetPanel petPanel;
    MusicPlayer musicPlayer = new MusicPlayer();
    MusicPlayer BGMPlayer = new MusicPlayer();
    Pet shouhou;
    ToolPanel toolPanel;
    Move petMove;
    Float petFloat;
    Timer timeMessage;
    protected boolean touch = false;

    public class TimeMessage extends TimerTask {

        @Override
        public void run() {
            待机();
        }
    }

    public PetSystem() {
        // TODO 自动生成的构造函数存根
    }

    public void start() {
        for (Mod mod : Data.mods) {
            mod.start();
        }
        petPanel.reImage();
        mainWindow.show();
        petFloat.start();
        Data.pets.get(Data.nowPet);
        timeMessage.schedule(new TimeMessage(), 60000, 60000);
        登录();
        //Data.pet.setSkin("改造");
    }

    public MusicPlayer getMusicPlayer() {
        return musicPlayer;
    }

    public void 登录() {
        musicPlayer.stop();
        musicPlayer.setURI(Data.pets.get(Data.nowPet).登录());
        musicPlayer.play();
    }

    public void 信息() {

    }

    public void 待机() {
        musicPlayer.stop();
        musicPlayer.setURI(Data.pets.get(Data.nowPet).待机());
        musicPlayer.play();
    }

    public void 触摸(float x, float y) {
        if (!touch) {
            musicPlayer.stop();
            musicPlayer.setURI(Data.pets.get(Data.nowPet).触摸(x, y));
            musicPlayer.play();
            petFloat.pause();
            petMove.start();
        }
    }

    public void modLoad() {
        Data.modLoader = new ModLoader();
        Data.modLoader.modLoad();
        Data.modLoader.petLoad();
    }

    public Float getPetFloat() {
        return petFloat;
    }

    public void changePet(String name) {
        Data.nowPet = name;
        Data.petPanel.reImage();
        登录();
        Data.toolPanel.rePet();

    }

    public void load() {
        modLoad();
        mainWindow = new MainWindow();
        shouhou = new Shouhou();
        MessagePanel messagePanel = new MessagePanel();
        Data.messagePanel = messagePanel;
        Data.petSystem = this;
        Data.mainWindow = mainWindow;
        Data.pets.put("祥凤", shouhou);
        petPanel = new PetPanel();
        petFloat = new Float();
        petMove = new Move();
        petFloat.setComponent(petPanel);
        petFloat.setLoop(true);
        petFloat.setTime(4500);
        petFloat.setMoveX(0);
        petFloat.addAnimationListeners(new AnimationListener() {
            @Override
            public void start() {

            }

            @Override
            public void stop() {

            }

            @Override
            public void pause() {

            }

            @Override
            public void run() {

            }

            @Override
            public void render() {
                petPanel.paintImmediately(petPanel.getVisibleRect());
            }

            @Override
            public void end() {

            }
        });
        petMove.setComponent(petPanel);
        petMove.setRepeat(true);
        petMove.setTime(200);
        petMove.setX(0);
        petMove.setY(-20);
        petMove.addAnimationListeners(new AnimationListener() {
            @Override
            public void start() {
                touch = true;
            }

            @Override
            public void stop() {

            }

            @Override
            public void pause() {

            }

            @Override
            public void run() {

            }

            @Override
            public void render() {
                petPanel.paintImmediately(petPanel.getVisibleRect());
            }

            @Override
            public void end() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    touch = false;
                    petFloat.start();
                }

            }
        });
        Data.petPanel = petPanel;
        mainWindow.add(messagePanel);
        mainWindow.add(petPanel);
        toolPanel = new ToolPanel();
        Data.toolPanel = toolPanel;
        mainWindow.add(toolPanel);
        timeMessage = new Timer();
        for (Pet pet : Data.pets.values()) {
            pet.load();
        }
        this.setOnTop(true);

        for (Mod mod : Data.mods) {
            mod.load();
        }

    }

    public void setOnTop(boolean b) {
        mainWindow.setOnTop(b);
    }

    public void changeSkin(String skin) {
        Data.pets.get(Data.nowPet).setSkin(skin);
        Data.petPanel.reImage();
    }

    public void reSize() {
        Data.mainJWindow.setSize(Data.initialW + Data.initialToolW, Data.initialH);
        Data.mainWindow.setSize(Data.initialW + Data.initialToolW, Data.initialH);
        Data.petPanel.setSize(Data.initialW, Data.initialH);
        Data.toolPanel.setBounds(Data.initialW, 0, Data.initialToolW, Data.initialH);
        Data.pets.get(Data.nowPet).reImage();
        Data.petPanel.reImage();
    }

}
