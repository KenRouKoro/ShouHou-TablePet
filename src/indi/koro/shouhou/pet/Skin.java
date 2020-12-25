package indi.koro.shouhou.pet;

import com.alibaba.fastjson.annotation.JSONField;

public class Skin {
    @JSONField(name = "name")
    protected String name = null;
    @JSONField(name = "specialTouch")
    protected int[] specialTouch;
    @JSONField(name = "main1")
    protected String main1;
    @JSONField(name = "main2")
    protected String main2;
    @JSONField(name = "main3")
    protected String main3;
    @JSONField(name = "missionac")
    protected String missionac;
    @JSONField(name = "missionrm")
    protected String missionrm;
    @JSONField(name = "friendly")
    protected String friendly;
    @JSONField(name = "like")
    protected String like;
    @JSONField(name = "disappointment")
    protected String disappointment;
    @JSONField(name = "love")
    protected String love;
    @JSONField(name = "fail")
    protected String fail;
    @JSONField(name = "commissioned")
    protected String commissioned;
    @JSONField(name = "strengthen")
    protected String strengthen;
    @JSONField(name = "skill")
    protected String skill;
    @JSONField(name = "flagship")
    protected String flagship;
    @JSONField(name = "touch")
    protected String touch;
    @JSONField(name = "special")
    protected String special;
    @JSONField(name = "info")
    protected String info;
    @JSONField(name = "signin")
    protected String signin;
    @JSONField(name = "victory")
    protected String victory;
    @JSONField(name = "get")
    protected String get;
    @JSONField(name = "low")
    protected String low;
    @JSONField(name = "wedding")
    protected String wedding;
    @JSONField(name = "mail")
    protected String mail;
    @JSONField(name = "strange")
    protected String strange;

    public int[] getSpecialTouch() {
        return specialTouch;
    }

    public String getName() {
        return name;
    }

    public String getDisappointment() {
        return disappointment;
    }

    public String getCommissioned() {
        return commissioned;
    }

    public String getFail() {
        return fail;
    }

    public String getFlagship() {
        return flagship;
    }

    public String getFriendly() {
        return friendly;
    }

    public String getInfo() {
        return info;
    }

    public String getGet() {
        return get;
    }

    public String getLike() {
        return like;
    }

    public String getLove() {
        return love;
    }

    public String getMain1() {
        return main1;
    }

    public String getLow() {
        return low;
    }

    public String getMain2() {
        return main2;
    }

    public String getMail() {
        return mail;
    }

    public String getMain3() {
        return main3;
    }

    public String getMissionac() {
        return missionac;
    }

    public String getMissionrm() {
        return missionrm;
    }

    public String getSkill() {
        return skill;
    }

    public String getSignin() {
        return signin;
    }

    public String getSpecial() {
        return special;
    }

    public String getStrengthen() {
        return strengthen;
    }

    public String getTouch() {
        return touch;
    }

    public String getStrange() {
        return strange;
    }

    public String getVictory() {
        return victory;
    }

    public String getWedding() {
        return wedding;
    }

    public void setSpecialTouch(int[] specialTouch) {
        this.specialTouch = specialTouch;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCommissioned(String commissioned) {
        this.commissioned = commissioned;
    }

    public void setDisappointment(String disappointment) {
        this.disappointment = disappointment;
    }

    public void setFriendly(String friendly) {
        this.friendly = friendly;
    }

    public void setFail(String fail) {
        this.fail = fail;
    }

    public void setFlagship(String flagship) {
        this.flagship = flagship;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public void setMain1(String main1) {
        this.main1 = main1;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setLove(String love) {
        this.love = love;
    }

    public void setMain2(String main2) {
        this.main2 = main2;
    }

    public void setGet(String get) {
        this.get = get;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setMain3(String main3) {
        this.main3 = main3;
    }

    public void setMissionac(String missionac) {
        this.missionac = missionac;
    }

    public void setMissionrm(String missionrm) {
        this.missionrm = missionrm;
    }

    public void setSignin(String signin) {
        this.signin = signin;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public void setStrange(String strange) {
        this.strange = strange;
    }

    public void setStrengthen(String strengthen) {
        this.strengthen = strengthen;
    }

    public void setTouch(String touch) {
        this.touch = touch;
    }

    public void setVictory(String victory) {
        this.victory = victory;
    }

    public void setWedding(String wedding) {
        this.wedding = wedding;
    }

}
