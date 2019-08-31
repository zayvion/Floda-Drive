package com.service.impl;

import com.mapper.TbUserFileMapper;
import com.pojo.TbUserFileExample;
import com.service.RecycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: zayvion
 * @Date: 2019-08-31 09:28
 * @Description:回收站service的接口实现类
 */
@Service
public class RecycleServiceImpl implements RecycleService {
    @Autowired
    private TbUserFileMapper userFileMapper;

    @Override
    public List getUserRecycleList(long userId) {
        TbUserFileExample userFileExample = new TbUserFileExample();
        TbUserFileExample.Criteria fileExampleCriteria = userFileExample.createCriteria();
        fileExampleCriteria.andIsdelEqualTo((short) 1);
        fileExampleCriteria.andBelongUserEqualTo(userId);
        return userFileMapper.selectByExample(userFileExample);

    }

    @Override
    public void remove(long fileId) {
        userFileMapper.deleteByPrimaryKey(fileId);
    }

    @Override
    public void delAllFile(long userId) {
        TbUserFileExample userFileExample = new TbUserFileExample();
        TbUserFileExample.Criteria fileExampleCriteria = userFileExample.createCriteria();
        fileExampleCriteria.andIsdelEqualTo((short) 1);
        fileExampleCriteria.andBelongUserEqualTo(userId);
        userFileMapper.deleteByExample(userFileExample);
    }
}
