package DAO;

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

public class IUserDAOTest {
    private InputStream in;
    private IUserDao userDao;
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
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destory() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    /**
     * 测试保存用户
     */
    @Test
    public void insertTest(){
        //执行方法
        User user = new User();
        String user_uuid = UUID.randomUUID().toString().replaceAll("-", "");
        user.setUuid(user_uuid);
        user.setAccount("7777");
        user.setPassword("123345");
        userDao.InsertUser(user);
        sqlSession.commit();
    }

    /**
     * 测试根据account判断用户是否存在
     */
    @Test
    public void JudgeAccountExist(){
        String account = "7777";
        User user = userDao.JudgeAccountExist(account);
        if (user!=null){
            System.out.println("该用户存在");
        }else {
            System.out.println("该用户不存在");
        }
    }

    /**
     * 用户登录
     */
    @Test
    public void UserLogin(){
        User user = new User();
        user.setPassword("123345");
        user.setAccount("7777");
        User user1 = userDao.UserLogin(user);
        if (user1!=null){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }

    }
}
