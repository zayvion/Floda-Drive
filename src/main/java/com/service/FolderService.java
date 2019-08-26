package com.service;

import com.pojo.ShowFolders;
import com.pojo.TbFolder;

import java.util.List;

/**
 * @Auther: zayvion
 * @Date: 2019-08-26 16:05
 * @Description：文件夹service
 */
public interface FolderService {
    /**
     * 添加文件夹
     * @param folder
     */
    void addFolder(TbFolder folder);

    /**
     * 根据用户id查询文件夹
     * @param UserId
     * @return
     */
    ShowFolders findFolders(int UserId);
}
