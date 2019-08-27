package com.service.impl;

import com.mapper.TbFolderMapper;
import com.pojo.ShowFolders;
import com.pojo.TbFolder;
import com.pojo.TbFolderExample;
import com.service.FolderService;
import com.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.PrinterURI;
import java.util.Date;
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
    public String addFolder(TbFolder folder) {
        try {
            folderMapper.insertSelective(folder);
            return ResponseResult.build(200,"创建成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseResult.build(500,"创建失败");
    }

    @Override
    public ShowFolders findFolders(Long userId,Long folder_father) {
        TbFolderExample folderExample = new TbFolderExample();
        TbFolderExample.Criteria criteria = folderExample.createCriteria();
        criteria.andFolderUserEqualTo(userId);
        criteria.andFolderFatherEqualTo(folder_father);
        List<TbFolder> tbFolders = folderMapper.selectByExample(folderExample);
        ShowFolders showFolders = new ShowFolders();
        showFolders.setData(tbFolders);
        return showFolders;
    }

    @Override
    public String updateFolder(TbFolder folder) {
        try {
            folder.setFolderCreatetime(new Date());
            folderMapper.updateByPrimaryKey(folder);
            return ResponseResult.build(200,"修改成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseResult.build(500,"修改失败");
    }
}
