package com.pojo;

import java.util.Date;

/**
 * @Auther: zayvion
 * @Date: 2019-08-30 12:22
 * @Description:前台分享页面要求的json格式
 */
public class ShowShare {
    private String title;
    private String comment;
    private String shareUrl;
    private Date shareDate;
    private String QRCodeUrl;
    private long shareId;

    public String getTitle() {
        return title;
    }

    public long getShareId() {
        return shareId;
    }

    public void setShareId(long shareId) {
        this.shareId = shareId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public Date getShareDate() {
        return shareDate;
    }

    public void setShareDate(Date shareDate) {
        this.shareDate = shareDate;
    }

    public String getQRCodeUrl() {
        return QRCodeUrl;
    }

    public void setQRCodeUrl(String QRCodeUrl) {
        this.QRCodeUrl = QRCodeUrl;
    }
}


