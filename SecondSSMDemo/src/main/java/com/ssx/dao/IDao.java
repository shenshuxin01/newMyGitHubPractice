package com.ssx.dao;

/**
 * 这个是采用xml文件开发的
 */

import com.ssx.entity.POJOUser;

import java.util.List;

public interface IDao {
    public void add(POJOUser pojoUser);
    public List<POJOUser> query( );
    void truncateTab();
}
