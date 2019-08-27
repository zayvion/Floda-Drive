package com.service.impl;

import com.mapper.TbSystemFileMapper;
import com.pojo.TbSystemFile;
import com.pojo.TbSystemFileExample;
import com.service.SystemFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Auther: zayvion
 * @Date: 2019-08-27 08:52
 * @Description:网盘底层文件的service接口实现类
 */
@Service
public class SystemFileServiceImpl implements SystemFileService {
    @Autowired
    private TbSystemFileMapper systemFileMappermapper;

    @Override
    public long addFile(TbSystemFile systemFile) {
        systemFile.setUploadTime(new Date());
        int i = systemFileMappermapper.insertSelective(systemFile);
        return i;
    }

    @Override
    public List useMd5ToCompareFile(String md5) {
        TbSystemFileExample systemFileExample = new TbSystemFileExample();
        TbSystemFileExample.Criteria systemFileExampleCriteria = systemFileExample.createCriteria();
        systemFileExampleCriteria.andFileMd5EqualTo(md5);
        List<TbSystemFile> files = systemFileMappermapper.selectByExample(systemFileExample);
        if (files != null) {
            return files;
        }
        return null;
    }

    @Override
    public TbSystemFile getSystemFile(long id) {
        return systemFileMappermapper.selectByPrimaryKey(id);
    }
}
