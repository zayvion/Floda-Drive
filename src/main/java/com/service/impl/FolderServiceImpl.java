package com.service.impl;

import com.mapper.TbFolderMapper;
import com.mapper.TbUserFileMapper;
import com.pojo.*;
import com.service.FolderService;
import com.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    private TbUserFileMapper userFileMapper;

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
        //查询文件夹
        TbFolderExample folderExample = new TbFolderExample();
        TbFolderExample.Criteria criteria = folderExample.createCriteria();
        criteria.andFolderUserEqualTo(userId);
        criteria.andFolderFatherEqualTo(folder_father);
        //查询文件
        TbUserFileExample userFileExample = new TbUserFileExample();
        TbUserFileExample.Criteria userFileExampleCriteria = userFileExample.createCriteria();
        userFileExampleCriteria.andBelongUserEqualTo(userId);
        userFileExampleCriteria.andFileLocationEqualTo(folder_father);
        List<TbFolder> tbFolders = folderMapper.selectByExample(folderExample);
        List<TbUserFile> tbUserFiles = userFileMapper.selectByExample(userFileExample);
        //填入文件夹
        ShowFolders showFolders = new ShowFolders();
        List<FolderAndFile> ffs = showFolders.getData();
        if (ffs == null){
            ffs = new ArrayList<>();
        }
        for (TbFolder tbFolder:tbFolders) {
            FolderAndFile ff = new FolderAndFile();
            ff.setId(tbFolder.getFolderId());
            ff.setFileName(tbFolder.getFolderName());
            ff.setParentId(tbFolder.getFolderFather());
            ff.setBelong(tbFolder.getFolderUser());
            ff.setFileType("0");
            ffs.add(ff);
        }
        //填入文件
        for (TbUserFile tbUserFile:tbUserFiles) {
            FolderAndFile ff = new FolderAndFile();
            ff.setId(tbUserFile.getUserfileId());
            ff.setFileName(tbUserFile.getUserFileName());
            ff.setFileType(tbUserFile.getFileType());
            ff.setBelong(tbUserFile.getBelongUser());
            ff.setParentId(tbUserFile.getFileLocation());
            ff.setFileSize(tbUserFile.getFileSize());
            ff.setUpdatetime(tbUserFile.getUploadTime());
            ffs.add(ff);
        }
        showFolders.setData(ffs);
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
