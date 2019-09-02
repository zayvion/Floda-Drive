package com.service.impl;

import com.mapper.TbUserFileMapper;
import com.pojo.*;
import com.service.SystemFileService;
import com.service.UserFileService;
import com.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public List<ShowPictures> findAllPic(Long user_id) {
        List<ShowPictures> pics = new ArrayList<>();
        //根据时间分组
        List<String> picDate = userFileMapper.getPicDate(user_id);
        for (String date:picDate) {
            List<FolderAndFile> folderAndFiles = new ArrayList<>();
            ShowPictures showPictures = new ShowPictures();
            showPictures.setDate(date);
            //根据时间查询当前时间下的图片
            TbUserFileExample tbUserFileExample = new TbUserFileExample();
            TbUserFileExample.Criteria criteria = tbUserFileExample.createCriteria();
            criteria.andBelongUserEqualTo(user_id);
            criteria.andFileTypeEqualTo("1");
            criteria.andIsdelEqualTo((short)0);
            try {
                //一天的开始时间
                String begin = date+" 00:00:00";
                //一天的结束时间
                String end = date+" 24:00:00";
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                criteria.andUploadTimeBetween(format.parse(begin),format.parse(end));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            List<TbUserFile> tbUserFiles = userFileMapper.selectByExample(tbUserFileExample);
            for (TbUserFile tbUserFile : tbUserFiles) {
                FolderAndFile folderAndFile = new FolderAndFile();
                folderAndFile.setId(tbUserFile.getUserfileId());
                folderAndFile.setFileName(tbUserFile.getUserFileName());
                folderAndFile.setBelong(tbUserFile.getBelongUser());
                folderAndFile.setFileSize(tbUserFile.getFileSize());
                folderAndFile.setFileType(tbUserFile.getFileType());
                folderAndFile.setUpdatetime(tbUserFile.getUploadTime());
                folderAndFile.setUserSysfileId(tbUserFile.getUserSysfileId());
                folderAndFile.setIsdel(tbUserFile.getIsdel());
                TbSystemFile systemFile = systemFileService.getSystemFile(tbUserFile.getUserSysfileId());
                folderAndFile.setFile_url(systemFile.getFileUrl());
                folderAndFile.setSrc(systemFile.getFileUrl());
                folderAndFile.setTitle(tbUserFile.getUserFileName());
                folderAndFile.setDescription("大小："+tbUserFile.getFileSize()+" 日期："+tbUserFile.getUploadTime());
                folderAndFiles.add(folderAndFile);
            }
            showPictures.setFolderAndFiles(folderAndFiles);
            pics.add(showPictures);
        }
        return pics;
    }

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

