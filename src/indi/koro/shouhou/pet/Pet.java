package indi.koro.shouhou.pet;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;

public class Pet {
    @JSONField(name = "name", ordinal = 1)
    protected String petName = null;
    @JSONField(name = "file", ordinal = 2)
    protected String JSONFileString = null;
    @JSONField(name = "skinsname", ordinal = 3)
    protected ArrayList<String> skinName;
    @JSONField(name = "skinfilename", ordinal = 4)
    protected ArrayList<String> skinFileMame;
    @JSONField(name = "specialTouch", ordinal = 5)
    protected int[] specialTouch;
    @JSONField(name = "hear", ordinal = 6)
    protected int[] hear;
    @JSONField(name = "touchtext", ordinal = 7)
    protected ArrayList<String> text;


    public void setHear(int[] hear) {
        this.hear = hear;
    }

    public void setJSONFileString(String JSONFileString) {
        this.JSONFileString = JSONFileString;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public void setSkinFileMame(ArrayList<String> skinFileMame) {
        this.skinFileMame = skinFileMame;
    }

    public void setSkinName(ArrayList<String> skinName) {
        this.skinName = skinName;
    }

    public void setSpecialTouch(int[] specialTouch) {
        this.specialTouch = specialTouch;
    }

    public ArrayList<String> getSkinFileMame() {
        return skinFileMame;
    }

    public ArrayList<String> getSkinName() {
        return skinName;
    }

    public int[] getHear() {
        return hear;
    }

    public int[] getSpecialTouch() {
        return specialTouch;
    }

    public String getJSONFileString() {
        return JSONFileString;
    }

    public String getPetName() {
        return petName;
    }
}
