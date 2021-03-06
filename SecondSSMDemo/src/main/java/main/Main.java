package main;

import com.ssx.dao.AnnoIDao;
import com.ssx.dao.IDao;
import com.ssx.entity.POJOUser;
import com.ssx.spring2.AppConfig;
import com.ssx.spring2.ioc.Boy;
import com.ssx.spring2.ioc.Girl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception{
//        funAnnoMybatis();
//        funSpring2();
//        funMybatis();
        funSpringMybatis();
    }

    //这是spring+mybatis整合
    private static void funSpringMybatis() throws Exception{
        ClassPathXmlApplicationContext in = new ClassPathXmlApplicationContext("spring+mybatis-config.xml");
        AnnoIDao mapperAnnoIDao = in.getBean("mapperAnnoIDao", AnnoIDao.class);
        List<POJOUser> pojoUsers = mapperAnnoIDao.annoQuery("zx");
        pojoUsers.forEach(pojoUser -> System.out.println(pojoUser));

    }

    //这是mybatis-xml开发
    public static void funMybatis( ) throws IOException {
        //1、读取主配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        //2、创建SqlSessionFactory
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);

        //3、创建SqlSession对象
        SqlSession sqlSession = factory.openSession();

        // 也可以传入true参数，表示自动提交
        // SqlSession sqlSession = factory.openSession(true);

        //4、使用SqlSession创建Dao接口的代理对象
        IDao mapper = sqlSession.getMapper(IDao.class);

        // 5、使用代理对象执行方法
        mapper.truncateTab();
        mapper.add(new POJOUser("shenshuxin98","1234567"));

        List<POJOUser> query = mapper.query( );
        query.forEach(pojoUser -> System.out.println(pojoUser));

        //6、关闭资源
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    //这是mybatis-注解开发
    public static void funAnnoMybatis( ) throws IOException {
        //1、读取主配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        //2、创建SqlSessionFactory
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);

        //3、创建SqlSession对象
        SqlSession sqlSession = factory.openSession();
        SqlSession sqlSession2 = factory.openSession();
        // 也可以传入true参数，表示自动提交
        // SqlSession sqlSession = factory.openSession(true);

        //4、使用SqlSession创建Dao接口的代理对象
        AnnoIDao mapper = sqlSession.getMapper(AnnoIDao.class);
        AnnoIDao mapper2 = sqlSession2.getMapper(AnnoIDao.class);


        // 5、使用代理对象执行方法
        mapper.annoAdd(new POJOUser("shenshuxin98","123456765"));
        for (int i = 0; i < 1; i++) {
            List<POJOUser> query = mapper.annoQuery("shenshuxin98");
            query.forEach(pojoUser -> System.out.println(pojoUser));
            sqlSession.commit();

            try{
                 Thread.sleep(10000);
            }catch (Exception e){

            }

            List<POJOUser> query2 = mapper2.annoQuery("shenshuxin98");
            query2.forEach(pojoUser -> System.out.println(pojoUser));

        }



        //6、关闭资源
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    //这是spring特点 ioc+aop
    public static void funSpring2(){
        Logger logger = Logger.getLogger(Main.class);
        logger.info("使用注解类配置，不采用xml文件");
//        ClassPathXmlApplicationContext xml = new ClassPathXmlApplicationContext("spring-ioc-config.xml");
        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(AppConfig.class);
        Boy boy = acac.getBean("boy", Boy.class);
        boy.buy();
        Girl girl = acac.getBean("girl", Girl.class);
        girl.buy();

    }


}
