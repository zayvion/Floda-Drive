package com.pojo;

import java.util.List;

/**
 * @Auther: dc
 * @Date: 2019/8/31 09:38
 * @Description:
 */
public class ShowPictures {
    private String date;
    private List<FolderAndFile> folderAndFiles;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<FolderAndFile> getFolderAndFiles() {
        return folderAndFiles;
    }

    public void setFolderAndFiles(List<FolderAndFile> folderAndFiles) {
        this.folderAndFiles = folderAndFiles;
    }

    @Override
    public String toString() {
        return "ShowPictures{" +
                "date='" + date + '\'' +
                ", folderAndFiles=" + folderAndFiles +
                '}';
    }
}
