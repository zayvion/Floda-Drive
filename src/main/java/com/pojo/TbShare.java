package com.pojo;

public class TbShare {
    private Long shareId;

    private Long shareFile;

    private Long shareUser;

    private String shareComment;

    private String shareTitle;

    private String shareUrl;

    public Long getShareId() {
        return shareId;
    }

    public void setShareId(Long shareId) {
        this.shareId = shareId;
    }

    public Long getShareFile() {
        return shareFile;
    }

    public void setShareFile(Long shareFile) {
        this.shareFile = shareFile;
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
}