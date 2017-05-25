import org.apache.ibatis.session.SqlSession;

/**
 * Created by 12917 on 2017/5/25.
 */
public class GetSqlSession {
    private static ThreadLocal<SqlSession> t1=new ThreadLocal<SqlSession>();
    public static SqlSession getSqlSession(){
        SqlSession sqlSession=t1.get();
        if(sqlSession==null){
            sqlSession= GetSqlSessionFactory.getSqlSessionFactory().openSession();
            t1.set(sqlSession);
        }
        else
        {}

        return sqlSession;
    }
    public static void commit(){
        if(t1.get()!=null){
            t1.get().commit();
            t1.get().close();
            t1.set(null);

        }

    }
    public static void rollback(){
        if(t1.get()!=null){
            t1.get().rollback();
            t1.get().close();
            t1.set(null);


        }
    }

}
