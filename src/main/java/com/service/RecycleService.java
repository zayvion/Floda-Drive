package com.service;

import java.util.List;

/**
 * @Auther: zayvion
 * @Date: 2019-08-31 09:08
 * @Description:回收站service
 */
public interface RecycleService {

    /**
     * 取用户回收站数据
     * @param userId
     * @return
     */
    List getUserRecycleList(long userId);

    /**
     * 删除回收站文件
     * @param fileId
     */
    void remove(long fileId);

    /**
     * 清空回收站
     * @param userId
     */
    void delAllFile(long userId);

}
