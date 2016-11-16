package invokespecial_vs_invokevirtual;

public class InvokeTest {  
   public static void main( String args[] ) {  
	   
	      SubClass5 b = new SubClass5();  
	      SuperClass5 supper = b;              //向上转型引用  
	      System.out.println(supper.method());//invokevirtual，当前引用的对象是b  
	      supper.method();
	      b.subMethod();  
	      b.otherMethod();  
	}  
} 
