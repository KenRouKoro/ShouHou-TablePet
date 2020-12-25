package indi.koro.shouhou.pet;

import com.alibaba.fastjson.JSON;
import indi.koro.shouhou.component.TextPanel;
import indi.koro.shouhou.scene.main.MainScene;
import indi.korostudio.ksge.data.Data;
import indi.korostudio.ksge.tool.MusicPlayer;

public class PetSystem {
    static public Pet nowPet;
    protected MainScene mainScene = null;
    protected MusicPlayer cuePlayer;
    protected static PetSystem petSystem = new PetSystem();
    protected TextPanel textPanel;
    protected String nowTouchPlaying = "/file/cue/普通触摸 未改造.wav";
    protected String nowTouchText = "虽然吾不在乎，但是最好别对其他人也这样！";

    public void setTextPanel(TextPanel textPanel) {
        this.textPanel = textPanel;
    }

    public boolean touch(double x, double y) {
        if (cuePlayer.isPlaying()) return false;
        textPanel.showThis(nowTouchText);
        cuePlayer.setURI(Data.getRes(nowTouchPlaying));
        cuePlayer.setStopCallBacks(() -> {
            textPanel.end();
            cuePlayer.removeALLStopCallBacls();
        });
        cuePlayer.play();
        return true;
    }

    public static PetSystem getPetSystem() {
        return petSystem;
    }

    private PetSystem() {
        cuePlayer = new MusicPlayer();
    }

    public void setPet(Pet pet) {
        if (pet == nowPet | pet == null) return;
        if (mainScene == null) mainScene = (MainScene) Data.sceneMap.get("main");
        mainScene.changePet(pet);
        nowPet = pet;

    }

    public static String getJSON(Pet pet) {
        if (pet == null) return null;
        return JSON.toJSONString(pet);
    }

    public static Pet getJSONObject(String json) {
        if (json == null) return null;
        return JSON.parseObject(json, Pet.class);
    }
}
