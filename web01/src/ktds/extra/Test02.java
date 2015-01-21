package ktds.extra;

public class Test02 {

  public static void main(String[] args) {
    int i = 10;
    Integer i2 = new Integer(10);
    
    int x = i;
    int x2 = i2; // 내부적으로 다음 호출문을 실행한다. i2.intValue() => unboxing
    
    Integer x3 = i2;
    Integer x4 = i; // 내부적으로 다음 호출문을 실행한다. new Integer(i) => boxing
    
    // 이렇게 컴파일러가 자동으로 boxing, unboxing 하는 것을 auto-boxing이라 한다.
    
  }

}
