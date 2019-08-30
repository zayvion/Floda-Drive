package com.service;

import com.pojo.TbShare;
import com.pojo.TbShareItem;

/**
 * @Auther: zayvion
 * @Date: 2019-08-30 10:39
 * @Description:文件分享service
 */
public interface ShareService {

    /**
     * 添加分享
     * @param share
     */
    void addShare(TbShare share);

    /**
     * 一次分享下单个文件的添加
     * @param shareItem
     */
    void addShareItem(TbShareItem shareItem);

}
