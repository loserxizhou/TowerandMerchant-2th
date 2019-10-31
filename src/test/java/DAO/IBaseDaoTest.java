package DAO;

import Model.Base;
import Model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class IBaseDaoTest {
    private InputStream in;
    private IBaseDao baseDao;
    private SqlSession sqlSession;
    private SqlSessionFactory factory;

    @Before
    public void init(){
        //读入主配置文件
        in = Resource.class.getResourceAsStream("/SqlMapConfig.xml");
        //根据主配置文件获取SqlSessionFactory对象
        factory = new SqlSessionFactoryBuilder().build(in);
        //根据factory工厂获取SqlSession对象
        sqlSession = factory.openSession();
        //获取dao的代理对象
        baseDao = sqlSession.getMapper(IBaseDao.class);
    }

    @After
    public void destory() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }
    @Test
    public void test(){
        Base base = baseDao.GetUserSaveByUserid("fc458c0677f44e2f82b479ab17f4a09c");
        System.out.println(base);
    }

    @Test
    public void updata(){
        Base base = new Base();
        base.setBase_uuid("0d1a21d149c1424aa6c6508edb4f727f");
        base.setUser_name("777111");
        int i = baseDao.UpdateNickNameByUserid(base);
        System.out.println(i);
    }

}
