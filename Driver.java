public class Driver {
  public static void main(String[] args) {
    SuperArray a = new SuperArray();
    System.out.println(a);
	//[null,null,null,null,null,null,null,null,null,null]
	
	for(int i = 0; i < 10; i++) {
		a.add("test" + i);
	}
	System.out.println(a);
	//[test0,test1,test2,test3,test4,test5,test6,test7,test8,test9]
	
	a.remove(5);
	a.remove("test3");
	System.out.println(a);
	//[test0,test1,test2,test4,test6,test7,test8,test9,null,null]
	
	a.add(2,"insert");
	System.out.println(a);
	//[test0,test1,insert,test2,test4,test6,test7,test8,test9,null]
	
	a.set(2,"insertedit");
	System.out.println(a);
	//[test0,test1,insertedit,test2,test4,test6,test7,test8,test9,null]
	
	a.set(4,"insertedit");
	
	System.out.println(a.contains("test9"));
	//true
	System.out.println(a.contains("earth"));
	//false
	
	System.out.println(a.indexOf("insertedit"));
	//2
	System.out.println(a.indexOf("earth"));
	//-1
	System.out.println(a.lastIndexOf("insertedit"));
	//4
	System.out.println(a.lastIndexOf("earth"));
	//-1
	
	a.add("filler");
	a.add("wow what a big world");
	System.out.println(a);
	//[test0,test1,insertedit,test2,insertedit,test6,test7,test8,test9,filler,wow what a big world,null,null,null,null,null,null,null,null,null]
	
	a.clear();
	System.out.println(a);
	//[null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null]
	
  }




}
