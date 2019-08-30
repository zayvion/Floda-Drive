package com.service.impl;

import com.mapper.TbUserFileMapper;
import com.pojo.FolderAndFile;
import com.pojo.TbSystemFile;
import com.pojo.TbUserFile;
import com.pojo.TbUserFileExample;
import com.service.SystemFileService;
import com.service.UserFileService;
import com.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    private SystemFileService systemFileService;

    @Override
    public void addFile(TbUserFile userFile) {
        userFile.setUploadTime(new Date());
        userFileMapper.insertSelective(userFile);
    }

    @Override
    public int getSameNameFile(String filename, long userId, long fatherFloder) {
        TbUserFileExample userFileExample = new TbUserFileExample();
        TbUserFileExample.Criteria fileExampleCriteria = userFileExample.createCriteria();
        fileExampleCriteria.andUserFileNameLike(filename);
        fileExampleCriteria.andBelongUserEqualTo(userId);
        fileExampleCriteria.andFileLocationEqualTo(fatherFloder);
        int count = userFileMapper.countByExample(userFileExample);
        return count;
    }


    @Override
    public List getUserFileWithType(long userId, String type) {
        TbUserFileExample userFileExample = new TbUserFileExample();
        TbUserFileExample.Criteria fileExampleCriteria = userFileExample.createCriteria();
        fileExampleCriteria.andFileTypeEqualTo(type);
        fileExampleCriteria.andBelongUserEqualTo(userId);
        fileExampleCriteria.andIsdelEqualTo((short)0);
        List<TbUserFile> fileList = userFileMapper.selectByExample(userFileExample);
        ArrayList<FolderAndFile> files = new ArrayList<>();
        for (TbUserFile tbUserFile : fileList) {
            FolderAndFile folderAndFile = new FolderAndFile();
            folderAndFile.setFileName(tbUserFile.getUserFileName());
            folderAndFile.setBelong(tbUserFile.getBelongUser());
            folderAndFile.setFileSize(tbUserFile.getFileSize());
            folderAndFile.setFileType(tbUserFile.getFileType());
            folderAndFile.setUpdatetime(tbUserFile.getUploadTime());
            folderAndFile.setUserSysfileId(tbUserFile.getUserfileId());
            TbSystemFile systemFile = systemFileService.getSystemFile(tbUserFile.getUserSysfileId());
            folderAndFile.setFile_url(systemFile.getFileUrl());
            files.add(folderAndFile);
        }
        return files;
    }

    @Override
    public TbUserFile getUserFile(long userFileId) {
        return userFileMapper.selectByPrimaryKey(userFileId);
    }

    @Override
    public List getFolderFiles(long folderId) {
        TbUserFileExample userFileExample = new TbUserFileExample();
        TbUserFileExample.Criteria criteria = userFileExample.createCriteria();
        criteria.andFileLocationEqualTo(folderId);
        List<TbUserFile> userFiles = userFileMapper.selectByExample(userFileExample);
        return userFiles;
    }

    @Override
    public String updateUserFile(TbUserFile userFile) {
        try {
            userFile.setUploadTime(new Date());
            userFileMapper.updateByPrimaryKey(userFile);
            return ResponseResult.build(200, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseResult.build(500, "修改失败");
    }

    @Override
    public void deleteUserFile(FolderAndFile ff) {
        //删除文件时，要删除该文件所在的用户表（预留功能：以及该文件在系统表中对应的数据）
        TbUserFile tbUserFile = new TbUserFile();
        tbUserFile.setUserSysfileId(ff.getUserSysfileId());
        tbUserFile.setUserFileName(ff.getFileName());
        tbUserFile.setUserfileId(ff.getId());
        tbUserFile.setUploadTime(ff.getUpdatetime());
        tbUserFile.setFileType(ff.getFileType());
        tbUserFile.setFileSize(ff.getFileSize());
        tbUserFile.setFileLocation(ff.getParentId());
        tbUserFile.setBelongUser(ff.getBelong());
        tbUserFile.setIsdel((short)1);
        userFileMapper.updateByPrimaryKey(tbUserFile);
    }
}

