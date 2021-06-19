package cg.software.utils;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {
    private Object target=null;
    public MyInvocationHandler(Object target){
        this.target=target;
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj=null;
        SqlSession sqlSession=null;
        try{
            sqlSession=SqlSessionUtil.getSqlSession();
            obj=method.invoke(target,args);
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
            e.printStackTrace();
            //保持目标类的错误上抛
            throw e.getCause();

        }finally {
            SqlSessionUtil.myClose(sqlSession);
        }
        return obj;
    }
    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    }
}
