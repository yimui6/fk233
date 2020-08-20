package org.dao;

import org.apache.ibatis.session.SqlSession;
import org.utils.MybatisUtils;
import org.junit.Test;
import org.pojo.Users;
public class UserMapperTest {

    private Object MybatisUtils;

    @Test
    public void insert(){
        // 1 获取会话
        SqlSession session = MybatisUtils.createSqlSession();
        // 2 得到接口的实例 StudentMapper实例，接口有没有实现类？ 这里是mybatis 使用动态代理技术完成的
        UserMapper UserMapper = session.getMapper(UserMapper.class); // 传入一个参数，就是类类型Class
        // 3 操作内容
        Users User = new Users();
        User.setUsername("刘菲");
        User.setMobile("18645633221");
        User.setMail("18645633221@163.com");
        User.setPassword("123456");
        User.setCreate_date("2020-08-20 19:46:12");
        // 4 调用insert 方法
        UserMapper.insert(User);
        // 5 提交事务
        session.commit();
        // 6 记得关闭会话
        session.close();
    }
}