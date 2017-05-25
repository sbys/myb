import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.InputStream;

/**
 * Created by 12917 on 2017/5/25.
 */
public class GetSqlSessionFactory {
    private static SqlSessionFactory sqlSessionFactory;
    private GetSqlSessionFactory(){}
    synchronized public static SqlSessionFactory getSqlSessionFactory(){
        try{
            if(sqlSessionFactory==null){
                String resource="mybatis-config.xml";
                InputStream inputStream= Resources.getResourceAsStream(resource);
                sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);

            }
            else
            {}
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }
}
