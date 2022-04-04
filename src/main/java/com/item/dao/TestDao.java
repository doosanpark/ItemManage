package com.item.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
 
@Repository
public class TestDao {
 
    private static final String NAME_SPACE = "com.item.dao.TestDao";
 
    @Autowired
    @Qualifier(value = "bootdb1SqlSession")
    private SqlSession bootdb1SqlSession;
 
    @Autowired
    @Qualifier(value = "bootdb2SqlSession")
    private SqlSession bootdb2SqlSession;
 
    public String selectbootdb1DBName() {
        return bootdb1SqlSession.selectOne(NAME_SPACE + ".selectBootdb1Name");
    }
 
    public String selectbootdb2DBName() {
        return bootdb2SqlSession.selectOne(NAME_SPACE + ".selectBootdb2Name");
    }
}