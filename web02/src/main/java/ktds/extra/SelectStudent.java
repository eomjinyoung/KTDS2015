package ktds.extra;

public class SelectStudent {

  public static void main(String[] args) throws Exception {
    String[] students = {"송희문", "이창희", "이동희", "모상수", "홍동진", 
        "우수연", "박민성", "이채연", "송희주", "이해봄", "이현하",
        "박지현", "이명진", "김예지", "방은희", "이경현", "김태희"};
    
    for (int i = 0; i < 10; i++) {
      System.out.println(students[(int)(Math.random() * 17)]);
      Thread.sleep(500);
    }
    Thread.sleep(3000);
    System.out.println("당첨자:" + students[(int)(Math.random() * 17)]);
    

  }

}
