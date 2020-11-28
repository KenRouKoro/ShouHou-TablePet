package indi.koro.shouhou.pet;

import com.alibaba.fastjson.JSON;
import indi.koro.shouhou.scene.main.MainScene;
import indi.korostudio.ksge.data.Data;
import indi.korostudio.ksge.tool.MusicPlayer;

public class PetSystem {
    static public Pet nowPet;
    protected MainScene mainScene = null;
    protected MusicPlayer cuePlayer;
    protected static PetSystem petSystem = new PetSystem();

    public void touch(double x, double y) {
        cuePlayer.setURI(Data.getRes("/file/cue/普通触摸 未改造.wav"));
        cuePlayer.play();
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
