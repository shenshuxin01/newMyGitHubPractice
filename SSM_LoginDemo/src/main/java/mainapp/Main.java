package mainapp;

import entity.BooKPOJO;
import mapper.BookMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.BookServiceImpl;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        myBatis_spring();
    }

    static void onlyMybatis() throws Exception{  //此方法 测试 mybatis
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();

        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
//        bookMapper.addBook(new BooKPOJO("noww",0));
        bookMapper.removeAll();
        sqlSession.commit();
    }

    public static void myBatis_spring() throws Exception{
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-dao.xml");
//        Object bean = classPathXmlApplicationContext.getBean("userMapper");
//        BookMapper bookMapper = (BookMapper) bean;
//        bookMapper.addBook(new BooKPOJO("javaBook",999));
        Object bean = classPathXmlApplicationContext.getBean("bookService");
        BookServiceImpl bookService = (BookServiceImpl) bean;
        bookService.addBook(new BooKPOJO("ok",0));


    }
}
