package utils;

import DAO.IBaseDao;
import Model.Base;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

/**
 * 懒得用spring去注入了，暂时用工具类获取代理dao对象吧 o-_-o
 */
public class DaoUtils {
    private InputStream in;
    private IBaseDao baseDao;
    private SqlSession sqlSession;
    private SqlSessionFactory factory;

    private Class dao;
    public DaoUtils(Class dao){
        this.dao = dao;
    }

    public  Object getDao(){
        //读入主配置文件
        in = Resource .class.getResourceAsStream("/SqlMapConfig.xml");
        //根据主配置文件获取SqlSessionFactory对象
        factory = new SqlSessionFactoryBuilder().build(in);
        //根据factory工厂获取SqlSession对象
        sqlSession = factory.openSession();
        //获取dao的代理对象
        return sqlSession.getMapper(dao);
    }

    public void close() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }



}
