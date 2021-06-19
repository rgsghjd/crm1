package cg.software.utils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
    private static SqlSessionFactory sqlSessionFactory=null;
    private SqlSessionUtil(){};
    static {
        String resource="mybatis.xml";
        try {
            InputStream fi= Resources.getResourceAsStream(resource);
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
            sqlSessionFactory=sqlSessionFactoryBuilder.build(fi);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession getSqlSession(){

        SqlSession sqlSession=sqlSessionFactory.openSession();
        return sqlSession;
    }
    public  static void myClose(SqlSession sqlSession){
        if(sqlSession != null){
            sqlSession.close();
        }
    }
}
