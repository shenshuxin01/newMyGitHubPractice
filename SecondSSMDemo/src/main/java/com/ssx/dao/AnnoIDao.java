package com.ssx.dao;

import com.ssx.entity.POJOUser;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.FactoryBean;

import java.util.List;

@CacheNamespace(blocking = true)
public interface AnnoIDao {
    @Results(id = "selectAnno",
            value = {
                        @Result(id = true, column = "user_name", property = "name"),
                        @Result(column = "pass_word",property = "password")
                    }
    )

    @Select(value = " select pass_word ,user_name  from user where  user_name= #{funarg} ")
//    @ResultMap(value = "selectAnno")
    List<POJOUser> annoQuery(String funarg);

    @Insert(" insert into user values( #{name},#{password} ) ")
    @ResultMap("selectAnno")//因为方法返回值void 此行没有用
    void annoAdd(POJOUser pojoUser);
}
