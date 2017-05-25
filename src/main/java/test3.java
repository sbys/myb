import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import orm.Userinfo;
import orm.UserinfoExample;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 12917 on 2017/5/24.
 */
public class test3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            Userinfo userinfo=new Userinfo();
            UserinfoExample userinfoExample=new UserinfoExample();

            userinfo.setName("shabi");
            userinfo.setPassword("HAHAHA");
            String resource="mybatis-config.xml";
            InputStream inputStream= Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession=sqlSessionFactory.openSession();
            sqlSession.insert("insert",userinfo);
            //sqlSession.select("select",userinfo);
            Userinfo userinfo1=new Userinfo();
            userinfo.setName("shabi");
            List<Userinfo> list=sqlSession.selectList("selectbyname","shabi");
            System.out.println(list.size());
            for(int i=0;i<list.size();i++){
                System.out.println(list.get(i).getName()+"  "+list.get(i).getPassword());
            }
            //sqlSession.selectOne("name","yuanshuai");

            sqlSession.commit();
            sqlSession.rollback();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
