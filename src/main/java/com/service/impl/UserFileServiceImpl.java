package com.service.impl;

import com.mapper.TbUserFileMapper;
import com.pojo.TbUserFile;
import com.pojo.TbUserFileExample;
import com.service.UserFileService;
import com.utils.ResponseResult;
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

    @Override
    public String updateUserFile(TbUserFile userFile) {
        try {
            userFile.setUploadTime(new Date());
            userFileMapper.updateByPrimaryKey(userFile);
            return ResponseResult.build(200,"修改成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseResult.build(500,"修改失败");
    }
}
