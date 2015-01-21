package ktds.extra;

public class Test01 {

  public static void main(String[] args) {
    class Car {
      void m1() {}
    }
    class Tico extends Car{
      void m2() {}
    }
    
    Tico c = new Tico();
    Car c2 = new Car();
    
    c.m1();
    c.m2();
    
    c2.m1();
    ((Tico)c2).m2();
  }

}








