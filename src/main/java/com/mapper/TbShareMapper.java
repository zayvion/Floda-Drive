package com.mapper;

import com.pojo.TbShare;
import com.pojo.TbShareExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbShareMapper {
    int countByExample(TbShareExample example);

    int deleteByExample(TbShareExample example);

    int deleteByPrimaryKey(Long shareId);

    int insert(TbShare record);

    int insertSelective(TbShare record);

    List<TbShare> selectByExample(TbShareExample example);

    TbShare selectByPrimaryKey(Long shareId);

    int updateByExampleSelective(@Param("record") TbShare record, @Param("example") TbShareExample example);

    int updateByExample(@Param("record") TbShare record, @Param("example") TbShareExample example);

    int updateByPrimaryKeySelective(TbShare record);

    int updateByPrimaryKey(TbShare record);
}