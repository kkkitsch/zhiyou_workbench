package com.zhiyou.mybatis.dao;

import java.util.List;
import java.util.Map;

import com.zhiyou.mybatis.bean.People;

public interface PeopleMapper {

	People selectPeopleById(int id);

	List<People> selectActivePeopleByInfo(String info);

	List<People> selectByMap1(Map<String, Object> map);

	List<People> selectByMap2(Map<String, Object> map);

	List<People> trimByMap(Map<String, Object> map);

	List<People> trimByPeople(People people);

	int updatePeople(People people);

	int deletePeopleById(int id);

	int deletePeopleByList(List<Integer> ids);
}
