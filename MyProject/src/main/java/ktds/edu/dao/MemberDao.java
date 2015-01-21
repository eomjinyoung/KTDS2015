package ktds.edu.dao;

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
}












