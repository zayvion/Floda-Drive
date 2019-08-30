package com.pojo;

import java.util.Date;

public class TbFolder {
    private Long folderId;

    private String folderName;

    private Long folderFather;

    private Long folderUser;

    private Date folderCreatetime;

    private Short isdel;

    public Long getFolderId() {
        return folderId;
    }

    public void setFolderId(Long folderId) {
        this.folderId = folderId;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName == null ? null : folderName.trim();
    }

    public Long getFolderFather() {
        return folderFather;
    }

    public void setFolderFather(Long folderFather) {
        this.folderFather = folderFather;
    }

    public Long getFolderUser() {
        return folderUser;
    }

    public void setFolderUser(Long folderUser) {
        this.folderUser = folderUser;
    }

    public Date getFolderCreatetime() {
        return folderCreatetime;
    }

    public void setFolderCreatetime(Date folderCreatetime) {
        this.folderCreatetime = folderCreatetime;
    }

    public Short getIsdel() {
        return isdel;
    }

    public void setIsdel(Short isdel) {
        this.isdel = isdel;
    }
}