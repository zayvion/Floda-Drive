package com.service;

import com.pojo.TbSystemFile;

import java.util.List;

/**
 * @Auther: zayvion
 * @Date: 2019-08-27 08:49
 * @Description:网盘底层文件的service
 */
public interface SystemFileService {
    /**
     * 向服务器内上传文件
     * @param systemFile
     */
    long addFile(TbSystemFile systemFile);

    /**
     * 用文件的md5值匹配是否存在相同的文件
     * @param md5
     * @return
     */
    List useMd5ToCompareFile(String md5);

    /**
     * 获取系统内的文件
     * @param id
     * @return
     */
    TbSystemFile getSystemFile(long id);
}
