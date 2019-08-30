package com.mapper;

import com.pojo.TbShareItem;
import com.pojo.TbShareItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbShareItemMapper {
    int countByExample(TbShareItemExample example);

    int deleteByExample(TbShareItemExample example);

    int deleteByPrimaryKey(Long shareItemId);

    int insert(TbShareItem record);

    int insertSelective(TbShareItem record);

    List<TbShareItem> selectByExample(TbShareItemExample example);

    TbShareItem selectByPrimaryKey(Long shareItemId);

    int updateByExampleSelective(@Param("record") TbShareItem record, @Param("example") TbShareItemExample example);

    int updateByExample(@Param("record") TbShareItem record, @Param("example") TbShareItemExample example);

    int updateByPrimaryKeySelective(TbShareItem record);

    int updateByPrimaryKey(TbShareItem record);
}