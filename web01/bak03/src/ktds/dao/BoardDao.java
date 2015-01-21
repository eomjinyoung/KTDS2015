package ktds.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletResponse;

import ktds.domain.Board;

public class BoardDao {
  public List<Board> selectList() {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost/ktds", "root", "1234");
      stmt = con.createStatement();
      
      String sql = "select bno,title,cnt,create_date from boards";
      rs = stmt.executeQuery(sql);
      
      ArrayList<Board> list = new ArrayList<Board>();
      Board b = null;
      
      while(rs.next()) {
        b = new Board();
        b.setNo( rs.getInt("bno") );
        b.setTitle( rs.getString("title") );
        b.setCount( rs.getInt("cnt") );
        b.setCreateDate( rs.getDate("create_date") );
        
        list.add(b);
      }
      
      return list;
      
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    } finally {
      try {rs.close();} catch (Exception e) {}
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }
  
  public void insert(Board board) {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost/ktds", "root", "1234");
      
      stmt = con.prepareStatement(
          "insert into boards(title, contents, create_date)"
              + " values(?,?,now())");
      stmt.setString(1, board.getTitle());
      stmt.setString(2, board.getContents());
      stmt.executeUpdate();
      
    } catch (Exception e) {
      e.printStackTrace();
    
    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }
  
  public void delete(int no) {
    Connection con = null;
    Statement stmt = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost/ktds", "root", "1234");
      stmt = con.createStatement();
      stmt.executeUpdate("delete from boards where bno=" + no);
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }
  
  public Board selectOne(int no) {
    
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost/ktds", "root", "1234");
      stmt = con.createStatement();
      
      String sql = "select bno,title,contents,cnt,create_date"
          + " from boards"
          + " where bno=" + no;
      
      rs = stmt.executeQuery(sql);
      
      if (rs.next()) {
        Board board = new Board();
        board.setNo(rs.getInt("bno"));
        board.setTitle(rs.getString("title"));
        board.setContents(rs.getString("contents"));
        board.setCount(rs.getInt("cnt"));
        board.setCreateDate(rs.getDate("create_date"));
        
        return board;
      } else {
        return null;
      }
    } catch (Exception e) {
      e.printStackTrace();
      return null;
      
    } finally {
      try {rs.close();} catch (Exception e) {}
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }
  
  public void update(Board board) {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
            
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost/ktds", "root", "1234");
      
      //참고: ? => in-parameter 라 부른다.
      String sql = "update boards set"
          + " title=?,contents=?,create_date=now() where bno=?";

      stmt = con.prepareStatement(sql);
      stmt.setString(1, board.getTitle());
      stmt.setString(2, board.getContents());
      stmt.setInt(3, board.getNo());
      
      stmt.executeUpdate();
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }
}












