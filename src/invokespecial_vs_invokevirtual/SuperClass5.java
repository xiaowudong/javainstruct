package invokespecial_vs_invokevirtual;

public class SuperClass5 {  
    public String method() {  
        return "from SuperClass5...";  
   }  
   public void otherMethod() {  
       System.out.println("In SuperClass5 otherMethod()...");  
       //invokespecialÀý×Ó  
       System.out.println("SuperClass5 otherMethod() calls method(): " +   
       method());  
   }  
}
