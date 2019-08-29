package com.service;

import com.mapper.TbUserFileMapper;
import com.pojo.TbUserFile;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Auther: zayvion
 * @Date: 2019-08-27 15:03
 * @Description:用户文件service
 */
public interface UserFileService {

    /**
     * 用户上传新文件
     *
     * @param userFile
     */
    void addFile(TbUserFile userFile);

    /**
     * 获取相同文件名的文件
     *
     * @param filename
     * @return
     */
    int getSameNameFile(String filename, long userId, long fatherFloder);

    /**
     * 重命名文件
     *
     * @param userFile
     */
    String updateUserFile(TbUserFile userFile);

    /**
     * 根据类型返回相关的文件
     *
     * @param userId
     * @param type   类型
     * @return list
     */
    List getUserFileWithType(long userId, String type);

    /**
     * 获取一个用户文件
     *
     * @param userFileId
     * @return
     */
    TbUserFile getUserFile(long userFileId);


}
