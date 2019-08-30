package com.service.impl;

import com.mapper.TbShareItemMapper;
import com.mapper.TbShareMapper;
import com.pojo.*;
import com.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public long addShare(TbShare share) {
        shareMapper.insertSelective(share);
        return share.getShareId();
    }

    @Override
    public void addShareItem(TbShareItem shareItem) {
        shareItemMapper.insertSelective(shareItem);
    }

    @Override
    public List<TbShare> showUserShares(long userId) {
        TbShareExample shareExample = new TbShareExample();
        TbShareExample.Criteria exampleCriteria = shareExample.createCriteria();
        exampleCriteria.andShareUserEqualTo(userId);
        List<TbShare> shares = shareMapper.selectByExample(shareExample);
        return shares;
    }

    @Override
    public void updateUserShare(TbShare share) {
        shareMapper.updateByPrimaryKeySelective(share);
    }

    @Override
    public List<TbShareItem> showShareData(long shareId) {
        TbShareItemExample shareItemExample = new TbShareItemExample();
        TbShareItemExample.Criteria itemExampleCriteria = shareItemExample.createCriteria();
        itemExampleCriteria.andShareIdEqualTo(shareId);
        return shareItemMapper.selectByExample(shareItemExample);
    }
}
