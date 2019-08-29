package com.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: dc
 * @Date: 2019/8/27 15:50
 * @Description:文件夹文件抽取公共类
 */
public class FolderAndFile {

    private Long id;
    private String fileName;
    private Long belong;
    private Long parentId;
    private Date updatetime;
    private BigDecimal fileSize;
    private String fileType;
    private Long userSysfileId;
    private String file_url;

    //封装图片预览所需参数
    private String title;
    private String description;
    private String src;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getBelong() {
        return belong;
    }

    public void setBelong(Long belong) {
        this.belong = belong;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public BigDecimal getFileSize() {
        return fileSize;
    }

    public void setFileSize(BigDecimal fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Long getUserSysfileId() {
        return userSysfileId;
    }

    public void setUserSysfileId(Long userSysfileId) {
        this.userSysfileId = userSysfileId;
    }

    public String getFile_url() {
        return file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @Override
    public String toString() {
        return "FolderAndFile{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", belong=" + belong +
                ", parentId=" + parentId +
                ", updatetime=" + updatetime +
                ", fileSize=" + fileSize +
                ", fileType='" + fileType + '\'' +
                ", userSysfileId=" + userSysfileId +
                ", file_url='" + file_url + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", src='" + src + '\'' +
                '}';
    }
}
