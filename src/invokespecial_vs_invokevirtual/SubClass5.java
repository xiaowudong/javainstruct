package invokespecial_vs_invokevirtual;

public class SubClass5 extends SuperClass5{  
    public String method() {  
        return "from SubClass5...";  
    }  
    public void subMethod() {  
        //call SuperClass5 method()  
        System.out.println("SubClass5 calls super.method(): " +   
        super.method());  
    }  
} 
