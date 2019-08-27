package com.service.impl;

import com.mapper.TbUserFileMapper;
import com.pojo.TbUserFile;
import com.pojo.TbUserFileExample;
import com.service.UserFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Auther: zayvion
 * @Date: 2019-08-27 15:05
 * @Description:用户文件service接口实现类
 */
@Service
public class UserFileServiceImpl implements UserFileService {

    @Autowired
    private TbUserFileMapper userFileMapper;

    @Override
    public void addFile(TbUserFile userFile) {
        userFile.setUploadTime(new Date());
        userFileMapper.insertSelective(userFile);
    }

    @Override
    public int getSameNameFile(String filename) {
        TbUserFileExample userFileExample = new TbUserFileExample();
        TbUserFileExample.Criteria fileExampleCriteria = userFileExample.createCriteria();
        fileExampleCriteria.andUserFileNameLike(filename);
        int count = userFileMapper.countByExample(userFileExample);
        return count;
    }
}
