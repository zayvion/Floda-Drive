package com.service.impl;

import com.mapper.TbFolderMapper;
import com.pojo.ShowFolders;
import com.pojo.TbFolder;
import com.pojo.TbFolderExample;
import com.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.PrinterURI;
import java.util.List;

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

    @Override
    public ShowFolders findFolders(int UserId) {
        TbFolderExample folderExample = new TbFolderExample();
        List<TbFolder> tbFolders = folderMapper.selectByExample(folderExample);
        for (TbFolder f:tbFolders
             ) {
            f.setFolderName("<i class='fa fa-folder' style='font-size:18px;color:rgb(255,214,89);margin:8px 5px 0 0'></i>"+f.getFolderName());
        }
        ShowFolders showFolders = new ShowFolders();
        showFolders.setData(tbFolders);
        return showFolders;
    }
}
