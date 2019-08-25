package com.pojo;

public class TbFolder {
    private Long folderId;

    private String folderName;

    private Long folderFather;

    private Long folderUser;

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
}