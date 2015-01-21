package ktds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import ktds.board.InitServlet;
import ktds.domain.Board;
import ktds.util.DBConnectionPool;

import org.apache.ibatis.session.SqlSession;

public class BoardDao {
  public List<Board> selectList() {
    SqlSession sqlSession = InitServlet.sqlSessionFactory.openSession();
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
    SqlSession sqlSession = InitServlet.sqlSessionFactory.openSession();
    
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
    SqlSession sqlSession = InitServlet.sqlSessionFactory.openSession();
    
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
    SqlSession sqlSession = InitServlet.sqlSessionFactory.openSession();
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
    SqlSession sqlSession = InitServlet.sqlSessionFactory.openSession();
    
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












