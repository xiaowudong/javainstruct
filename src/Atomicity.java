
public class Atomicity {
	int i=99;
	int j=3;
	String s1="xwd1";
	String s2="xwd1";
	String s3="xwd2";
	
public Atomicity(){
	i=512;
}
	void f1(){
		int k;
		i++;
		System.out.println(i);
	}
	void f2(){i+=1;}
	public static void main(String[] args){
		new Atomicity().f1();
	}
}
