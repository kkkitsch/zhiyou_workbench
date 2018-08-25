package com.zhiyou.mybatis.dao;

import com.zhiyou.mybatis.bean.People;
import com.zhiyou.mybatis.bean.PeopleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeopleMapper {
    int countByExample(PeopleExample example);

    int deleteByExample(PeopleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(People record);

    int insertSelective(People record);

    List<People> selectByExample(PeopleExample example);

    People selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") People record, @Param("example") PeopleExample example);

    int updateByExample(@Param("record") People record, @Param("example") PeopleExample example);

    int updateByPrimaryKeySelective(People record);

    int updateByPrimaryKey(People record);
}