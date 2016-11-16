import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class WatchJavaP {
    public static void main(String[] args){

          Runtime   r=Runtime.getRuntime();  
          Process   p = null;
          Process   p1 = null;
          File f=new File("G:/projectdoing/javainstruct/src/");
//          subPath="./initialization/";
          String className="Atomicity";
          File outF=new File("C:/Users/Administrator/Desktop/byteCode.html");
          try{ 
        	  p1=r.exec("cmd /c javac "+className+".java",null,f);
        	  BufferedReader reader=null;
        	  reader = new BufferedReader(new InputStreamReader(p1.getInputStream()));
              String  message = new String("");
              while( (message = reader.readLine()) != null){
            	  System.out.println(message);
              }
              p = r.exec("cmd /c javap -verbose "+className,null,f);
              reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
              PrintWriter pw=new PrintWriter(outF);
              OutputHTML.outputHTML(pw,reader);
              pw.close();
          }catch   (Exception   ex){ 
        	  System.out.println("失败");
        	  ex.printStackTrace();
          }
          System.out.println("处理完成");
    }
}