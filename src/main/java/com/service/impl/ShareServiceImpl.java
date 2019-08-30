package com.service.impl;

import com.mapper.TbShareItemMapper;
import com.mapper.TbShareMapper;
import com.pojo.TbShare;
import com.pojo.TbShareItem;
import com.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: zayvion
 * @Date: 2019-08-30 10:42
 * @Description:分享service接口实现类
 */
@Service
public class ShareServiceImpl  implements ShareService {

    @Autowired
    private TbShareMapper shareMapper;
    @Autowired
    private TbShareItemMapper shareItemMapper;

    @Override
    public void addShare(TbShare share) {
        shareMapper.insertSelective(share);
    }

    @Override
    public void addShareItem(TbShareItem shareItem) {
        shareItemMapper.insertSelective(shareItem);
    }
}
