//Դ����   
package hr.test;   
//ClassTest��   
public class ClassTest {   
    private int itemI=0;  //itemI���ֶ�  
    private static String itemS="����"; //itemS���ֶ�  
    private final float PI=3.1415926F;  //PI���ֶ�  
    //����������   
    public ClassTest(){   
    }   
    //getItemI����  
    public int getItemI(){   
        return this.itemI;   
    }   
    //getItemS����  
    public static String getItemS(){   
        return itemS;   
    }   
    //main������   
    public static void main(String[] args) {   
        ClassTest ct=new ClassTest();   
    }   
}   