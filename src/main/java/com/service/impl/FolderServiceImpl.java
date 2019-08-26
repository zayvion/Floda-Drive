package com.service.impl;

import com.mapper.TbFolderMapper;
import com.pojo.TbFolder;
import com.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.PrinterURI;

/**
 * @Auther: zayvion
 * @Date: 2019-08-26 16:06
 * @Description:文件夹services接口实现类
 */
@Service
public class FolderServiceImpl implements FolderService {
    @Autowired
    private TbFolderMapper folderMapper;

    @Override
    public void addFolder(TbFolder folder) {
        folderMapper.insertSelective(folder);

    }
}
