package ktds.domain;

import java.util.Date;

public class Board {
  protected int no;
  protected String title;
  protected String contents;
  protected int count;
  protected Date createDate;
  
  // property란? getter/setter 를 말한다.
  // property 이름이란? 
  // getter/setter 메서드의 이름 - (get or set) + 첫 알파벳 소문자 변경
  // 예) getNo/setNo => no
  // 예) getFirstName()/setFirstName() => firstName
  // 예) getLastName()/setLastname() => lastName, lastname 두개의 프로퍼티다!
  public int getNo() {
    return no;
  }
  public Board setNo(int no) {
    this.no = no;
    return this;
  }
  public String getTitle() {
    return title;
  }
  public Board setTitle(String title) {
    this.title = title;
    return this;
  }
  public String getContents() {
    return contents;
  }
  public Board setContents(String contents) {
    this.contents = contents;
    return this;
  }
  public int getCount() {
    return count;
  }
  public Board setCount(int count) {
    this.count = count;
    return this;
  }
  public Date getCreateDate() {
    return createDate;
  }
  public Board setCreateDate(Date createDate) {
    this.createDate = createDate;
    return this;
  }
  
  
}
