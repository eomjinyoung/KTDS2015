package ktds.edu.dao;

import java.util.HashMap;

import ktds.edu.domain.Member;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
  
  @Autowired
  SqlSessionFactory sqlSessionFactory;
  
  public void insert(Member member) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      sqlSession.insert("ktds.edu.dao.MemberDao.insert", member);
      sqlSession.commit();
      
    } catch (Exception e) {
      e.printStackTrace();
    
    } finally {
      sqlSession.close();
    }
  }

  public Member getLoginInfo(String id, String password) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      HashMap<String,String> params = new HashMap<String,String>();
      params.put("id", id);
      params.put("password", password);
      
      return sqlSession.selectOne(
          "ktds.edu.dao.MemberDao.loginInfo", params);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
      
    } finally {
      sqlSession.close();
    }
  }

  public boolean exist(String id) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      int count = sqlSession.selectOne(
          "ktds.edu.dao.MemberDao.exist", id);
      if (count == 0) 
        return false;
      else 
        return true;
      
    } catch (Exception e) {
      e.printStackTrace();
      return false;
      
    } finally {
      sqlSession.close();
    }
  }
}












