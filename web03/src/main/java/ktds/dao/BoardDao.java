package ktds.dao;

import java.util.List;

import ktds.domain.Board;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
  
  @Autowired
  SqlSessionFactory sqlSessionFactory;
  
  public List<Board> selectList() {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      return sqlSession.selectList("ktds.dao.BoardDao.selectList");
    
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    
    } finally {
      sqlSession.close();
    }
  }
  
  public void insert(Board board) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      sqlSession.insert("ktds.dao.BoardDao.insert", board);
      sqlSession.commit();
      
    } catch (Exception e) {
      e.printStackTrace();
    
    } finally {
      sqlSession.close();
    }
  }
  
  public void delete(int no) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      // DBMS의 종류나 그 설정에 따라 다르지만,
      // 기본적으로 insert, delete, update 명령의 결과는 임시 DB에 보관한다.
      sqlSession.delete("ktds.dao.BoardDao.delete", no);
      
      // 임시 DB에 보관된 결과를 원래의 DB에 적용(반영)하라!
      sqlSession.commit();
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
  }
  
  public Board selectOne(int no) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      return sqlSession.selectOne("ktds.dao.BoardDao.selectOne", no);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
      
    } finally {
      sqlSession.close();
    }
  }
  
  public void update(Board board) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      // DBMS의 종류나 그 설정에 따라 다르지만,
      // 기본적으로 insert, delete, update 명령의 결과는 임시 DB에 보관한다.
      sqlSession.update("ktds.dao.BoardDao.update", board);
      
      // 임시 DB에 보관된 결과를 원래의 DB에 적용(반영)하라!
      sqlSession.commit();
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
  }
}












