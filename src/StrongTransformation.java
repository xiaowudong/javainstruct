import java.util.HashMap;
import java.util.Map;


public class StrongTransformation {
	
	public static void  f1(){
		double d1=0.1;
		int i1=0;
		i1=(int) d1;
		System.out.println(i1);
	}
	public static void f2(){
		Map map=new HashMap();
		map.put("xwd","xiaowudong3");
		String  s1=(String)map.get("xwd");
		System.out.println(s1);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StrongTransformation.f1();
	}

}
