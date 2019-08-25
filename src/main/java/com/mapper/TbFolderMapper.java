package com.mapper;

import com.pojo.TbFolder;
import com.pojo.TbFolderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFolderMapper {
    int countByExample(TbFolderExample example);

    int deleteByExample(TbFolderExample example);

    int deleteByPrimaryKey(Long folderId);

    int insert(TbFolder record);

    int insertSelective(TbFolder record);

    List<TbFolder> selectByExample(TbFolderExample example);

    TbFolder selectByPrimaryKey(Long folderId);

    int updateByExampleSelective(@Param("record") TbFolder record, @Param("example") TbFolderExample example);

    int updateByExample(@Param("record") TbFolder record, @Param("example") TbFolderExample example);

    int updateByPrimaryKeySelective(TbFolder record);

    int updateByPrimaryKey(TbFolder record);
}