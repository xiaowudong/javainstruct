
public class EnumTest {
	public enum tEnum{xwd1,xwd2,xwd3}
	public class xwdT{
		public String xwd1;
		public String xwd2;
		public String xwd3;
		public void say(){
			
		}
	}
	public static void main(String[] args){
		for(tEnum t : tEnum.values()){
			System.out.println(t);
		}
		
		
	}
}
