package com.service;

import com.pojo.ShowFolders;
import com.pojo.TbFolder;
import com.utils.ResponseResult;

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
    String addFolder(TbFolder folder);

    /**
     * 根据用户id查询文件夹
     * @param userId
     * @param folder_father
     * @return
     */
    ShowFolders findFolders(Long userId,Long folder_father);

    /**
     * 根据文件夹对象修改文件夹
     * @param folder
     * @return
     */
    String updateFolder(TbFolder folder);


}
