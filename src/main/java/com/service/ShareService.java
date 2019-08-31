package com.service;

import com.pojo.ShowShare;
import com.pojo.TbShare;
import com.pojo.TbShareItem;

import java.util.List;

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
    long addShare(TbShare share);



    /**
     * 一次分享下单个文件的添加
     * @param shareItem
     */
    void addShareItem(TbShareItem shareItem);

    /**
     * 展示一个用户的分享
     * @param userId
     * @return
     */
    List<TbShare> showUserShares(long userId);

    /**
     * 更新分享信息
     * @param share
     */
    void updateUserShare(TbShare share);

    /**
     * 获取一次分享的具体文件
     * @param shareId
     * @return
     */
    List<TbShareItem> showShareData(long shareId);

    /**
     * 删除分享
     * @param shareId
     */
    void delShare(long shareId);

}
