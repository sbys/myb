import org.apache.ibatis.session.SqlSession;

import java.util.Map;

/**
 * Created by 12917 on 2017/5/25.
 */
public class DBOperate {

    public int insert(){
        SqlSession sqlSession=GetSqlSession.getSqlSession();
        return sqlSession.insert("");
    }
    //其它删查改类似
}
