package invokespecial_vs_invokevirtual;

public class InvokeTest {  
   public static void main( String args[] ) {  
	   
	      SubClass5 b = new SubClass5();  
	      SuperClass5 supper = b;              //����ת������  
	      System.out.println(supper.method());//invokevirtual����ǰ���õĶ�����b  
	      supper.method();
	      b.subMethod();  
	      b.otherMethod();  
	}  
} 
