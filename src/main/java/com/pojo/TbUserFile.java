package com.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class TbUserFile {
    private Long userfileId;

    private Long userSysfileId;

    private String userFileName;

    private Long belongUser;

    private String fileType;

    private BigDecimal fileSize;

    private Long fileLocation;

    private Date uploadTime;

    public Long getUserfileId() {
        return userfileId;
    }

    public void setUserfileId(Long userfileId) {
        this.userfileId = userfileId;
    }

    public Long getUserSysfileId() {
        return userSysfileId;
    }

    public void setUserSysfileId(Long userSysfileId) {
        this.userSysfileId = userSysfileId;
    }

    public String getUserFileName() {
        return userFileName;
    }

    public void setUserFileName(String userFileName) {
        this.userFileName = userFileName == null ? null : userFileName.trim();
    }

    public Long getBelongUser() {
        return belongUser;
    }

    public void setBelongUser(Long belongUser) {
        this.belongUser = belongUser;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    public BigDecimal getFileSize() {
        return fileSize;
    }

    public void setFileSize(BigDecimal fileSize) {
        this.fileSize = fileSize;
    }

    public Long getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(Long fileLocation) {
        this.fileLocation = fileLocation;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }
}