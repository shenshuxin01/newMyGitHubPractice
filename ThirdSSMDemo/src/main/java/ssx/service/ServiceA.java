package ssx.service;

import org.springframework.beans.factory.annotation.Autowired;
import ssx.dao.Idao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@org.springframework.stereotype.Service
public class ServiceA {

    @Autowired
    Idao idao;

    public List<Map<Object, Object>> serviceFun(String string){

        idao.add(string);
        return idao.queryAll();

    }
}
