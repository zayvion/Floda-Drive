package com.mapper;

import com.pojo.TbSystemFile;
import com.pojo.TbSystemFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSystemFileMapper {
    int countByExample(TbSystemFileExample example);

    int deleteByExample(TbSystemFileExample example);

    int deleteByPrimaryKey(Long fileId);

    int insert(TbSystemFile record);

    int insertSelective(TbSystemFile record);

    List<TbSystemFile> selectByExample(TbSystemFileExample example);

    TbSystemFile selectByPrimaryKey(Long fileId);

    int updateByExampleSelective(@Param("record") TbSystemFile record, @Param("example") TbSystemFileExample example);

    int updateByExample(@Param("record") TbSystemFile record, @Param("example") TbSystemFileExample example);

    int updateByPrimaryKeySelective(TbSystemFile record);

    int updateByPrimaryKey(TbSystemFile record);
}