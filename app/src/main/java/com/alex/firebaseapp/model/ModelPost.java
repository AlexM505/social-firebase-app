package com.alex.firebaseapp.model;

public class ModelPost {

    String pId, pTitle, pDescr, pImage, pTimer, uid, uEmail, uDp, uName;

    public ModelPost() {
    }

    public ModelPost(String pId, String pTitle, String pDescr, String pImage, String pTimer, String uid, String uEmail, String uDp, String uName) {
        this.pId = pId;
        this.pTitle = pTitle;
        this.pDescr = pDescr;
        this.pImage = pImage;
        this.pTimer = pTimer;
        this.uid = uid;
        this.uEmail = uEmail;
        this.uDp = uDp;
        this.uName = uName;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getpTitle() {
        return pTitle;
    }

    public void setpTitle(String pTitle) {
        this.pTitle = pTitle;
    }

    public String getpDescr() {
        return pDescr;
    }

    public void setpDescr(String pDescr) {
        this.pDescr = pDescr;
    }

    public String getpImage() {
        return pImage;
    }

    public void setpImage(String pImage) {
        this.pImage = pImage;
    }

    public String getpTimer() {
        return pTimer;
    }

    public void setpTimer(String pTimer) {
        this.pTimer = pTimer;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuDp() {
        return uDp;
    }

    public void setuDp(String uDp) {
        this.uDp = uDp;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }
}
