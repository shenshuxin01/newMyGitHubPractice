package ssx.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface Idao {

    @Insert(" insert into third_ssm_tab(name) values(#{name}) ")
     void add(String name);

    @Select("select * from third_ssm_tab") //返回的结果集是多行多列
    List<Map<Object ,Object>> queryAll();
}
