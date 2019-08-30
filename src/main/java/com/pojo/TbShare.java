package com.pojo;

import java.util.Date;

public class TbShare {
    private Long shareId;

    private Long shareUser;

    private String shareComment;

    private String shareTitle;

    private String shareUrl;

    private Date shareDate;

    public Long getShareId() {
        return shareId;
    }

    public void setShareId(Long shareId) {
        this.shareId = shareId;
    }

    public Long getShareUser() {
        return shareUser;
    }

    public void setShareUser(Long shareUser) {
        this.shareUser = shareUser;
    }

    public String getShareComment() {
        return shareComment;
    }

    public void setShareComment(String shareComment) {
        this.shareComment = shareComment == null ? null : shareComment.trim();
    }

    public String getShareTitle() {
        return shareTitle;
    }

    public void setShareTitle(String shareTitle) {
        this.shareTitle = shareTitle == null ? null : shareTitle.trim();
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl == null ? null : shareUrl.trim();
    }

    public Date getShareDate() {
        return shareDate;
    }

    public void setShareDate(Date shareDate) {
        this.shareDate = shareDate;
    }
}