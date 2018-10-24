public class Driver {
  public static void main(String[] args) {
    SuperArray a = new SuperArray();
    System.out.println(a);
	for(int i = 0; i < 10; i++) {
		a.add("test" + i);
	}
	System.out.println(a);
	
	
  }




}
